CREATE TABLE dev.workouts (
    id SERIAL,
    student_id INTEGER NOT NULL,
    exercise_id INTEGER NOT NULL,
    repetitions INTEGER NOT NULL,
    weight DECIMAL NOT NULL,
    break_time INTEGER NOT NULL,
    day VARCHAR(10) NOT NULL,
    observations TEXT,
    time INTEGER NOT NULL,
    CONSTRAINT pk_tbl_workouts PRIMARY KEY (id)
);