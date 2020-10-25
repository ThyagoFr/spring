CREATE TABLE public.users_addresses (
 	id SERIAL NOT NULL,
 	created_at TIMESTAMP WITHOUT TIME ZONE,
	deleted_at TIMESTAMP WITHOUT TIME ZONE,
	updated_at TIMESTAMP WITHOUT TIME ZONE,
	number INTEGER ,
	zip_code CHARACTER VARYING(9),
	logradouro CHARACTER VARYING(255),
	latitude CHARACTER VARYING(255),
	longitude CHARACTER VARYING(255),
	complement CHARACTER VARYING(255),
	city CHARACTER VARYING(255),
	state CHARACTER VARYING(2),
	neighborhood CHARACTER VARYING(255),
 	CONSTRAINT pk_address PRIMARY KEY(id)
)

TABLESPACE pg_default;

ALTER TABLE public.users_addresses
    OWNER to postgres;