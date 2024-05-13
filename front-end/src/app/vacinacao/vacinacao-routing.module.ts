import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VacinacaoCadastrarComponent } from './vacinacao-cadastrar/vacinacao-cadastrar.component';

const routes: Routes = [
  {path: "cadastrar", component: VacinacaoCadastrarComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VacinacaoRoutingModule { }
