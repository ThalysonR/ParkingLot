import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrosComponent } from './pages/registros/registros.component';
import { NovoRegistroComponent } from './pages/novo-registro/novo-registro.component';

export const RoutePaths = {
  Registros: 'registros',
  NovoRegistro: 'novo-registro'
}

const routes: Routes = [
  { path: '', redirectTo: RoutePaths.Registros, pathMatch: 'full' },
  { path: RoutePaths.Registros, component: RegistrosComponent },
  { path: RoutePaths.NovoRegistro, component: NovoRegistroComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
