import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from 'src/app/clases/empleado';
import { Paciente } from 'src/app/clases/paciente';
import { DatosService } from 'src/app/servicios/datos.service';
import { EmpleadosService } from 'src/app/servicios/empleados.service';

@Component({
  selector: 'app-barra-navegacion',
  templateUrl: './barra-navegacion.component.html',
  styles: [
  ]
})
export class BarraNavegacionComponent implements OnInit {

  alguienLogueado:boolean = false;

  constructor(
    private servicioDatos:DatosService, 
    private empleadoService:EmpleadosService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.empleadoService.subjectEmpleadoLogueado.subscribe(
      (empleado:Empleado) => {
        this.alguienLogueado = this.servicioDatos.alguienLogueado;
      }
    );
  }

  irACrear(){
    this.servicioDatos.datosPaciente = new Paciente();
    this.servicioDatos.crearModificarPaciente = "crear";
    //this.router.navigate(['/pacientesCrearModificar'], {skipLocationChange: true});
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(
      () => {this.router.navigate(['/pacientesCrearModificar'])}
    );
  }

  cerrarSesion(){
    this.alguienLogueado = false;
    this.servicioDatos.alguienLogueado = false;
    this.servicioDatos.usuarioLogueado = new Empleado();
    this.servicioDatos.rolLogueado = 'empleado';
    this.empleadoService.subjectEmpleadoLogueado.next(new Empleado());
    this.router.navigate(['/home'])
  }

}
