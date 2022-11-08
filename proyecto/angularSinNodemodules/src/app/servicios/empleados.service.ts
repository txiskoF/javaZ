import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {

  public subjectEmpleadoLogueado = new Subject();

  private url="http://localhost:8082";

  constructor(private http:HttpClient) { }

  comprobarLogin(email:string, password:string){
    return this.http.get(
      this.url+"/login/"+email+"/"+password
    );
  }
}
