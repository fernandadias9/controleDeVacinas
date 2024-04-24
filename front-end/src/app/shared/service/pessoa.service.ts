import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pessoa } from '../model/pessoa';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private httpClient: HttpClient) { }

  private readonly API: string = 'http://localhost:8080/ControleDeVacinas/rest/pessoa';

  listarTodas(): Observable<Array<Pessoa>> {
    return this.httpClient.get<Array<Pessoa>>(this.API + '/listartodas');
  }
}