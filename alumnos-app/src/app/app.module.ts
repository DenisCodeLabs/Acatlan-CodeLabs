import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlumnoListaComponent } from './alumno-lista/alumno-lista.component';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { AgregarAlumnoComponent } from './agregar-alumno/agregar-alumno.component';
import { FormsModule} from '@angular/forms';
import { EditarAlumnoComponent } from './editar-alumno/editar-alumno.component';

@NgModule({
  declarations: [
    AppComponent,
    AlumnoListaComponent,
    AgregarAlumnoComponent,
    EditarAlumnoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideClientHydration(withEventReplay()),
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
