import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrosService {

  constructor(private http: HttpClient) { }

  buscaRegistrosAtivos(): Observable<Array<VeiculoModel>> {
    return this.http.get('http://localhost:8080/registros') as Observable<Array<VeiculoModel>>;
  }

  buscaValorSaida(placa: string) {
    return this.http.get('http://localhost:8080/registros/saida', { params: { placa } });
  }

  registrarVeiculo(veiculo: VeiculoModel) {
    return this.http.post('http://localhost:8080/registros', veiculo);
  }

  registrarSaidaVeiculo(placa: string) {
    return this.http.post('http://localhost:8080/registros/saida', {}, { params: { placa } });
  }
}
