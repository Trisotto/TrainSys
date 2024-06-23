CREATE TABLE dev.plans (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    students_limit SMALLINT NOT NULL,
    CONSTRAINT pk_tbl_plans PRIMARY KEY (id)
);

-- Insert plans
INSERT INTO dev.plans (name, students_limit) VALUES ('Basic Plan', 15);
INSERT INTO dev.plans (name, students_limit) VALUES ('Premium Plan', 30);