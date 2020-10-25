CREATE TABLE public.users (
 	id SERIAL NOT NULL,
 	created_at TIMESTAMP WITHOUT TIME ZONE,
	deleted_at TIMESTAMP WITHOUT TIME ZONE,
	updated_at TIMESTAMP WITHOUT TIME ZONE,
 	name CHARACTER VARYING(255) NOT NULL,
 	email CHARACTER VARYING(255) NOT NULL UNIQUE,
 	cpf CHARACTER VARYING(11) NOT NULL UNIQUE,
 	telephone CHARACTER VARYING(20),
 	password CHARACTER VARYING(255) NOT NULL,
 	age INTEGER ,
 	gender CHARACTER VARYING (1),
 	id_curriculum INTEGER ,
 	id_address INTEGER ,
 	CONSTRAINT pk_user PRIMARY KEY(id),
 	CONSTRAINT fk_users_addresses
	FOREIGN KEY (id_address)
	REFERENCES users_addresses(id)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;

CREATE INDEX idx_user_cpf
 	ON public.users USING hash
 	(cpf)
 	TABLESPACE pg_default;

CREATE INDEX idx_user_email
 	ON public.user USING hash
 	(email)
 	TABLESPACE pg_default;