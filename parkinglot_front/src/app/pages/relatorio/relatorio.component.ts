import { Component, OnInit } from '@angular/core';
import { Moment } from 'moment';
import { RegistrosService } from 'src/app/services/registros.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  styleUrls: ['./relatorio.component.sass']
})
export class RelatorioComponent implements OnInit {
  model: {
    inicio: Moment,
    fim: Moment
  } = {
    inicio: null,
    fim: null
  };

  numeroCarrosChartData = [];
  valorRecebidoChartData = [];
  chartLabels = [];
  chartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  chartLegend = true;
  chartType = 'bar';

  constructor(private _registrosService: RegistrosService, private _snackBar: MatSnackBar) { }

  gerarRelatorio() {
    this._registrosService.buscaRelatorio(this.model.inicio.format('L'), this.model.fim.format('L'))
      .subscribe(dados => {
        this.numeroCarrosChartData = [];
        this.valorRecebidoChartData = [];
        this.chartLabels = [];
        const numeroCarros = {
          data: [],
          label: 'Numero de Carros',
          backgroundColor: '#eb2366'
        };
        const valorRecebido = {
          data: [],
          label: 'Valor Recebido',
          backgroundColor: '#1f37ed'
        };
        dados.forEach(relDia => {
          this.chartLabels.push(relDia.dia);
          numeroCarros.data.push(relDia.numeroCarros)
          valorRecebido.data.push(relDia.valorRecebido)
        });
        this.valorRecebidoChartData.push(valorRecebido);
        this.numeroCarrosChartData.push(numeroCarros);
      }, () => {
        this._snackBar.open('Falha ao gerar relatório', '', { panelClass: ['snack-danger'] });
      });
  }

  ngOnInit() {
  }

}
