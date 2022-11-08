import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';
import { Categoria } from 'src/app/clases/categoria';
import { Trabajo } from 'src/app/clases/trabajo';
import { CategoriasService } from 'src/app/servicios/categorias.service';
import { DatosService } from 'src/app/servicios/datos.service';
import { TrabajosService } from 'src/app/servicios/trabajos.service';

@Component({
  selector: 'app-buscar-trabajos',
  templateUrl: './buscar-trabajos.component.html',
  styles: [
  ]
})
export class BuscarTrabajosComponent implements OnInit {

  categoriaSeleccionada: number = 0;
  listadoCategorias:Array<Categoria>;
  listadoTrabajos:Array<Trabajo>;
  hayTrabajos:boolean = false;
  busquedaRealizada:boolean = false;
  datosTrabajo:Trabajo;
  rolLogueado:string = '';

  constructor(
    private trabajosService: TrabajosService,
    private categoriasService: CategoriasService,
    private datosService: DatosService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.categoriasService.buscarCategorias().subscribe(
      (respuesta: Array<Categoria>) => {
        this.listadoCategorias = respuesta;
        this.rolLogueado = this.datosService.rolLogueado;
      }
    );
  }

  buscar(){
    this.trabajosService.buscarTrabajosPorIdCategoria(this.categoriaSeleccionada).subscribe(
      (respuesta:Array<Trabajo>) => {
        console.log("buscados todos los trabajos de la categoria " + this.categoriaSeleccionada);
        console.log("he obtenido " + JSON.stringify(respuesta));
        this.listadoTrabajos = respuesta;
        this.busquedaRealizada = true;
        if(this.listadoTrabajos.length > 0){
          this.hayTrabajos = true;
        }else{
          this.hayTrabajos = false;
        }
      }
    );
  }

  editar(idTrabajo:number){
    console.log("voy a editar el trabajo con id " + idTrabajo);
    this.datosService.idTrabajoEditar = idTrabajo;
    this.datosService.crearModificarTrabajo = 'modificar';
    this.router.navigate(['/trabajosCrearModificar']);
  }

  borrar(idTrabajo: number){
    console.log("voy a eliminar el trabajo con id " + idTrabajo);
    //recupero el trabajo completo llamando al back
    this.trabajosService.buscarTrabajoPorId(idTrabajo).subscribe(
      (respuesta:Trabajo) => {
        this.datosTrabajo = respuesta;
        let texto = '¿Confirma que desea eliminar el trabajo "' + this.datosTrabajo.trabajo
          + '" de precio ' + this.datosTrabajo.precio + '€?';
        if(confirm(texto)){
          this.trabajosService.eliminar(idTrabajo).subscribe(
            (respuesta:any) => {
              //el back responde con null si se ha borrado correctamente
              //llamo al metodo buscar para recargar la tabla
              this.buscar();
            },
            (error:any) => {
              console.log("el back ha devuelto un error porque el trabajo no se puede eliminar");
              alert('El trabajo "' + this.datosTrabajo.trabajo + '" no se puede eliminar porque algún cliente lo tiene contratado');
            }
          );
        }
      }
    );
  }

  crearTrabajo(){
    this.datosService.idTrabajoEditar = 0;
    this.datosService.crearModificarTrabajo = 'crear';
    this.router.navigate(['/trabajosCrearModificar']);
  }

}
