CREATE TABLE `ee_endereco` (
  `id` bigint NOT NULL UNIQUE AUTO_INCREMENT,
  `logradouro` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `num` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `compl` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bairro` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cidade` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `uf` char(2) COLLATE utf8_unicode_ci NOT NULL,
  `cep` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
);

