import { Component, OnInit } from '@angular/core';
import { Carro } from '../../shared/model/carro';
import { CarroFiltro } from '../../shared/model/filtro/carro.filtro';
import { CarrosService } from '../../shared/service/carros.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carros-listagem',
  templateUrl: './carros-listagem.component.html',
  styleUrl: './carros-listagem.component.scss'
})
export class CarrosListagemComponent implements OnInit{

  public carros: Array<Carro> = new Array();
  public filtro: CarroFiltro = new CarroFiltro();

  constructor(private carroService: CarrosService,
    private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {

    this.pesquisar();
  }

  public pesquisar() {
    this.carroService.listarComFiltro(this.filtro).subscribe(
      resultado => {
        this.carros = resultado;
      },
      erro => {
        Swal.fire('Erro ao consultar carros: ', erro.error.mensagem, 'error');
      }
    )
    if(this.carros.length == 0 ) {
      Swal.fire('Nenhum veículo encontrado');
    }
  }

  public limpar() {
    this.filtro = new CarroFiltro();
  }
}
