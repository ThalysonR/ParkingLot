import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-veiculo-card',
  templateUrl: './veiculo-card.component.html',
  styleUrls: ['./veiculo-card.component.sass']
})
export class VeiculoCardComponent implements OnInit {
  @Input()
  veiculo: VeiculoModel;

  constructor() { }

  ngOnInit() {
  }

}
