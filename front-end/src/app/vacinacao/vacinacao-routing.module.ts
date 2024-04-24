import { VacinacaoListarTodasComponent } from './vacinacao-listar-todas/vacinacao-listar-todas.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: "", VacinacaoListarTodasComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VacinacaoRoutingModule { }