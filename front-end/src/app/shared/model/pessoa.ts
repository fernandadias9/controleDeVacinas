import { Pais } from "./pais";
import { TipoDeReceptor } from "./tipoDeReceptor";

export interface Pessoa {
  id: number;
  nome: string;
  dataNascimento: Date;
  sexo: string;
  cpf: string;
  tipo: TipoDeReceptor;
  pais: Pais;
  //vacinacoes: Vacinacao[];
}