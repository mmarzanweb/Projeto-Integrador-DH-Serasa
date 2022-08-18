CREATE TABLE `ee_empresa` (
  `id` bigint NOT NULL UNIQUE AUTO_INCREMENT,
  `cnpj` varchar(14) COLLATE utf8_unicode_ci NOT NULL,
  `razao_social` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `nome_fantasia` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `telefone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `responsavel` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `segmento` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `num_func` int NOT NULL,
  `tipo_permissao` enum('empresa','candidato','administrador'),
  `id_endereco` bigint NOT NULL,
  `email_usuario` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `senha` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `data_cadastro` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_endereco`) REFERENCES ee_endereco(id)
);