DROP TABLE IF EXISTS "authorities";
DROP TABLE IF EXISTS "users";

--
-- Table structure for table `users`
--

CREATE TABLE "users" (
  "username" varchar(50) NOT NULL,
  "password" char(68) NOT NULL,
  "enabled" smallint NOT NULL,
  PRIMARY KEY ("username")
);

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO "users"
VALUES 
('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE "authorities" (
  "username" varchar(50) NOT NULL,
  "authority" varchar(50) NOT NULL,
  CONSTRAINT authorities_pk PRIMARY KEY (username, authority),
  CONSTRAINT authorities_fk FOREIGN KEY (username) REFERENCES users (username)
);

--
-- Inserting data for table `authorities`
--

INSERT INTO "authorities" 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');