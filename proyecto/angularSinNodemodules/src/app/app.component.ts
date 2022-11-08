import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from './clases/empleado';
import { DatosService } from './servicios/datos.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proyectoAngular';
  //crearModificarPaciente: string = 'crear';
  
  alguienLogueado:boolean = false;
  usuarioLogueado:Empleado = new Empleado();
  rolLogueado:string = '';

  constructor(
    private datosService: DatosService,
    private router:Router
  ){}

  ngOnInit(){
    this.alguienLogueado = this.datosService.alguienLogueado;
    this.usuarioLogueado = this.datosService.usuarioLogueado;
    this.rolLogueado = this.datosService.rolLogueado;
    this.router.navigate(['/home']);
  }
  
}
