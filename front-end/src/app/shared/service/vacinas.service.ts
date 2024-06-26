import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vacina } from '../model/vacina';
import { VacinaFiltro } from '../model/filtro/vacina.filtro';

@Injectable({
  providedIn: 'root'
})
export class VacinasService {

  constructor(private httpClient: HttpClient) { }

  private readonly API: string = 'http://localhost:8080/ControleDeVacinas/rest/vacina';

  listarTodas(): Observable<Array<Vacina>> {
    return this.httpClient.get<Array<Vacina>>(this.API + '/listartodas');
  }

  listarComFiltro(filtro: VacinaFiltro): Observable<Array<Vacina>> {
    return this.httpClient.post<Array<Vacina>>(this.API + '/filtrar', filtro);
  }

  cadastrar(vacina: Vacina) {
    return this.httpClient.post<Vacina>(this.API, vacina)
  }

  buscar(id: number): Observable<Vacina> {
    return this.httpClient.get<Vacina>(this.API + "/buscar/" + id);
  }

  atualizar(vacina: Vacina): Observable<boolean> {
    return this.httpClient.put<boolean>(this.API + "/atualizar", vacina);
  }

  excluir(id: number): Observable<boolean> {
    return this.httpClient.delete<boolean>(this.API + "/excluir/" + id);
  }

  contarRegistro(filtro: VacinaFiltro): Observable<number> {
    return this.httpClient.post<number>(this.API + "/contarRegistros", filtro)
  }

  contarPaginas(filtro: VacinaFiltro): Observable<number> {
    return this.httpClient.post<number>(this.API + "/totalPaginas", filtro)
  }
}