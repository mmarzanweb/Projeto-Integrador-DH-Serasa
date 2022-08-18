CREATE TABLE `ee_formacao_academica` (
  `id` bigint NOT NULL UNIQUE AUTO_INCREMENT,
  `id_candidato` bigint NOT NULL,
  `formacao` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `curso` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `instituicao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `data_inicio` date NOT NULL,
  `data_final` date NOT NULL,
  `informacoes_adicionais` text COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_candidato`) REFERENCES ee_candidato(id)
  
);