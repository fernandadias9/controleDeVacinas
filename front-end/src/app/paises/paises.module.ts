import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PaisesRoutingModule } from './paises-routing.module';
import { PaisListarTodosComponent } from './pais-listar-todos/pais-listar-todos.component';


@NgModule({
  declarations: [
    PaisListarTodosComponent
  ],
  imports: [
    CommonModule,
    PaisesRoutingModule
  ],
  exports: [PaisListarTodosComponent]
})
export class PaisesModule { }
