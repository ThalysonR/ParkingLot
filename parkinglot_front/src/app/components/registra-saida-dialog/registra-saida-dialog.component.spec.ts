import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistraSaidaDialogComponent } from './registra-saida-dialog.component';

describe('RegistraSaidaDialogComponent', () => {
  let component: RegistraSaidaDialogComponent;
  let fixture: ComponentFixture<RegistraSaidaDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistraSaidaDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistraSaidaDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
