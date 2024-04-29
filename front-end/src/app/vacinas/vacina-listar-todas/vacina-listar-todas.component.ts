import { PessoaService } from './../../shared/service/pessoa.service';
import { Component, OnInit } from '@angular/core';
import { VacinasService } from '../../shared/service/vacinas.service';
import { Vacina } from '../../shared/model/vacina';
import { VacinaFiltro } from '../../shared/model/filtro/vacina.filtro';
import { PaisService } from '../../shared/service/pais.service';
import { Pais } from '../../shared/model/pais';
import { TipoDeReceptor } from '../../shared/model/tipoDeReceptor';
import { Pessoa } from '../../shared/model/pessoa';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-vacina-listar-todas',
  templateUrl: './vacina-listar-todas.component.html',
  styleUrl: './vacina-listar-todas.component.scss'
})
export class VacinaListarTodasComponent implements OnInit {

  public vacinas: Array<Vacina> = new Array();
  public filtro: VacinaFiltro = new VacinaFiltro();
  public paises: Array<Pais> = new Array();
  public pessoas: Array<Pessoa> = new Array();

  constructor(private vacinaService: VacinasService, private paisService: PaisService, private pessoaService: PessoaService,
              private router: Router, private route: ActivatedRoute) {}

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

      this.pessoaService.listarTodas().subscribe(
        resultado => {
          this.pessoas = resultado.filter(pessoa => pessoa.tipo === TipoDeReceptor.PESQUISADOR);
        },
        erro => {
          console.log('Erro ao buscar pesquisadores' + erro)
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

  editar(idVacina: number) {
    this.router.navigate(['/vacinas/cadastrar/', idVacina]);
  }
}