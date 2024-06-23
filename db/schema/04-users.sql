CREATE TABLE dev.users (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    date_birth DATE NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    plan_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT pk_tbl_users PRIMARY KEY (id)
);