import { Component, OnInit } from '@angular/core';
import { VacinasService } from '../../shared/service/vacinas.service';
import { Vacina } from '../../shared/model/vacina';
import { VacinaFiltro } from '../../shared/model/filtro/vacina.filtro';
import { PaisService } from '../../shared/service/pais.service';
import { Pais } from '../../shared/model/pais';

@Component({
  selector: 'app-vacina-listar-todas',
  templateUrl: './vacina-listar-todas.component.html',
  styleUrl: './vacina-listar-todas.component.scss'
})
export class VacinaListarTodasComponent implements OnInit {

  public vacinas: Array<Vacina> = new Array();
  public filtro: VacinaFiltro = new VacinaFiltro();
  public paises: Array<Pais> = new Array();

  constructor(private vacinaService: VacinasService, private paisService: PaisService) {}

  ngOnInit(): void {
    this.consultarTodasVacinas();

    this.paisService.consultarTodos().subscribe(
        resultado => {
          this.paises = resultado;
        },
        erro => {
          console.log('Erro ao buscar países' + erro)
        }
      );
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

  public pesquisar() {
    this.vacinaService.listarComFiltro(this.filtro).subscribe(
      resultado => {
        this.vacinas = resultado;
      },
      erro => {
        console.error('Erro ao consultar vacinas', erro);
      }
    )
  }

  public limpar() {
    this.filtro = new VacinaFiltro();
  }
}