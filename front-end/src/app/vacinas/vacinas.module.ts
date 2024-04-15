import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VacinasRoutingModule } from './vacinas-routing.module';
import { VacinaListarTodasComponent } from './vacina-listar-todas/vacina-listar-todas.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    VacinaListarTodasComponent
  ],
  imports: [
    CommonModule,
    VacinasRoutingModule,
    FormsModule
  ]
})
export class VacinasModule { }
