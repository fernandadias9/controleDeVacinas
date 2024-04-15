import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

export const routes: Routes = [
  // {path:"", redirectTo: 'vacinacao', pathMatch: "full"},
  // {
  //   path: 'vacinacao',
  //   loadChildren: () => import('./vacinacao/vacinacao.module').then(m => m .VacinacaoModule)
  // },
  {path:"", redirectTo: 'vacinas', pathMatch: "full"},
  {
    path: 'vacinas',
    loadChildren: () => import('./vacinas/vacinas.module').then(m => m .VacinasModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}