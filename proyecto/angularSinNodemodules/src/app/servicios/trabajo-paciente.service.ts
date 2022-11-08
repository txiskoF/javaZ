import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TrabajoPaciente } from '../clases/trabajo-paciente';

@Injectable({
  providedIn: 'root'
})
export class TrabajoPacienteService {

  private url="http://localhost:8085";

  constructor(private http:HttpClient) { }

  buscarTrabajosPacientePorPacienteId(idPaciente:number){
    return this.http.get(
      this.url + "/trabajosPaciente/" + idPaciente
    );
  }

  eliminarTrabajoPacientePorIdTrabajoIdPaciente(idTrabajo:number, idPaciente:number){
    return this.http.delete(
      this.url + "/trabajosPaciente/" + idTrabajo + "/" + idPaciente
    )
  }

  crear(idTrabajo:number, idPaciente:number){
    let trabajoPaciente:TrabajoPaciente = new TrabajoPaciente();
    trabajoPaciente.idPaciente = idPaciente;
    trabajoPaciente.idTrabajo = idTrabajo;

    return this.http.post(
      this.url + "/trabajosPaciente",
      trabajoPaciente
    );
  }
}
