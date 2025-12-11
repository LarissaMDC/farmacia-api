-- Make sure column names match your entity
INSERT INTO medicamentos (nome, fabricante, preco, quantidade_estoque, categoria, descricao, prescricao_obrigatoria, data_validade, data_cadastro, data_atualizacao)
VALUES
('Paracetamol 500mg', 'EMS', 15.90, 100, 'Analgésico', 'Analgésico e antitérmico para dores e febre', false, '2025-12-31 23:59:59', NOW(), NOW()),
('Ibuprofeno 400mg', 'Eurofarma', 22.50, 75, 'Anti-inflamatório', 'Anti-inflamatório não esteroidal para dores e inflamações', false, '2025-10-31 23:59:59', NOW(), NOW()),
('Amoxicilina 500mg', 'Neo Química', 45.80, 50, 'Antibiótico', 'Antibiótico para infecções bacterianas', true, '2024-08-31 23:59:59', NOW(), NOW()),
('Losartana 50mg', 'Medley', 32.75, 120, 'Hipertensão', 'Anti-hipertensivo para controle da pressão arterial', true, '2026-03-31 23:59:59', NOW(), NOW()),
('Omeprazol 20mg', 'Aché', 28.90, 200, 'Gastrintestinal', 'Inibidor de bomba de prótons para azia e refluxo', false, '2025-11-30 23:59:59', NOW(), NOW()),
('Dipirona 1g', 'Sanofi', 12.30, 150, 'Analgésico', 'Analgésico e antitérmico de ação rápida', false, '2025-09-30 23:59:59', NOW(), NOW()),
('Sinvastatina 20mg', 'Germed', 56.40, 80, 'Colesterol', 'Redutor de colesterol e triglicerídeos', true, '2026-01-31 23:59:59', NOW(), NOW()),
('Metformina 850mg', 'Novartis', 18.60, 180, 'Diabetes', 'Hipoglicemiante para diabetes tipo 2', true, '2025-12-31 23:59:59', NOW(), NOW()),
('Cimegripe', 'Cimed', 35.20, 90, 'Gripe e Resfriado', 'Medicamento para sintomas de gripe e resfriado', false, '2025-06-30 23:59:59', NOW(), NOW()),
('Dorflex', 'Sanofi', 19.90, 110, 'Relaxante Muscular', 'Analgésico e relaxante muscular para dores', false, '2025-08-31 23:59:59', NOW(), NOW());