CREATE TABLE IF NOT EXISTS public.company_tbl
(
    description character varying(255) COLLATE pg_catalog."default",
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT company_tbl_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.company_tbl
    OWNER to postgres;