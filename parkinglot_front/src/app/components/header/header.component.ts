import { Component, OnInit } from '@angular/core';
import { RoutePaths } from '../../app-routing.module';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass']
})
export class HeaderComponent implements OnInit {
  routePaths = RoutePaths;

  constructor() { }

  ngOnInit() {
  }

}
