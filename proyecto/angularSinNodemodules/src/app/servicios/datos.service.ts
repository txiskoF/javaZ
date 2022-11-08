import { Injectable } from '@angular/core';
import { Empleado } from '../clases/empleado';
import { Paciente } from '../clases/paciente';

@Injectable({
  providedIn: 'root'
})
export class DatosService {

  public datosPaciente:Paciente = new Paciente();
  public crearModificarPaciente:string = 'crear';
  public idTrabajoEditar:number = 0;
  public crearModificarTrabajo:string = 'crear';
  public alguienLogueado:boolean = false;
  public usuarioLogueado:Empleado = new Empleado();
  public rolLogueado:string = '';

  constructor() { }
}
