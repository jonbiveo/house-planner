BEGIN TRANSACTION;

DROP TABLE IF EXISTS plans;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE plans (
	plan_id serial NOT NULL,
	user_id int NOT NULL,
	plan_name varchar(50) NOT NULL,
	house_type varchar(50) NOT NULL,
	city varchar(50) NOT NULL,
	state varchar(20) NOT NULL,
	size int NOT NULL,
	
	CONSTRAINT PK_plan PRIMARY KEY (plan_id),
	CONSTRAINT fk_plans_users FOREIGN KEY (user_id) references users (user_id)
);

INSERT INTO users (username,email,password_hash,role) VALUES ('user','test@email.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,email,password_hash,role) VALUES ('admin', 'test2@email.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO plans (user_id, plan_name, house_type, city, state, size)  
VALUES (1, 'Test Plan 1', 'single', 'Cleveland', 'Ohio', 2000),
        (1, 'Test Plan 2', 'detached', 'Cleveland', 'Ohio', 2000),
        (1, 'Test Plan 3', 'townhouse', 'Cleveland', 'Ohio', 2000),
        (1, 'Test Plan 4', 'single', 'Cleveland', 'Ohio', 2000),
        (1, 'Test Plan 5', 'detached', 'Cleveland', 'Ohio', 2000),
        (1, 'Test Plan 6', 'townhouse', 'Cleveland', 'Ohio', 2000),
        (1, 'Test Plan 7', 'single', 'Cleveland', 'Ohio', 2000),
        (1, 'Test Plan 8', 'detached', 'Cleveland', 'Ohio', 2000),
        (1, 'Test Plan 9', 'townhouse', 'Cleveland', 'Ohio', 2000);


COMMIT TRANSACTION;
