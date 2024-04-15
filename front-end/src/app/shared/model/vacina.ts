import { Estagio } from "./estagio";
import { Pais } from "./pais";
import { Pessoa } from "./pessoa";

export interface Vacina{
  id: number;
  nome: string;
  paisOrigem: Pais;
  pesquisadorResponsavel: Pessoa;
  estagio: Estagio;
  dataInicio: Date;
  mediaDasAvaliacoes: number;
}