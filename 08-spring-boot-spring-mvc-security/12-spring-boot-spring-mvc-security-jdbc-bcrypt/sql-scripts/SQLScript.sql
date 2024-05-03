
-- Table structure for table `users`
--

CREATE TABLE "users" (
  "username" varchar(50) PRIMARY KEY NOT NULL,
  "password" varchar(50) NOT NULL,
  "enabled" smallint NOT NULL
   
);

--
-- Inserting data for table `users`
--

INSERT INTO "users" 
VALUES 
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE "authorities" (
  "username" varchar(50) NOT NULL,
  "authority" varchar(50) NOT NULL,
  CONSTRAINT authorities_pk PRIMARY KEY (username,authority),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
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
