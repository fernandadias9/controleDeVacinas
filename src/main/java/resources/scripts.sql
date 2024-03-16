CREATE TABLE `estagio` (
  `id` int NOT NULL,
  `estagio` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tipo_de_receptor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(13) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pessoa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(180) NOT NULL,
  `dataNascimento` date NOT NULL,
  `sexo` varchar(9) NOT NULL,
  `cpf` char(11) NOT NULL,
  `id_tipo` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pessoa_tipo_de_receptor_FK` (`id_tipo`),
  CONSTRAINT `pessoa_tipo_de_receptor_FK` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_de_receptor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vacina` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `paisOrigem` varchar(255) NOT NULL,
  `idPesquisador` int NOT NULL,
  `idEstagio` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vacina_pessoa_FK` (`idPesquisador`),
  CONSTRAINT `vacina_pessoa_FK` FOREIGN KEY (`idPesquisador`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vacinacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idPessoa` int NOT NULL,
  `data` date NOT NULL,
  `avaliacao` int NOT NULL,
  `idVacina` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Vacinacao_pessoa_FK` (`idPessoa`),
  KEY `Vacinacao_vacina_FK` (`idVacina`),
  CONSTRAINT `Vacinacao_pessoa_FK` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `Vacinacao_vacina_FK` FOREIGN KEY (`idVacina`) REFERENCES `vacina` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;