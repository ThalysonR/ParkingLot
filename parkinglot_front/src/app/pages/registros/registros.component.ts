import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { RegistraSaidaDialogComponent } from 'src/app/components/registra-saida-dialog/registra-saida-dialog.component';

@Component({
  selector: 'app-registros',
  templateUrl: './registros.component.html',
  styleUrls: ['./registros.component.sass']
})
export class RegistrosComponent implements OnInit {
  busca: FormControl = new FormControl('');
  veiculos: Array<VeiculoModel> = [
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
    {cor: 'preto', modelo: 'siena', placa: 'ABC1234'},
  ];
  veiculosFiltro: Array<VeiculoModel> = [];

  constructor(private _dialog: MatDialog) { }

  teste(veiculo) {
    const dialogRef = this._dialog.open(RegistraSaidaDialogComponent, {
      width:'350px',
      data: veiculo
    })
  }

  ngOnInit() {
    this.busca.valueChanges.subscribe(placa => {
      placa != ''
        ? this.veiculosFiltro = this.veiculos.filter(veiculo => veiculo.placa.toLowerCase().includes(placa.toLowerCase()))
        : this.veiculosFiltro = this.veiculos;
    })
  }

}
