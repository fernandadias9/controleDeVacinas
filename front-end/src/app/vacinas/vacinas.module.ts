import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VacinasRoutingModule } from './vacinas-routing.module';
import { VacinaListarTodasComponent } from './vacina-listar-todas/vacina-listar-todas.component';
import { FormsModule } from '@angular/forms';
import { VacinaCadastrarComponent } from './vacina-cadastrar/vacina-cadastrar.component';


@NgModule({
  declarations: [
    VacinaListarTodasComponent,
    VacinaCadastrarComponent
  ],
  imports: [
    CommonModule,
    VacinasRoutingModule,
    FormsModule
  ]
})
export class VacinasModule { }
