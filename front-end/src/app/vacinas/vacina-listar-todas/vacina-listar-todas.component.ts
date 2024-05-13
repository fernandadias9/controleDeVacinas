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
import Swal from 'sweetalert2';

@Component({
  selector: 'app-vacina-listar-todas',
  templateUrl: './vacina-listar-todas.component.html',
  styleUrl: './vacina-listar-todas.component.scss'
})
export class VacinaListarTodasComponent implements OnInit {

  public vacinas: Array<Vacina> = new Array();
  public vacina: Vacina = new Vacina();
  public filtro: VacinaFiltro = new VacinaFiltro();
  public paises: Array<Pais> = new Array();
  public pessoas: Array<Pessoa> = new Array();
  public qtdeRegistros: number;
  public totalPaginas: number;
  public registroInicial: number;
  public registroFinal: number;
  public pesquisouComFiltro: boolean;


  constructor(private vacinaService: VacinasService, private paisService: PaisService, private pessoaService: PessoaService,
              private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {

    this.filtro.pagina = 1;
    this.filtro.limite = 5;
    this.pesquisar();
    this.contarPaginas();
    this.contarRegistros();
    this.mostrarRegistros();

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

  contarPaginas() {
		this.vacinaService.contarPaginas(this.filtro).subscribe(
      resultado => {
        this.totalPaginas = resultado;
      },
      erro => {
        Swal.fire('Erro ao contar páginas', erro.error.mensagem, 'error');
      }
    )
	}

  atualizarPaginacao() {
    this.contarPaginas();
    this.pesquisar();
  }

  /*private consultarTodasVacinas() {
    this.vacinaService.listarTodas().subscribe(
      resultado => {
        this.vacinas = resultado;
      },
      erro => {
        console.error('Erro ao consultar vacinas', erro);
      }
    )
  }*/

  contarRegistros() {
		this.vacinaService.contarRegistro(this.filtro).subscribe(
      resultado => {
        this.qtdeRegistros = resultado;
      },
      erro => {
        console.error('Erro ao contar vacinas: ', erro);
      }
    )
	}

  mostrarRegistros() {
    this.registroInicial = 1 + ((this.filtro.pagina - 1) * this.filtro.limite);
    if(this.filtro.pagina == this.totalPaginas) {
      this.registroFinal = this.qtdeRegistros;
    } else {
      this.registroFinal = this.filtro.pagina * this.filtro.limite;
    }
  }

  public limpar() {
    this.filtro = new VacinaFiltro();
  }

  editar(idVacina: number) {
    this.router.navigate(['/vacinas/cadastrar/', idVacina]);
  }

  excluir(vacina: Vacina) {
    Swal.fire({
      title: 'Deseja realmente excluir a vacina?',
      text: 'Essa ação não poderá ser desfeita!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Confirmar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if(result.value) {
        this.vacinaService.excluir(vacina.id).subscribe(
          (resposta) => {
            Swal.fire('Vacina excluída com sucesso!', '', 'success');
          },
          (erro) => {
            Swal.fire(erro.error.mensagem, '', 'error');
            console.log(erro);
          }
        )
      }
    })
  }

  consultarPaginaAnterior() {
    this.filtro.pagina--;
    this.contarRegistros();
    this.mostrarRegistros();
    this.pesquisar();
  }

  consultarProximaPagina() {
    this.filtro.pagina++;
    this.contarRegistros();
    this.mostrarRegistros();
    this.pesquisar();
  }
}