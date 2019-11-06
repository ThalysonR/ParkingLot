import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiculoCardComponent } from './veiculo-card.component';

describe('VeiculoCardComponent', () => {
  let component: VeiculoCardComponent;
  let fixture: ComponentFixture<VeiculoCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VeiculoCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VeiculoCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
