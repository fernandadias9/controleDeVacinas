import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VacinaListarTodasComponent } from './vacina-listar-todas/vacina-listar-todas.component';

const routes: Routes = [
  {path: "", component: VacinaListarTodasComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VacinasRoutingModule { }
