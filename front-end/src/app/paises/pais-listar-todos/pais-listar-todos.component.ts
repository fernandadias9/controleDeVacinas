import { Component, Injectable, OnInit } from '@angular/core';
import { PaisService } from '../../shared/service/pais.service';
import { Pais } from '../../shared/model/pais';

@Component({
  selector: 'app-pais-listar-todos',
  templateUrl: './pais-listar-todos.component.html',
  styleUrl: './pais-listar-todos.component.scss'
})

@Injectable()
export class PaisListarTodosComponent implements OnInit {

  public paises: Array<Pais> = new Array();

  constructor(private paisService: PaisService) {}

  ngOnInit(): void {

    this.consultarTodos();
  }

  public consultarTodos() {
    this.paisService.consultarTodos().subscribe(
      resultado => {
        this.paises = resultado;
      },
      erro => {
        console.log('Erro ao buscar países' + erro)
      }
    );
  }
}
