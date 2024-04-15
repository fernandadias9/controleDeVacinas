// import { Component, OnInit } from '@angular/core';



// @Component({
//   selector: 'app-vacinacao-listar-todas',
//   templateUrl: './vacinacao-listar-todas.component.html',
//   styleUrl: './vacinacao-listar-todas.component.scss'
// })
// export class VacinacaoListarTodasComponent implements OnInit {

//   public vacinacoes: Vacinacao[] = [];

//   constructor(private vacinacaoService: VacinacaoService) {}

//   ngOnInit(): void {
//     this.consultarTodasVacinacoes();
//   }

//   private consultarTodasVacinacoes() {
//     this.vacinacaoService.listarTodas().subscribe(
//       resultado => {
//         this.vacinacoes = resultado;
//       },
//       erro => {
//         console.error('Erro ao consultar cartas', erro);
//       }
//     )
//   }
// }
