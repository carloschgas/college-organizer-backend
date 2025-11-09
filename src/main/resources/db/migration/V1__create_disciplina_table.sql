CREATE TABLE disciplinas(
    id_disciplina VARCHAR(10) PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    semestre INT NOT NULL,
    creditos INT NOT NULL,
    requisitos VARCHAR(250)
);