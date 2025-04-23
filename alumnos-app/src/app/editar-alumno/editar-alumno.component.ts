import { Component } from '@angular/core';
import { Alumno } from '../alumno';
import { AlumnoService } from '../alumno.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-alumno',
  standalone: false,
  
  templateUrl: './editar-alumno.component.html',
  styleUrl: './editar-alumno.component.css'
})
export class EditarAlumnoComponent {

  alumno: Alumno = new Alumno();
  id: number;

  constructor(private alumnoServicio: AlumnoService, private ruta: ActivatedRoute,
  private enrutador: Router){}

  ngOnInit(){
    this.id = this.ruta.snapshot.params['id'];
    this.alumnoServicio.obtenerAlumnoPorId(this.id).subscribe(
      {
        next: (datos) => this.alumno = datos,
        error: (errores: any) => console.log(errores)
      }
    );
  }

  onSubmit(){
    this.guardarAlumno();
  }

  guardarAlumno(){
    this.alumnoServicio.guardarAlumno(this.id, this.alumno).subscribe(
      {
        next: (datos) => this.irAlumnoLista(),
        error: (errores) => console.log(errores)
      }
    );
  }

  irAlumnoLista(){
    this.enrutador.navigate(['/alumnos'])
  }


}
