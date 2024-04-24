import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PaisListarTodosComponent } from './pais-listar-todos/pais-listar-todos.component';

const routes: Routes = [
  {path: "listar", component: PaisListarTodosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaisesRoutingModule { }
