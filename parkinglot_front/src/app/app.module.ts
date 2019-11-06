import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms'
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { RegistrosComponent } from './pages/registros/registros.component';
import { NovoRegistroComponent } from './pages/novo-registro/novo-registro.component';
import { VeiculoCardComponent } from './components/veiculo-card/veiculo-card.component';
import { RegistraSaidaDialogComponent } from './components/registra-saida-dialog/registra-saida-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RegistrosComponent,
    NovoRegistroComponent,
    VeiculoCardComponent,
    RegistraSaidaDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatCardModule,
    ReactiveFormsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [RegistraSaidaDialogComponent]
})
export class AppModule { }
