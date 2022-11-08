import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/clases/empleado';
import { DatosService } from 'src/app/servicios/datos.service';
import { EmpleadosService } from 'src/app/servicios/empleados.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styles: [
  ]
})
export class HomeComponent implements OnInit {

  alguienLogueado:boolean = false;
  usuarioLogueado:Empleado;

  constructor(
    private servicioDatos:DatosService,
    private servicioEmpleados: EmpleadosService
  ) { }

  ngOnInit(): void {
    this.alguienLogueado = this.servicioDatos.alguienLogueado;
    if(this.alguienLogueado){
      this.usuarioLogueado = this.servicioDatos.usuarioLogueado;
    }else{
      this.usuarioLogueado = new Empleado();
    }

    this.servicioEmpleados.subjectEmpleadoLogueado.subscribe(
      (empleado: Empleado) => {
        this.usuarioLogueado = empleado;
        if(empleado.nombre == null || empleado.nombre.length == 0){
          this.alguienLogueado = false;
        }
      }
    );
  }

}
