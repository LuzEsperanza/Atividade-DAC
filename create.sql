CREATE TABLE pessoa(
	uuid serial PRIMARY KEY,
	nome VARCHAR(50),
	cpf VARCHAR(11) unique
);

CREATE TABLE dependente(
	uuid serial PRIMARY KEY,
	nome VARCHAR(50),
	dataDeNascimento VARCHAR(11),
	cpfafiliado VARCHAR(11),
	 FOREIGN KEY (cpfafiliado) REFERENCES pessoa (cpf)  ON DELETE CASCADE
)
