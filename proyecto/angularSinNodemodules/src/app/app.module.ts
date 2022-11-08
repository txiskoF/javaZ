import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './componentes/home/home.component';
import { BarraNavegacionComponent } from './componentes/barra-navegacion/barra-navegacion.component';
import { CrearModificarTrabajoComponent } from './componentes/vistas/crearModificarTrabajo/crear-modificar-trabajo/crear-modificar-trabajo.component';
import { LoginComponent } from './componentes/vistas/login/login/login.component';
import { BuscarTrabajosComponent } from './componentes/vistas/buscarTrabajos/buscar-trabajos/buscar-trabajos.component';
import { AsignarTrabajosPacientesComponent } from './componentes/vistas/asignarTrabajosPacientes/asignar-trabajos-pacientes/asignar-trabajos-pacientes.component';
import { BuscarPacienteComponent } from './componentes/vistas/buscarPaciente/buscar-paciente/buscar-paciente.component';
import { CrearModificarPacienteComponent } from './componentes/vistas/crearModificarPaciente/crear-modificar-paciente/crear-modificar-paciente.component';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BarraNavegacionComponent,
    CrearModificarTrabajoComponent,
    LoginComponent,
    BuscarTrabajosComponent,
    AsignarTrabajosPacientesComponent,
    BuscarPacienteComponent,
    CrearModificarPacienteComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
