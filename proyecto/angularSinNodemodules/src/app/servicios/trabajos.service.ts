import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Trabajo } from '../clases/trabajo';

@Injectable({
  providedIn: 'root'
})
export class TrabajosService {

  private url="http://localhost:8084";

  constructor(private http:HttpClient) { }

  buscarTrabajosPorIdCategoria(idCategoria: number){
    return this.http.get(
      this.url + '/trabajos/categoria/' + idCategoria
    )
  }

  eliminar(idTrabajo: number){
    return this.http.delete(
      this.url + "/trabajos/" + idTrabajo
    );
  }

  buscarTrabajoPorId(idTrabajo:number){
    return this.http.get(
      this.url + "/trabajos/" + idTrabajo
    )
  }

  modificarTrabajo(trabajo:Trabajo){
    return this.http.put(
      this.url + "/trabajos/" + trabajo.id,
      trabajo
    )
  }

  crearTrabajo(trabajo:Trabajo){
    return this.http.post(
      this.url + "/trabajos",
      trabajo
    )
  }

  getListaTrabajosPorListaIds(listaIds:Array<number>){
    return this.http.post(
      this.url + "/trabajos/trabajosPorIds",
      listaIds
    );
  }
}
