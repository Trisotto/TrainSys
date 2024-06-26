CREATE TABLE dev.students (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    date_birth DATE NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    contact VARCHAR(20) NOT NULL,
    user_id INTEGER NOT NULL,
    city VARCHAR(50),
    neighborhood VARCHAR(50),
    number VARCHAR(30),
    street VARCHAR(30),
    state VARCHAR(2),
    cep VARCHAR(20),
    is_deleted BOOLEAN NOT NULL DEFAULT 'f',
    CONSTRAINT pk_tbl_students PRIMARY KEY (id)
);