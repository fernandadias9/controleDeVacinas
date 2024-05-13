import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../../shared/model/pessoa';
import { PessoaService } from '../../shared/service/pessoa.service';
import { Vacina } from '../../shared/model/vacina';
import { VacinasService } from '../../shared/service/vacinas.service';
import Swal from 'sweetalert2';
import { VacinacaoService } from '../../shared/service/vacinacao.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Vacinacao } from '../../shared/model/vacinacao';

@Component({
  selector: 'app-vacinacao-cadastrar',
  templateUrl: './vacinacao-cadastrar.component.html',
  styleUrl: './vacinacao-cadastrar.component.scss'
})
export class VacinacaoCadastrarComponent implements OnInit {

  public pessoas: Array<Pessoa> = new Array();
  public vacinas: Array<Vacina> = new Array();
  public vacinacao: Vacinacao = new Vacinacao();
  public idVacinacao: number;

  constructor(private pessoaService: PessoaService, private vacinaService: VacinasService, private vacinacaoService: VacinacaoService,
              private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.pessoaService.listarTodas().subscribe(
      resultado => {
        this.pessoas = resultado;
      },
      erro => {
        console.log('Erro ao buscar pesquisadores' + erro)
      }
    );

    this.vacinaService.listarTodas().subscribe(
      resultado => {
        this.vacinas = resultado;
      },
      erro => {
        console.log('Erro ao buscar vacinas' + erro)
      }
    )
  }

  // salvar(): void {
  //   if(this.idVacinacao) {
  //     this.atualizar();
  //   } else {
  //     this.cadastrar();
  //   }
  // }

  cadastrar() {
    this.vacinacaoService.cadastrar(this.vacinacao).subscribe(
      resposta => {
        Swal.fire('Vacinação cadastrada com sucesso!', '', 'success');
      },
      erro => {
        Swal.fire('Erro ao cadastrar vacinação', erro, 'error');
      }
    )
  }

  // atualizar(): void {
  //   this.vacinaService.atualizar(this.vacina).subscribe(
  //     (resposta) => {
  //       Swal.fire('Vacina atualizada com sucesso!', '', 'success');
  //     },
  //     (erro) => {
  //       Swal.fire('Erro ao atualizar a vacina: ' + erro, 'error');
  //       console.log(erro);
  //     }
  //   )
  // }

  // buscar(): void {
  //   this.vacinaService.buscar(this.idVacina).subscribe(
  //     (vacina) => {
  //       this.vacina = vacina;
  //     },
  //     (erro) => {
  //       Swal.fire('Erro ao buscar a carta!', erro, 'error');
  //     }
  //  )
  // }

  voltar(): void {
    this.router.navigate(['/']);
  }

  public compareById(r1: any, r2: any): boolean {
    return r1 && r2 ? r1.id === r2.id : r1 === r2;
  }
}
