import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarrosListagemComponent } from './carros-listagem/carros-listagem.component';
import { MontadorasListagemComponent } from './montadoras-listagem/montadoras-listagem.component';

const routes: Routes = [
  {path: "lista", component: CarrosListagemComponent},
  {path: "montadoras", component: MontadorasListagemComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CarrosRoutingModule { }
