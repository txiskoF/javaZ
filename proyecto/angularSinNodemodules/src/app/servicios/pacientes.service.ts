import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Paciente } from '../clases/paciente';

@Injectable({
  providedIn: 'root'
})
export class PacientesService {

  private url="http://localhost:8083";

  constructor(private http:HttpClient) { }

  buscarPacienteNif(nif:string){
    return this.http.get(
      this.url+"/pacientes/pacientenif/" + nif
    );
  }

  buscarPacienteSsn(ssn:string){
    return this.http.get(
      this.url+"/pacientes/pacientessn/" + ssn
    );
  }

  crearPaciente(paciente:Paciente){
    return this.http.post(
      this.url+"/pacientes",
      paciente
    );
  }

  modificarPaciente(paciente:Paciente){
    console.log("voy a modificar el paciente con id " + paciente.id);
    /*let cabeceras = new HttpHeaders();
    cabeceras.append('Access-Control-Allow-Origin', '*');
    cabeceras.append("Access-Control-Allow-Credentials", "true");
    cabeceras.append("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
    cabeceras.append("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    cabeceras.append('Content-Type', 'application/json');*/
    return this.http.put(
      this.url + '/pacientes/' + paciente.id, 
      paciente/*,
      {headers: cabeceras}*/);
  }

  eliminarPaciente(idPaciente:number){
    return this.http.delete(
      this.url + '/pacientes/' + idPaciente
    )
  }
}
