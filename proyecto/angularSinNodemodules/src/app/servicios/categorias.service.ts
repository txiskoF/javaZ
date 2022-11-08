import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {
  private url="http://localhost:8081";

  constructor(private http:HttpClient) { }

  buscarCategorias(){
    return this.http.get(
      this.url + '/categorias'
    )
  }

}
