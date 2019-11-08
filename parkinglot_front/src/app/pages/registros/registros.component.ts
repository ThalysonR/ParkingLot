import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { RegistraSaidaDialogComponent } from 'src/app/components/registra-saida-dialog/registra-saida-dialog.component';
import { RegistrosService } from 'src/app/services/registros.service';
import { Subscription } from 'rxjs'

@Component({
  selector: 'app-registros',
  templateUrl: './registros.component.html',
  styleUrls: ['./registros.component.sass']
})
export class RegistrosComponent implements OnInit, OnDestroy {
  busca: FormControl = new FormControl('');
  veiculos: Array<VeiculoModel> = [];
  veiculosFiltro: Array<VeiculoModel> = [];
  subscriptions: Array<Subscription> = [];

  constructor(private _dialog: MatDialog, private _registrosService: RegistrosService) { }

  dialogSaida(veiculo) {
    this._dialog.open(RegistraSaidaDialogComponent, {
      width: '350px',
      data: veiculo
    })
  }

  private removeVeiculo(placa: string, lista: Array<VeiculoModel>) {
    this.veiculos = this.veiculos.filter(veiculo => veiculo.placa !== placa);
  }

  ngOnInit() {
    this._registrosService.buscaRegistrosAtivos()
      .subscribe(veiculos => {
        this.veiculos = veiculos.slice();
        this.veiculosFiltro = this.veiculos.slice();
      });
      
      this.subscriptions.push(
        this.busca.valueChanges.subscribe(placa => {
          placa != ''
          ? this.veiculosFiltro = this.veiculos.filter(veiculo => veiculo.placa.toLowerCase().includes(placa.toLowerCase()))
          : this.veiculosFiltro = this.veiculos.slice();
        })
        );
        
        this.subscriptions.push(
          this._registrosService.listenSaidaVeiculo().subscribe(placa => {
            this.removeVeiculo(placa, this.veiculos);
            this.veiculosFiltro = this.veiculos.slice();
      })
    );
  }

  ngOnDestroy() {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
