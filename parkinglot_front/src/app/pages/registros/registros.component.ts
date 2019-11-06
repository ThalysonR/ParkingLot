import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { RegistraSaidaDialogComponent } from 'src/app/components/registra-saida-dialog/registra-saida-dialog.component';
import { RegistrosService } from 'src/app/services/registros.service';

@Component({
  selector: 'app-registros',
  templateUrl: './registros.component.html',
  styleUrls: ['./registros.component.sass']
})
export class RegistrosComponent implements OnInit {
  busca: FormControl = new FormControl('');
  veiculos: Array<VeiculoModel> = [];
  veiculosFiltro: Array<VeiculoModel> = [];

  constructor(private _dialog: MatDialog, private _registrosService: RegistrosService) { }

  dialogSaida(veiculo) {
    this._dialog.open(RegistraSaidaDialogComponent, {
      width:'350px',
      data: veiculo
    })
  }

  ngOnInit() {
    this._registrosService.buscaRegistrosAtivos()
      .subscribe(veiculos => {
        this.veiculos = this.veiculosFiltro = veiculos;
      })

    this.busca.valueChanges.subscribe(placa => {
      placa != ''
        ? this.veiculosFiltro = this.veiculos.filter(veiculo => veiculo.placa.toLowerCase().includes(placa.toLowerCase()))
        : this.veiculosFiltro = this.veiculos;
    })
  }

}
