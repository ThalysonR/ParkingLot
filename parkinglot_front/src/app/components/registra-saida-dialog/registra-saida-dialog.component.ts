import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-registra-saida-dialog',
  templateUrl: './registra-saida-dialog.component.html',
  styleUrls: ['./registra-saida-dialog.component.sass']
})
export class RegistraSaidaDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<RegistraSaidaDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public veiculo: VeiculoModel
  ) { }

  onNoClick() {
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
