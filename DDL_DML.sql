 	CREATE TABLE public.vaga (
	id_vaga serial4 NOT NULL,
	empresa varchar(255) NULL,
	cargo_vaga varchar(100) NULL,
	localidade varchar(100) NULL,
	salario varchar(100) NULL,
	hora_trabalho varchar(100) null,
	CONSTRAINT vaga_pkey PRIMARY KEY (id_vaga)
);

CREATE TABLE public.perfil (
	id_perfil serial4 NOT NULL,
	nome_perfil varchar(100) NULL,
	CONSTRAINT perfil_pkey PRIMARY KEY (id_perfil)
);

CREATE TABLE public.usuario (
	id_usuario serial4 NOT NULL,
	nome_usuario varchar(100) NULL,
	email varchar(100) NULL,
	senha varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)
);

CREATE TABLE public.usuario_rel_perfil (
	id_usuario int8 NULL,
	id_perfil int8 NULL,
	CONSTRAINT usuario_rel_perfil_id_perfil_fkey FOREIGN KEY (id_perfil) REFERENCES public.perfil(id_perfil),
	CONSTRAINT usuario_rel_perfil_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario)
);

INSERT INTO usuario (NOME_USUARIO,EMAIL,SENHA) VALUES
	 ('usuario','usuario@mail.com','$2a$12$3COb/LHNYO/JeLWy1ExGFe6U2iyFczP70/kBUEHbf9miQ4Vp64A42');