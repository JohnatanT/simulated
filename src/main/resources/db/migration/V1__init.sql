CREATE SEQUENCE student_seq;
CREATE SEQUENCE simulated_seq;
CREATE SEQUENCE student_simulated_seq;
CREATE SEQUENCE proof_seq;
CREATE SEQUENCE proof_question_seq;
CREATE SEQUENCE question_seq;
CREATE SEQUENCE question_item_seq;
CREATE SEQUENCE feedback_seq;
CREATE SEQUENCE feedback_question_seq;
CREATE SEQUENCE student_proof_seq;
CREATE SEQUENCE proof_answer_seq;

CREATE TABLE student (
	id bigint NOT NULL PRIMARY KEY,
	code VARCHAR(50) UNIQUE,
	name VARCHAR(500)
);

CREATE TABLE simulated (
	id bigint NOT NULL PRIMARY KEY,
	code VARCHAR(50) UNIQUE,
	created_at TIMESTAMP
);

CREATE TABLE student_simulated (
	id bigint NOT NULL PRIMARY KEY,
	simulated_id bigint,
	student_id bigint,
	FOREIGN KEY (simulated_id) REFERENCES simulated (id),
	FOREIGN KEY (student_id) REFERENCES student (id)
);

CREATE TABLE proof (
	id bigint NOT NULL PRIMARY KEY,
	code VARCHAR(50) UNIQUE,
	simulated_id bigint,
	FOREIGN KEY (simulated_id) REFERENCES simulated (id)
);

CREATE TABLE question (
	id bigint NOT NULL PRIMARY KEY,
	code VARCHAR(50) UNIQUE,
	description CLOB,
	image_url VARCHAR,
	level VARCHAR (20)
);

CREATE TABLE proof_question (
	id bigint NOT NULL PRIMARY KEY,
	proof_id bigint,
	question_id bigint,
	FOREIGN KEY (proof_id) REFERENCES proof (id),
	FOREIGN KEY (question_id) REFERENCES question (id)
);

CREATE TABLE question_item (
	id bigint NOT NULL PRIMARY KEY,
	question_id bigint,
	option VARCHAR,
	description CLOB
);

CREATE TABLE feedback (
	id bigint NOT NULL PRIMARY KEY,
	code VARCHAR UNIQUE,
	proof_id bigint,
	FOREIGN KEY (proof_id) REFERENCES proof (id)
);

CREATE TABLE feedback_question (
	id bigint NOT NULL PRIMARY KEY,
	feedback_id bigint,
	question_id bigint,
	correct_question_item_id bigint,
	FOREIGN KEY (feedback_id) REFERENCES feedback (id),
	FOREIGN KEY (question_id) REFERENCES question (id),
	FOREIGN KEY (correct_question_item_id) REFERENCES question_item (id)
);

CREATE TABLE student_proof (
	id bigint NOT NULL PRIMARY KEY,
	student_id bigint,
	proof_id bigint,
	FOREIGN KEY (student_id) REFERENCES student (id),
	FOREIGN KEY (proof_id) REFERENCES proof (id)
);

CREATE TABLE proof_answer (
	id bigint NOT NULL PRIMARY KEY,
	student_proof_id bigint,
	question_item_id bigint,
	question_id bigint,
	correct boolean,
	FOREIGN KEY (student_proof_id) REFERENCES student_proof (id),
	FOREIGN KEY (question_item_id) REFERENCES question_item (id),
	FOREIGN KEY (question_id) REFERENCES question (id)
);



