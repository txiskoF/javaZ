import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './componentes/home/home.component';
import { AsignarTrabajosPacientesComponent } from './componentes/vistas/asignarTrabajosPacientes/asignar-trabajos-pacientes/asignar-trabajos-pacientes.component';
import { BuscarPacienteComponent } from './componentes/vistas/buscarPaciente/buscar-paciente/buscar-paciente.component';
import { BuscarTrabajosComponent } from './componentes/vistas/buscarTrabajos/buscar-trabajos/buscar-trabajos.component';
import { CrearModificarPacienteComponent } from './componentes/vistas/crearModificarPaciente/crear-modificar-paciente/crear-modificar-paciente.component';
import { CrearModificarTrabajoComponent } from './componentes/vistas/crearModificarTrabajo/crear-modificar-trabajo/crear-modificar-trabajo.component';
import { LoginComponent } from './componentes/vistas/login/login/login.component';


const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'trabajosCrearModificar', component:CrearModificarTrabajoComponent},
  {path:'trabajosBuscar', component:BuscarTrabajosComponent},
  {path:'pacientesCrearModificar', component:CrearModificarPacienteComponent},
  {path:'pacientesBuscar', component:BuscarPacienteComponent},
  {path:'asignarTrabajosPacientes', component:AsignarTrabajosPacientesComponent},
  {path:'trabajosCrearModificar', component:CrearModificarTrabajoComponent},
  {path:'login', component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
