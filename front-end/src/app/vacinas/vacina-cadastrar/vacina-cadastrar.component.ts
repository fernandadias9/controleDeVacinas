import { VacinasService } from './../../shared/service/vacinas.service';
import { Vacina } from './../../shared/model/vacina';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { PaisService } from '../../shared/service/pais.service';
import { Pais } from '../../shared/model/pais';
import { PessoaService } from '../../shared/service/pessoa.service';
import { Pessoa } from '../../shared/model/pessoa';
import { TipoDeReceptor } from '../../shared/model/tipoDeReceptor';

@Component({
  selector: 'app-vacina-cadastrar',
  templateUrl: './vacina-cadastrar.component.html',
  styleUrl: './vacina-cadastrar.component.scss'
})

export class VacinaCadastrarComponent implements OnInit {

  public vacina: Vacina = new Vacina();
  public paises: Array<Pais> = new Array();
  public pessoas: Array<Pessoa> = new Array();

  constructor(private vacinasService: VacinasService, private paisService: PaisService, private pessoaService: PessoaService) {}

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
        console.log('Erro ao buscar países' + erro)
      }
    );
  }

  public cadastrar() {
    this.vacinasService.cadastrar(this.vacina).subscribe(
      resposta => {
        Swal.fire('Vacina cadastrada com sucesso!', '', 'success');
      },
      erro => {
        Swal.fire('Erro ao cadastrar vacina', erro, 'error');
      }
    )
  }
}