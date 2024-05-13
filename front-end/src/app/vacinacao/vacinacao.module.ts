import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VacinacaoRoutingModule } from './vacinacao-routing.module';
import { VacinacaoCadastrarComponent } from './vacinacao-cadastrar/vacinacao-cadastrar.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [VacinacaoCadastrarComponent],
  imports: [
    CommonModule,
    VacinacaoRoutingModule,
    FormsModule
  ]
})
export class VacinacaoModule { }