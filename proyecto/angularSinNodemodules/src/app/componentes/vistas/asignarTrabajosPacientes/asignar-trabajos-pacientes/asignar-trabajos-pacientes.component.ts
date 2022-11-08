import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/clases/categoria';
import { Paciente } from 'src/app/clases/paciente';
import { Trabajo } from 'src/app/clases/trabajo';
import { TrabajoPaciente } from 'src/app/clases/trabajo-paciente';
import { CategoriasService } from 'src/app/servicios/categorias.service';
import { DatosService } from 'src/app/servicios/datos.service';
import { TrabajoPacienteService } from 'src/app/servicios/trabajo-paciente.service';
import { TrabajosService } from 'src/app/servicios/trabajos.service';

@Component({
  selector: 'app-asignar-trabajos-pacientes',
  templateUrl: './asignar-trabajos-pacientes.component.html',
  styles: [
  ]
})
export class AsignarTrabajosPacientesComponent implements OnInit {

  paciente:Paciente;
  listadoTrabajosContratados:Array<Trabajo>;
  listadoTrabajosDisponibles:Array<Trabajo>;
  listadoCategorias:Array<Categoria>;
  categoriaSeleccionada:number = 0;
  trabajosDisponiblesEncontrados:boolean = false;
  trabajosDisponiblesBuscados:boolean = false;

  constructor(
    private datosService:DatosService,
    private trabajosPacienteService:TrabajoPacienteService,
    private trabajosService:TrabajosService,
    private categoriasService: CategoriasService
  ) { }

  ngOnInit(): void {
    this.paciente = this.datosService.datosPaciente;
    //recupero los trabajoPaciente del paciente
    //por cada trabajoPaciente que tenga, recuperar el trabajo
    this.trabajosPacienteService.buscarTrabajosPacientePorPacienteId(this.paciente.id).subscribe(
      (listaRespuesta:Array<TrabajoPaciente>) => {
        let listaIdsTrabajos:Array<number> = [];
        for(let trabPac of listaRespuesta){
          listaIdsTrabajos.push(trabPac.idTrabajo);
        }
        this.trabajosService.getListaTrabajosPorListaIds(listaIdsTrabajos).subscribe(
          (listaTrabajosRespuesta:Array<Trabajo>) => {
            this.listadoTrabajosContratados = listaTrabajosRespuesta;
          }
        );
      }
    );
    this.categoriasService.buscarCategorias().subscribe(
      (respuesta: Array<Categoria>) => {
        this.listadoCategorias = respuesta;
      }
    );
  }

  buscarTrabajosDisponibles(){
    console.log("tengo en categoriaSeleccionada " + this.categoriaSeleccionada);
    this.trabajosService.buscarTrabajosPorIdCategoria(this.categoriaSeleccionada).subscribe(
      (listaTrabajos:Array<Trabajo>) => {
        this.trabajosDisponiblesBuscados = true;
        
        if(listaTrabajos == null || listaTrabajos.length == 0){
          this.trabajosDisponiblesEncontrados = false;
        }else{
          //los trabajos ya contratados no deben aparecer como disponibles
          for(let trab of this.listadoTrabajosContratados){
            //si el trabajo contratado esta en la lista de disponibles, sacarlo de la lista de disponibles
            let posicionEnDisponibles = this.posicion(trab.id, listaTrabajos);
            if(posicionEnDisponibles > -1){
              listaTrabajos.splice(posicionEnDisponibles, 1);
            }
          }
          this.trabajosDisponiblesEncontrados = (listaTrabajos.length > 0);
          this.listadoTrabajosDisponibles = listaTrabajos;
        }

        
      }
    );
  }

  //listado.indexOf no funciona para buscar un trabajo en las listas de contratados y disponibles
  //esta funcion si funciona
  posicion(idTrabajo:number, listaTrabajos:Array<Trabajo>):number{
    let posicion = -1;
    let encontrado = false;
    let i = 0;
    while(i < listaTrabajos.length && !encontrado){
      if(listaTrabajos[i].id == idTrabajo){
        encontrado = true;
      }else{
        i++;
      }
    }
    if(encontrado){
      posicion = i;
    }
    return posicion;
  }

  descontratar(idTrabajo:number){
    console.log("al paciente " + this.paciente.id + ", descontratarle el trabajo " + idTrabajo);
    this.trabajosPacienteService.eliminarTrabajoPacientePorIdTrabajoIdPaciente(idTrabajo, this.paciente.id).subscribe(
      (respuesta:any) => {
        console.log("eliminado");
        //la respuesta del back es vacia
        //quitar el trabajo de la lista de trabajos contratados
        this.listadoTrabajosContratados.splice(this.posicion(idTrabajo, this.listadoTrabajosContratados), 1)
        
        //limpiar la busqueda de disponibles
        this.listadoTrabajosDisponibles = [];
        this.categoriaSeleccionada = 0;
        this.trabajosDisponiblesEncontrados = false;
        this.trabajosDisponiblesBuscados = false;
      }
    );
  }

  contratar(trabajo:Trabajo){
    //llamar al back para que lo guarde en base de datos
    this.trabajosPacienteService.crear(trabajo.id, this.paciente.id).subscribe(
      (respuesta:any) => {
        //la respuesta del back es vacia
        //quitar el trabajo contratado de la lista de disponibles
        console.log("esta en la posicion " + this.posicion(trabajo.id, this.listadoTrabajosDisponibles));
        this.listadoTrabajosDisponibles.splice(this.posicion(trabajo.id, this.listadoTrabajosDisponibles), 1);
        
        //añadir el trabajo contratado a la lista de contratados
        this.listadoTrabajosContratados.push(trabajo);
      }
    );

  }

}
