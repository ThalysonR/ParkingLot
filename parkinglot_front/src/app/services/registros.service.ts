import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegistrosService {

  private placaSubject: Subject<string> = new Subject<string>();
  private placaData: Observable<string> = this.placaSubject.asObservable();

  constructor(private http: HttpClient) { }

  buscaRegistrosAtivos(): Observable<Array<VeiculoModel>> {
    return this.http.get(`${environment.apiUrl}/registros`) as Observable<Array<VeiculoModel>>;
  }

  buscaValorSaida(placa: string): Observable<number> {
    return this.http.get(`${environment.apiUrl}/registros/saida`, { params: { placa } }) as Observable<number>;
  }

  registrarVeiculo(veiculo: VeiculoModel) {
    return this.http.post(`${environment.apiUrl}/registros`, veiculo);
  }

  registrarSaidaVeiculo(placa: string) {
    return this.http.post(`${environment.apiUrl}/registros/saida`, {}, { params: { placa } })
      .pipe(
        tap(() => this.placaSubject.next(placa))
      )
  }

  buscaRelatorio(inicio: string, fim: string): Observable<Array<RelatorioModel>> {
    return this.http.get(`${environment.apiUrl}/registros/relatorio`, { params: { inicio, fim } }) as Observable<Array<RelatorioModel>>;
  }

  listenSaidaVeiculo(): Observable<string> {
    return this.placaData;
  }
}
