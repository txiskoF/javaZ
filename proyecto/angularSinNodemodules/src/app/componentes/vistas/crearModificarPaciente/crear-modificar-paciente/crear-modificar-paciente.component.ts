import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Paciente } from 'src/app/clases/paciente';
import { DatosService } from 'src/app/servicios/datos.service';
import { PacientesService } from 'src/app/servicios/pacientes.service';

@Component({
  selector: 'app-crear-modificar-paciente',
  templateUrl: './crear-modificar-paciente.component.html',
  styles: [
  ]
})
export class CrearModificarPacienteComponent implements OnInit {

  paciente: Paciente;
  crearModificar: string ="crear";
  fechaTexto: string;
  pacienteActualizadoOK:boolean = false;
  pacienteCreadoOK:boolean = false;
  errorEnTelefono:boolean = false;
  errorEnFecha:boolean = false;
  errorEnDireccion:boolean = false;
  faltaApellido:boolean = false;
  faltaNombre:boolean = false;
  faltaNif:boolean = false;

  constructor(
    private servicioDatos: DatosService,
    private servicioPacientes: PacientesService,
    private datePipe: DatePipe
  ) { }

  ngOnInit(): void {
    this.crearModificar = this.servicioDatos.crearModificarPaciente;
    console.log("tengo en crearModificar de paciente " + this.crearModificar);
    if (this.crearModificar == 'modificar'){
      this.paciente = this.servicioDatos.datosPaciente;
      this.fechaTexto = this.datePipe.transform(this.paciente.fechaNacimiento, 'yyyy-MM-dd');
    } else {
      console.log("estoy creando" );
      this.paciente = new Paciente();
    }
  }

  datosPacienteValidos(): boolean{
    this.faltaNif = (this.paciente.nif == null || this.paciente.nif.length < 9);
    
    this.faltaNombre = (this.paciente.nombre == null || this.paciente.nombre.length < 3);
    
    this.faltaApellido = (this.paciente.primerApellido == null || this.paciente.primerApellido.length < 3);
    
    this.errorEnTelefono = (this.paciente.telefono <= 99999999);
    
    let fecha = new Date(this.fechaTexto);
    let hoy = new Date();
    this.errorEnFecha = (fecha > hoy);
    
    this.errorEnDireccion = (this.paciente.direccion != null && this.paciente.direccion.length > 100);
    
    return !this.faltaNif && !this.faltaNombre && !this.faltaApellido
      && !this.errorEnTelefono && !this.errorEnFecha && !this.errorEnDireccion;
  }

  crear(){
    //guardar un nuevo paciente
    if(this.datosPacienteValidos()){
      this.paciente.fechaNacimiento = new Date(this.fechaTexto);
      console.log("voy a insertar el paciente " + JSON.stringify(this.paciente));
      this.servicioPacientes.crearPaciente(this.paciente).subscribe(
        (datos:any) => {
          //cuando el paciente se crea correctamente el back responde 201-created con body=null
          this.pacienteCreadoOK = true;
        }
      );
    }
  }

  guardar(){
    //modificar un paciente que ya existe
    if(this.datosPacienteValidos()){      
      this.paciente.fechaNacimiento = new Date(this.fechaTexto);
      
      console.log("voy a modificar el paciente " + JSON.stringify(this.paciente));
      this.servicioPacientes.modificarPaciente(this.paciente).subscribe(
        (pacienteModificado: Paciente) => {
          //actualizo los datos del paciente guardados en el servicio de datos con el paciente actualizado
          this.servicioDatos.datosPaciente = pacienteModificado;
          this.pacienteActualizadoOK = true;
        }
      );
    }
  }

}
