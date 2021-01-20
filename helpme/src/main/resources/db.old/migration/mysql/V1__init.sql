
CREATE TABLE `cliente` (
  `id` int(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `problema` varchar(255) NOT NULL,
  `data_cadastro` datetime
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);
-- Indexes for table `funcionario`
--
--ALTER TABLE `funcionario`
--  ADD PRIMARY KEY (`id`);
--  ADD KEY `FK4cm1kg523jlopyexjbmi6y54j` (`empresa_id`);
