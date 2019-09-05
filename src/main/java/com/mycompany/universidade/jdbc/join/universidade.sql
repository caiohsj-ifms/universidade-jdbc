/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Caio Henrique
 * Created: 04/09/2019
 */

CREATE TABLE aluno (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100),
    cpf VARCHAR(11),
    ra VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE disciplina (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE matricula (
    id INT NOT NULL AUTO_INCREMENT,
    ano INT NOT NULL,
    semestre INT NOT NULL,
    idAluno INT NOT NULL,
    idDisciplina INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(idAluno) REFERENCES aluno(id),
    FOREIGN KEY(idDisciplina) REFERENCES disciplina(id)
);