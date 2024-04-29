import { Pessoa } from "../pessoa";

export class VacinaFiltro {
  nome: string;
  pais: string;
  pesquisadorResponsavel: Pessoa;
  dataInicial: Date;
  dataFinal: Date;
  estagio: string;
  avaliacaoMinima: Number;
  avaliacaoMaxima: Number;
}