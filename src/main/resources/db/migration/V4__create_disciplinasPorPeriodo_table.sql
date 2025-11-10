CREATE TABLE disciplinas_por_periodo (
    id CHAR(36) NOT NULL PRIMARY KEY,
    id_disciplina VARCHAR(10) NULL,
    nome_periodo VARCHAR(50) NOT NULL,

    CONSTRAINT fk_disciplina
        FOREIGN KEY (id_disciplina) REFERENCES disciplinas(id_disciplina)
        ON DELETE SET NULL,

    CONSTRAINT fk_periodo
        FOREIGN KEY (nome_periodo) REFERENCES periodo_graduacao(nome_periodo)
        ON DELETE CASCADE
);