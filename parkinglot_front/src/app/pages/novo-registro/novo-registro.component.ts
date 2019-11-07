import { Component, OnInit } from '@angular/core';
import { RegistrosService } from 'src/app/services/registros.service';
import { Router } from '@angular/router';
import { RoutePaths } from '../../app-routing.module';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-novo-registro',
  templateUrl: './novo-registro.component.html',
  styleUrls: ['./novo-registro.component.sass']
})
export class NovoRegistroComponent implements OnInit {
  veiculo: VeiculoModel = {
    cor: '',
    modelo: '',
    placa: '',
  }

  registrarVeiculo() {
    this._registrosSerive.registrarVeiculo(this.veiculo)
      .subscribe(() => {
        this._snackBar.open('Veículo registrado com sucesso', '', { panelClass: ['snack-success'] });
        this._router.navigate(['/' + RoutePaths.Registros]);
      }, () => {
        this._snackBar.open('Falha ao registrar veículo', '', { panelClass: ['snack-danger'] });
      });
  }

  constructor(private _registrosSerive: RegistrosService, private _router: Router, private _snackBar: MatSnackBar) { }

  ngOnInit() {
  }

}
