import { VacinasService } from './../../shared/service/vacinas.service';
import { Vacina } from './../../shared/model/vacina';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { PaisService } from '../../shared/service/pais.service';
import { Pais } from '../../shared/model/pais';
import { PessoaService } from '../../shared/service/pessoa.service';
import { Pessoa } from '../../shared/model/pessoa';
import { TipoDeReceptor } from '../../shared/model/tipoDeReceptor';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-vacina-cadastrar',
  templateUrl: './vacina-cadastrar.component.html',
  styleUrl: './vacina-cadastrar.component.scss'
})

export class VacinaCadastrarComponent implements OnInit {

  public vacina: Vacina = new Vacina();
  public idVacina: number;
  public paises: Array<Pais> = new Array();
  public pessoas: Array<Pessoa> = new Array();

  constructor(private vacinasService: VacinasService, private paisService: PaisService, private pessoaService: PessoaService,
              private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
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

    this.route.params.subscribe((params) => {
      this.idVacina = params['id'];
      if(this.idVacina) {
        this.buscar();
      }
    })
  }

  salvar(): void {
    if(this.idVacina) {
      this.atualizar();
    } else {
      this.cadastrar();
    }
  }

  cadastrar() {
    this.vacinasService.cadastrar(this.vacina).subscribe(
      resposta => {
        Swal.fire('Vacina cadastrada com sucesso!', '', 'success');
      },
      erro => {
        Swal.fire('Erro ao cadastrar vacina', erro, 'error');
      }
    )
  }

  atualizar(): void {
    this.vacinasService.atualizar(this.vacina).subscribe(
      (resposta) => {
        Swal.fire('Vacina atualizada com sucesso!', '', 'success');
      },
      (erro) => {
        Swal.fire('Erro ao atualizar a vacina: ' + erro, 'error');
        console.log(erro);
      }
    )
  }

  buscar(): void {
    this.vacinasService.buscar(this.idVacina).subscribe(
      (vacina) => {
        this.vacina = vacina;
      },
      (erro) => {
        Swal.fire('Erro ao buscar a carta!', erro, 'error');
      }
   )
  }

  voltar(): void {
    this.router.navigate(['/']);
  }

  public compareById(r1: any, r2: any): boolean {
    return r1 && r2 ? r1.id === r2.id : r1 === r2;
  }
}