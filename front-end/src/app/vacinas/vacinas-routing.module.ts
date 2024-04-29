import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VacinaListarTodasComponent } from './vacina-listar-todas/vacina-listar-todas.component';
import { VacinaCadastrarComponent } from './vacina-cadastrar/vacina-cadastrar.component';

const routes: Routes = [
  {path: "listar", component: VacinaListarTodasComponent},
  {path: "cadastrar", component: VacinaCadastrarComponent},
  {path: "cadastrar/:id", component: VacinaCadastrarComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VacinasRoutingModule { }
