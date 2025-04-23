import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Alumno } from './alumno';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {

  private urlBase = "http://localhost:8081/alumnos-api/alumnos"

  constructor(private clienteHttp: HttpClient) { }

  obtenerAlumnoLista(): Observable<Alumno[]>{
    return this.clienteHttp.get<Alumno[]>(this.urlBase);
    
  }

  agregarAlumno(alumno: Alumno): Observable<Object>{
    return this.clienteHttp.post(this.urlBase, alumno);
  }

  obtenerAlumnoPorId(id: number){
    return this.clienteHttp.get<Alumno>(`${this.urlBase}/${id}`)
  }

  guardarAlumno(id: number, alumno: Alumno): Observable<Object>{
    return this.clienteHttp.put(`${this.urlBase}/${id}`, alumno);
  }

  eliminarAlumno(id: number): Observable<Object>{
    return this.clienteHttp.delete(`${this.urlBase}/${id}`)
  }
}
