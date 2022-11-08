import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Paciente } from 'src/app/clases/paciente';
import { DatosService } from 'src/app/servicios/datos.service';
import { PacientesService } from 'src/app/servicios/pacientes.service';

@Component({
  selector: 'app-buscar-paciente',
  templateUrl: './buscar-paciente.component.html',
  styles: [
  ]
})
export class BuscarPacienteComponent implements OnInit {

  radioNifSsn: string='nif';
  nif:string='';
  ssn:string='';
  busquedaRealizada:boolean = false;
  pacienteEncontrado:boolean = false;
  nombreCompletoPaciente:string ='';

  constructor(
    private servicioPacientes:PacientesService, 
    private servicioDatos:DatosService,
    private router:Router) { }

  ngOnInit(): void {
  }

  buscarPaciente(){ 
    if(this.radioNifSsn == 'nif'){
      //llamar al metodo del servicio buscar paciente por nif
      this.servicioPacientes.buscarPacienteNif(this.nif).subscribe(
        (paciente:Paciente) => {
          this.busquedaRealizada = true;
          if (paciente.nombre == null){
            //no se ha encontrado ese paciente
            this.pacienteEncontrado = false;
          } else {
            //se ha encontrado al paciente
            this.pacienteEncontrado = true;
            this.servicioDatos.datosPaciente = paciente;
            this.nombreCompletoPaciente = paciente.nombre + ' ' + paciente.primerApellido + 
             ' ' + paciente.segundoApellido + ', nif: ' + paciente.nif + ', ssn: ' + paciente.ssn;
          }
        }
      );
    } else {
      //llamar al metodo del servicio buscar paciente por ssn
      this.servicioPacientes.buscarPacienteSsn(this.ssn).subscribe(
        (paciente:Paciente) => {
          this.busquedaRealizada = true;
          if (paciente.nombre == null){
            //no se ha encontrado ese paciente
            this.pacienteEncontrado = false;
          } else {
            //se ha encontrado al paciente
            this.pacienteEncontrado = true;
            this.servicioDatos.datosPaciente = paciente;
            this.nombreCompletoPaciente = paciente.nombre + ' ' + paciente.primerApellido + 
             ' ' + paciente.segundoApellido + ', nif: ' + paciente.nif + ', ssn: ' + paciente.ssn;
          }
        }
      );
    }
  }

  modificarPaciente(){
    this.servicioDatos.crearModificarPaciente = 'modificar';
    this.router.navigate(['/pacientesCrearModificar']);
  }

  limpiar(){
    this.nif ="";
    this.ssn ="";
  }

  eliminarPaciente(){
    let paciente:Paciente = this.servicioDatos.datosPaciente;
    let texto = "Datos del paciente: " + paciente.nombre + " "
      + paciente.primerApellido + " " + paciente.segundoApellido
      + "\n" + paciente.direccion + " " + paciente.codPostal + " " + paciente.municipio + " " + paciente.provincia
      + "\n\n¿Confirma que desea eliminarlo de manera permanente?"
      + "\nTambién se eliminarán los servicios que tenga asignados.";
    if(confirm(texto)){
      this.servicioPacientes.eliminarPaciente(paciente.id).subscribe(
        (respuesta:any) => {
          console.log("se ha eliminado el paciente y el back responde " + JSON.stringify(respuesta));
          this.servicioDatos.datosPaciente = new Paciente();
          this.nombreCompletoPaciente = '';
          this.busquedaRealizada = false;
          this.limpiar();
        }
      );
    }
    //else{
    //  le ha dado a cancelar
    //}
  }  

  asignarTrabajoPaciente(){
    this.router.navigate(['/asignarTrabajosPacientes']);
  }

}
