CREATE USER trisotto with encrypted password 'devPassword';
ALTER USER trisotto with superuser;
CREATE SCHEMA IF NOT EXISTS dev authorization trisotto;