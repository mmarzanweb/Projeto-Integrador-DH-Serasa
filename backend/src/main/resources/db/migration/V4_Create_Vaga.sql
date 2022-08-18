CREATE TABLE `ee_vaga` (
 `id` bigint NOT NULL AUTO_INCREMENT, 
 `id_empresa` bigint NOT NULL, 
`publicada` Tinyint (1) NOT NULL, 
`data_publicacao` datetime NOT NULL, 
`cargo` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`nivel` varchar(20) COLLATE utf8_unicode_ci NOT NULL, 
`jornada` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`salario` decimal(5,2) DEFAULT NULL, 
`tipo_contrato` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`modalidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`descr_vaga` text COLLATE utf8_unicode_ci NOT NULL, 
`requisitos` text COLLATE utf8_unicode_ci NOT NULL, 
`desejavel` text COLLATE utf8_unicode_ci NOT NULL, 
`beneficios` text COLLATE utf8_unicode_ci NOT NULL, 
`uf` char(2) COLLATE utf8_unicode_ci NOT NULL, 
`cidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`bairro` varchar(30) COLLATE utf8_unicode_ci NOT NULL, 
`cep` varchar(10) COLLATE utf8_unicode_ci NOT NULL, 
`exibir_empresa` Tinyint (1) NOT NULL, 
PRIMARY KEY (`id`),
FOREIGN KEY (`id_empresa`) REFERENCES ee_empresa(id)

);