import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlumnoListaComponent } from './alumno-lista/alumno-lista.component';
import { AgregarAlumnoComponent } from './agregar-alumno/agregar-alumno.component';
import { EditarAlumnoComponent } from './editar-alumno/editar-alumno.component';

const routes: Routes = [
  {path: 'alumnos', component:AlumnoListaComponent},
  {path: '', redirectTo:'alumnos', pathMatch:'full'},
  {path: 'agregar-alumno', component: AgregarAlumnoComponent},
  {path: 'editar-alumno/:id', component: EditarAlumnoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
