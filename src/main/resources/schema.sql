-- Drop table if exists
DROP TABLE IF EXISTS medicamentos;

-- Create table
CREATE TABLE medicamentos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    fabricante VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade_estoque INT NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    descricao TEXT,
    prescricao_obrigatoria BOOLEAN DEFAULT FALSE,
    data_validade TIMESTAMP,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);