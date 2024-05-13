import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Montadora } from '../model/montadora';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MontadoraService {

  constructor(private httpClient: HttpClient) { }

  private readonly API: string = 'http://localhost:8080/senac-20241-backend-exemplos/rest/montadora';

  listar(): Observable<Array<Montadora>> {
    return this.httpClient.get<Array<Montadora>>(this.API + '/todas');
  }

  consultarEstoqueCarros(id: number): Observable<number> {
    return this.httpClient.get<number>(this.API + "/estoque-carros/" + id);
  }
}
