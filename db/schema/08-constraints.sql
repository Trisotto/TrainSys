ALTER TABLE dev.users ADD CONSTRAINT fk_users_plans FOREIGN KEY (plan_id) REFERENCES dev.plans(id);

ALTER TABLE dev.exercises ADD CONSTRAINT fk_exercises_users FOREIGN KEY (user_id) REFERENCES dev.users(id);

ALTER TABLE dev.students ADD CONSTRAINT fk_students_users FOREIGN KEY (user_id) REFERENCES dev.users(id);

ALTER TABLE dev.workouts ADD CONSTRAINT fk_workouts_students FOREIGN KEY (student_id) REFERENCES dev.students(id);

ALTER TABLE dev.workouts ADD CONSTRAINT fk_workouts_exercises FOREIGN KEY (exercise_id) REFERENCES dev.exercises(id);