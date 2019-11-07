import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrosComponent } from './pages/registros/registros.component';
import { NovoRegistroComponent } from './pages/novo-registro/novo-registro.component';
import { RelatorioComponent } from './pages/relatorio/relatorio.component';

export const RoutePaths = {
  Registros: 'registros',
  NovoRegistro: 'novo-registro',
  Relatorio: 'relatorio'
}

const routes: Routes = [
  { path: '', redirectTo: RoutePaths.Registros, pathMatch: 'full' },
  { path: RoutePaths.Registros, component: RegistrosComponent },
  { path: RoutePaths.Relatorio, component: RelatorioComponent },
  { path: RoutePaths.NovoRegistro, component: NovoRegistroComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
