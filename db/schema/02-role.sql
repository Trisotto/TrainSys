CREATE TABLE dev.roles (
    id SERIAL,
    name VARCHAR(255) UNIQUE NOT NULL,
    description VARCHAR(255) NOT NULL,
    CONSTRAINT pk_tbl_roles PRIMARY KEY (id)
);

-- Insert plans
INSERT INTO dev.roles (name, description) VALUES ('USER', 'Regular user');
INSERT INTO dev.roles (name, description) VALUES ('ADMIN', 'Administrator');
INSERT INTO dev.roles (name, description) VALUES ('SUPER_ADMIN', 'Super administrator');