import { Component } from '@angular/core';
import { Alumno } from '../alumno';
import { AlumnoService } from '../alumno.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alumno-lista',
  standalone: false,
  
  templateUrl: './alumno-lista.component.html',
  styleUrl: './alumno-lista.component.css'
})
export class AlumnoListaComponent {
  alumnos: Alumno[];

  constructor(private alumnoServicio: AlumnoService, private enrutador: Router){}

  ngOnInit(){
    this.obtenerAlumnos();
  }

  private obtenerAlumnos(){
    this.alumnoServicio.obtenerAlumnoLista().subscribe(
      (datos => {
        this.alumnos = datos;
      })
    )
  }

  editarAlumno(id: number){
    this.enrutador.navigate(['editar-alumno', id]);
  }

  eliminarAlumno(id: number){
    this.alumnoServicio.eliminarAlumno(id).subscribe(
      {
        next: (datos) => this.obtenerAlumnos(),
        error: (errores) => console.log(errores)
      }
    )
  }

}
