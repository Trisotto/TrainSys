CREATE TABLE dev.exercises (
    id SERIAL,
    description VARCHAR(255) NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT pk_tbl_exercises PRIMARY KEY (id)
);