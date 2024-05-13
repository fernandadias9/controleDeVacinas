import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MontadoraService } from '../../shared/service/montadora.service';
import { Montadora } from '../../shared/model/montadora';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-montadoras-listagem',
  templateUrl: './montadoras-listagem.component.html',
  styleUrl: './montadoras-listagem.component.scss'
})
export class MontadorasListagemComponent implements OnInit {

  public montadoras: Array<Montadora> = new Array();
  public montadora: Montadora = new Montadora();
  public estoque: number;

  constructor(private montadoraService: MontadoraService,
    private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {

    this.montadoraService.listar().subscribe(
      resultado => {
        this.montadoras = resultado;
      },
      erro => {
        Swal.fire('Erro ao consultar montadoras: ', erro.error.mensagem, 'error');
      }
    );
  }

  consultarEstoque() {
    this.montadoraService.consultarEstoqueCarros(this.montadora.id).subscribe(
      resultado => {
        this.estoque = resultado;
      },
      erro => {
        Swal.fire('Erro ao consultar estoque: ', erro.error.mensagem, 'error');
      }
    )
    if(this.montadora.id == null) {
      Swal.fire('Selecione uma montadora.')
    }
  }
}