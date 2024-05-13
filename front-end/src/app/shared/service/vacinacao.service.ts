import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vacinacao } from '../model/vacinacao';

@Injectable({
  providedIn: 'root'
})
export class VacinacaoService {

  constructor(private httpClient: HttpClient) { }

  private readonly API: string = 'http://localhost:8080/ControleDeVacinas/rest/vacinacao';

  cadastrar(vacinacao: Vacinacao) {
    return this.httpClient.post<Vacinacao>(this.API, vacinacao)
  }
}
