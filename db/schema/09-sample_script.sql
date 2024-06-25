-- Insert into users
INSERT INTO dev.users (name, email, date_birth, cpf, password, plan_id, role_id) VALUES
    ('John Doe', 'john.doe@example.com', '1980-01-01', '123.456.789-00', '$2a$10$DB7PnvkiTwyr/Rb4u5yH7e0jcAfJrSNJGzUIRI.yBMxfo8QQfnwfe', 1, 1),
    ('Jane Smith', 'jane.smith@example.com', '1990-02-02', '987.654.321-00', '$2a$10$s60p8W1pqSAXKlSN.GOa8OH6GabYOJTRBznfz1TPvnFLtpEzUDQkq', 2, 1);

-- Insert into exercises
INSERT INTO dev.exercises (description, user_id) VALUES
    ('Push-ups', 1),
    ('Squats', 2);

-- Insert into students
INSERT INTO dev.students (name, email, date_birth, cpf, contact, user_id, city, neighborhood, number, street, state, cep) VALUES
    ('Alice Johnson', 'alice.johnson@example.com', '2000-03-03', '111.222.333-44', '123-456-7890', 1, 'New York', 'Manhattan', '100', '5th Avenue', 'NY', '10001'),
    ('Bob Brown', 'bob.brown@example.com', '2005-04-04', '555.666.777-88', '098-765-4321', 2, 'Los Angeles', 'Hollywood', '200', 'Sunset Blvd', 'CA', '90028');

-- Insert into workouts
INSERT INTO dev.workouts (student_id, exercise_id, repetitions, weight, break_time, day, observations, time) VALUES
    (1, 1, 15, 0.0, 30, 'MONDAY', 'No issues', 10),
    (2, 2, 10, 20.0, 60, 'TUESDAY', 'Increase weight next week', 20);