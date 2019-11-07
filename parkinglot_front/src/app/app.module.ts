import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { registerLocaleData } from '@angular/common';
import br from '@angular/common/locales/br';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule, MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatMomentDateModule } from '@angular/material-moment-adapter';
import { ChartsModule } from 'ng2-charts';
import { RegistrosComponent } from './pages/registros/registros.component';
import { NovoRegistroComponent } from './pages/novo-registro/novo-registro.component';
import { VeiculoCardComponent } from './components/veiculo-card/veiculo-card.component';
import { RegistraSaidaDialogComponent } from './components/registra-saida-dialog/registra-saida-dialog.component';
import { RelatorioComponent } from './pages/relatorio/relatorio.component';

registerLocaleData(br, 'pt-BR');

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RegistrosComponent,
    NovoRegistroComponent,
    VeiculoCardComponent,
    RegistraSaidaDialogComponent,
    RelatorioComponent,
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
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    HttpClientModule,
    MatSnackBarModule,
    MatDatepickerModule,
    MatMomentDateModule,
    ChartsModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt-BR' },
    { provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: { duration: 2500 } }
  ],
  bootstrap: [AppComponent],
  entryComponents: [RegistraSaidaDialogComponent]
})
export class AppModule { }
