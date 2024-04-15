import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vacina } from '../model/vacina';

@Injectable({
  providedIn: 'root'
})
export class VacinasService {

  constructor(private httpClient: HttpClient) { }

  private readonly API: string = 'http://localhost:8080/ControleDeVacinas/rest/vacina';


  listarTodas(): Observable<Array<Vacina>> {
    return this.httpClient.get<Array<Vacina>>(this.API + '/listartodas');
  }
}