import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { RegistrosService } from 'src/app/services/registros.service';

@Component({
  selector: 'app-registra-saida-dialog',
  templateUrl: './registra-saida-dialog.component.html',
  styleUrls: ['./registra-saida-dialog.component.sass']
})
export class RegistraSaidaDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<RegistraSaidaDialogComponent>,
    private _registrosService: RegistrosService,
    @Inject(MAT_DIALOG_DATA) public veiculo: VeiculoModel
  ) { }

    valor = 0;

  registrarSaida() {
    this._registrosService.registrarSaidaVeiculo(this.veiculo.placa)
      .subscribe(console.log);
  }

  onNoClick() {
    this.dialogRef.close();
  }

  ngOnInit() {
    this._registrosService.buscaValorSaida(this.veiculo.placa).subscribe(valor => this.valor = valor);
  }

}
