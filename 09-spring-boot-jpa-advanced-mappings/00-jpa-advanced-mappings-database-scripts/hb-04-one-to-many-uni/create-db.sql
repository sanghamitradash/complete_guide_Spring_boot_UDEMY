CREATE SCHEMA "hb-04-one-to-many-uni";

SET search_path TO "hb-04-one-to-many-uni";

CREATE TABLE "instructor_detail" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "youtube_channel" varchar(128) DEFAULT NULL,
  "hobby" varchar(45) DEFAULT NULL
);


CREATE TABLE "instructor" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "first_name" varchar(45) DEFAULT NULL,
  "last_name" varchar(45) DEFAULT NULL,
  "email" varchar(45) DEFAULT NULL,
  "instructor_detail_id" int DEFAULT NULL,
  CONSTRAINT "FK_DETAIL" FOREIGN KEY ("instructor_detail_id") 
  REFERENCES "instructor_detail" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE "course" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "title" varchar(128) DEFAULT NULL,
  "instructor_id" int DEFAULT NULL,
  
  CONSTRAINT "FK_INSTRUCTOR" 
  FOREIGN KEY ("instructor_id") 
  REFERENCES "instructor" ("id") 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE "review" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "comment" varchar(256) DEFAULT NULL,
  "course_id" int DEFAULT NULL,

  CONSTRAINT "FK_COURSE" 
  FOREIGN KEY ("course_id") 
  REFERENCES "course" ("id") 

  ON DELETE NO ACTION ON UPDATE NO ACTION
);
