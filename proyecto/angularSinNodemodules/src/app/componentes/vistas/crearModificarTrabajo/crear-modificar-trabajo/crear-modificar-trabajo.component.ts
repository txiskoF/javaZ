import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/clases/categoria';
import { Trabajo } from 'src/app/clases/trabajo';
import { CategoriasService } from 'src/app/servicios/categorias.service';
import { DatosService } from 'src/app/servicios/datos.service';
import { TrabajosService } from 'src/app/servicios/trabajos.service';

@Component({
  selector: 'app-crear-modificar-trabajo',
  templateUrl: './crear-modificar-trabajo.component.html',
  styles: [
  ]
})
export class CrearModificarTrabajoComponent implements OnInit {

  crearModificar: string = 'crear';
  datosTrabajo:Trabajo = new Trabajo();
  listadoCategorias:Array<Categoria>;
  categoriaSeleccionada:number = 0;
  trabajoActualizadoOK:boolean = false;
  trabajoCreadoOK:boolean = false;
  errorEnCategoria:boolean = false;
  errorEnDescripcion:boolean = false;
  errorEnPrecio:boolean = false;

  constructor(
    private datosService: DatosService,
    private categoriasService: CategoriasService,
    private trabajosService: TrabajosService
  ) { }

  ngOnInit(): void {
    this.crearModificar = this.datosService.crearModificarTrabajo;
    this.trabajoActualizadoOK = false;
    this.trabajoCreadoOK = false;

    this.categoriasService.buscarCategorias().subscribe(
      (respuesta:Array<Categoria>) => {
        this.listadoCategorias = respuesta;
      }
    );

    if(this.crearModificar == 'crear'){
      this.datosTrabajo = new Trabajo();
      this.categoriaSeleccionada = 0;
    }else{
      this.trabajosService.buscarTrabajoPorId(this.datosService.idTrabajoEditar).subscribe(
        (respuesta: Trabajo) => {
          this.datosTrabajo = respuesta;
          this.categoriaSeleccionada = this.datosTrabajo.idCategoria;
        }
      );
    }
  }

  datosTrabajoValidos(): boolean{
    this.errorEnCategoria = (this.categoriaSeleccionada == 0);

    this.errorEnDescripcion = (this.datosTrabajo.trabajo == null || this.datosTrabajo.trabajo.length == 0);

    this.errorEnPrecio = (this.datosTrabajo.precio == null || this.datosTrabajo.precio == 0);

    return !this.errorEnCategoria && !this.errorEnDescripcion && !this.errorEnPrecio;
  }

  modificar(){
    if(this.datosTrabajoValidos()){
      console.log("voy a guardar el trabajo " + JSON.stringify(this.datosTrabajo));
      this.trabajosService.modificarTrabajo(this.datosTrabajo).subscribe(
        (respuesta:Trabajo) => {
          //la respuesta del back es el trabajo guardado
          this.trabajoActualizadoOK = true;
        }
      );
    }
  }

  crear(){
    if(this.datosTrabajoValidos()){
      this.datosTrabajo.idCategoria = this.categoriaSeleccionada;
      console.log("validado OK, voy a crear el trabajo " + JSON.stringify(this.datosTrabajo));
      this.trabajosService.crearTrabajo(this.datosTrabajo).subscribe(
        (respuesta:any) => {
          this.trabajoCreadoOK = true;
        }
      );
    }
    
  }

}
