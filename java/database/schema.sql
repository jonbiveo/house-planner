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
	city varchar(50) NOT NULL,
	state varchar(20) NOT NULL,
	house_type varchar(50) NOT NULL,
	size int NOT NULL,
	price_range_lower int NOT NULL,
	price_range_higher int NOT NULL,   
	
	CONSTRAINT PK_plan PRIMARY KEY (plan_id),
	CONSTRAINT fk_plans_users FOREIGN KEY (user_id) references users (user_id)
);

INSERT INTO users (username,email,password_hash,role) VALUES ('user','test@email.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,email,password_hash,role) VALUES ('admin', 'test2@email.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,email,password_hash,role) VALUES ('AnotherUser', 'test3@email.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,email,password_hash,role) VALUES ('OhNoAUser', 'test4@email.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');


INSERT INTO plans (user_id, plan_name, house_type, city, state, size, price_range_lower, price_range_higher)  
VALUES (1, 'Plan 1 (frUser)', 'single', 'Toledo', 'Ohio', 1000, 75415, 90498),
        (2, 'Plan 2 (frAnoth)', 'detached', 'Cleveland', 'Ohio', 2000, 129284, 158001),
        (3, 'Plan 3(frOh)', 'townhouse', 'Cincinnati', 'Ohio', 2500, 372587, 447105),
        (1, 'Plan 4 (frUser)', 'single', 'Toledo', 'Ohio', 2500, 320000, 380000),
        (2, 'Plan 5 (frAnoth)', 'detached', 'Toledo', 'Ohio', 2000, 433000, 540000),
        (3, 'Plan 6(frOh)', 'townhouse', 'Cleveland', 'Ohio', 2000, 800000, 900000),
        (1, 'Plan 7 (frUser)', 'single', 'Cincinnati', 'Ohio', 1500, 300000, 380000),
        (2, 'Plan 8 (frAnoth)', 'detached', 'Columbus', 'Ohio', 1000, 250000, 300000),
        (3, 'Plan 9 (frOh)', 'townhouse', 'Cleveland', 'Ohio', 1500, 280000, 320000);

CREATE TABLE rooms (
	room_id serial NOT NULL,
	plan_id int NOT NULL, 
	floor int NOT NULL,
	room_type varchar(50) NOT NULL,
	room_length int NOT NULL,
	room_width int NOT NULL,

	CONSTRAINT PK_rooms PRIMARY KEY (room_id),
	CONSTRAINT fk_room_plan FOREIGN KEY (plan_id) references plans (plan_id)
);

COMMIT TRANSACTION;
