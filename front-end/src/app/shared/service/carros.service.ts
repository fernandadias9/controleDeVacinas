import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CarroFiltro } from '../model/filtro/carro.filtro';
import { Carro } from '../model/carro';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarrosService {

  constructor(private httpClient: HttpClient) { }

  private readonly API: string = 'http://localhost:8080/senac-20241-backend-exemplos/rest/carro';

  listarComFiltro(filtro: CarroFiltro): Observable<Array<Carro>> {
    return this.httpClient.post<Array<Carro>>(this.API + '/filtro', filtro);
  }
}
