import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from 'src/app/clases/empleado';
import { DatosService } from 'src/app/servicios/datos.service';
import { EmpleadosService } from 'src/app/servicios/empleados.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
  ]
})
export class LoginComponent implements OnInit {

  email: string = "";
  password: string = "";
  errorEnElLogin: boolean = false;

  constructor(
    private servicioEmpleados:EmpleadosService,
    private datosService:DatosService,
    private router:Router
  ) { }

  ngOnInit(): void {
  }

  login() {
    this.servicioEmpleados.comprobarLogin(this.email, this.password).subscribe(
      (empleado:Empleado) => {
        if (empleado.nombre == null){
          //el login ha sido incorrecto
          this.errorEnElLogin = true;
        } else {
          //login correcto
          this.errorEnElLogin = false;
          this.datosService.alguienLogueado = true;
          this.datosService.usuarioLogueado = empleado;
          this.datosService.rolLogueado = empleado.rol == 'e' ? 'empleado' : 'supervisor';
          this.servicioEmpleados.subjectEmpleadoLogueado.next(empleado);
          this.router.navigate(['/home']);
        }
      }
    )
  }

}
