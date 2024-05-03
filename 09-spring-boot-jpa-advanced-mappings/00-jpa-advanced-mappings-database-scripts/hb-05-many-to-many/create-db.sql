DROP SCHEMA IF EXISTS "hb-01-one-to-one-uni" CASCADE;

CREATE SCHEMA "hb-01-one-to-one-uni";

-- Use the created schema
SET search_path TO "hb-01-one-to-one-uni";

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
  FOREIGN KEY (instructor_detail_id) REFERENCES instructor_detail (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
