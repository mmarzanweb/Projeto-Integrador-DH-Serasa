CREATE TABLE `ee_experiencia` (
 `id` bigint NOT NULL AUTO_INCREMENT,
`id_candidato` bigint NOT NULL,
 `tipo_contrato` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`contratante` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`cargo` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`data_inicio` date NOT NULL,
`emprego_atual` Tinyint (1) NOT NULL, 
`data_saida`  date DEFAULT NULL, 
`atribuicoes` text NOT NULL, 
PRIMARY KEY (`id`),
FOREIGN KEY (`id_candidato`) REFERENCES ee_candidato(id)
);