import { Component } from '@angular/core';
import { Alumno } from '../alumno';
import { AlumnoService } from '../alumno.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agregar-alumno',
  standalone: false,
  
  templateUrl: './agregar-alumno.component.html'
})
export class AgregarAlumnoComponent {
  alumno: Alumno = new Alumno();

  constructor(private alumnoServicio: AlumnoService, private enrutador: Router){}

  onSubmit(){
    this.guardarAlumno();
  }

  guardarAlumno(){
    this.alumnoServicio.agregarAlumno(this.alumno).subscribe({

      next: (datos) => {
        this.irListaAlumnos();
      },
      error: (error: any) => {console.log(error)}

    });
  }

  irListaAlumnos(){
    this.enrutador.navigate(['/alumnos']);
  }

}
