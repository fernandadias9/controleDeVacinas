import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'vacinas',
    loadChildren: () => import('./vacinas/vacinas.module').then(m => m .VacinasModule)
  },
  {
    path: 'vacinacoes',
    loadChildren: () => import('./vacinacao/vacinacao.module').then(m => m .VacinacaoModule)
  },
  {
    path: 'carros',
    loadChildren: () => import('./carros/carros.module').then(m => m .CarrosModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}