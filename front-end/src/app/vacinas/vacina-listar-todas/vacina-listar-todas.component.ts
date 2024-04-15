import { Component, OnInit } from '@angular/core';
import { VacinasService } from '../../shared/service/vacinas.service';
import { Vacina } from '../../shared/model/vacina';

@Component({
  selector: 'app-vacina-listar-todas',
  templateUrl: './vacina-listar-todas.component.html',
  styleUrl: './vacina-listar-todas.component.scss'
})
export class VacinaListarTodasComponent implements OnInit {

  public vacinas: Array<Vacina> = new Array();

  constructor(private vacinaService: VacinasService) {}

  ngOnInit(): void {
    this.consultarTodasVacinas();
  }

  private consultarTodasVacinas() {
    this.vacinaService.listarTodas().subscribe(
      resultado => {
        this.vacinas = resultado;
      },
      erro => {
        console.error('Erro ao consultar vacinas', erro);
      }
    )
  }

}
