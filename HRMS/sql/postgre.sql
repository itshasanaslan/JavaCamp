
DROP TABLE IF EXISTS employer_activation_codes;
DROP TABLE IF EXISTS employer_activation_employees;
DROP TABLE IF EXISTS employers;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS candidates;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS job_titles;

CREATE TABLE "public"."candidates"( 
	"id" int NOT NULL,
	"first_name" varchar(25) NOT NULL,
	"last_name" varchar(25) NOT NULL,
	"nationality_id" varchar(11) NOT NULL,
	"date_of_birth" date NOT NULL);

CREATE TABLE "public"."employees"( 
	"id" int NOT NULL,
	"first_name" varchar(25) NOT NULL,
	"last_name" varchar(25) NOT NULL);

CREATE TABLE "public"."employer_activation_codes"( 
	"id" int NOT NULL,
	"employer_id" int NOT NULL,
	"activation_code" varchar(38) NOT NULL,
	"is_confirmed" boolean NOT NULL,
	"confirmed_date" date);

CREATE TABLE "public"."employer_activation_employees"( 
	"id" int NOT NULL,
	"employer_id" int NOT NULL,
	"confirmed_employee_id" int,
	"is_confirmed" boolean NOT NULL,
	"confirmed_date" date);

CREATE TABLE "public"."employers"( 
	"id" int NOT NULL,
	"company_name" varchar(255) NOT NULL,
	"web_address" varchar(50) NOT NULL,
	"phone_number" varchar(12) NOT NULL,
	"is_activated" boolean NOT NULL);

CREATE TABLE "public"."job_titles"( 
	"id" int NOT NULL,
	"title" varchar(50) NOT NULL);

CREATE TABLE "public"."users"( 
	"id" int NOT NULL,
	"email" varchar(50) NOT NULL,
	"password" varchar(25) NOT NULL);

CREATE SEQUENCE "public"."employer_activation_codes_id_seq" 
    INCREMENT BY 1 START WITH 1 OWNED 
    BY "public"."employer_activation_codes"."id";

CREATE SEQUENCE "public"."employer_activation_employees_id_seq" 
    INCREMENT BY 1 START WITH 1 OWNED 
    BY "public"."employer_activation_employees"."id";

CREATE SEQUENCE "public"."job_titles_id_seq" 
    INCREMENT BY 1 START WITH 1 OWNED 
    BY "public"."job_titles"."id";

CREATE SEQUENCE "public"."users_id_seq" 
    INCREMENT BY 1 START WITH 1 OWNED 
    BY "public"."users"."id";

ALTER TABLE "public"."candidates" 
    ADD CONSTRAINT "pk_candidate_id" 
    PRIMARY KEY ("id");

ALTER TABLE "public"."employees" 
    ADD CONSTRAINT "pk_employees_id" 
    PRIMARY KEY ("id");

ALTER TABLE "public"."employer_activation_codes" 
    ADD CONSTRAINT "pk_employeractivationcodes_id" 
    PRIMARY KEY ("id");

ALTER TABLE "public"."employer_activation_employees" 
    ADD CONSTRAINT "pk_employeractivationemployees_id" 
    PRIMARY KEY ("id");

ALTER TABLE "public"."employers" 
    ADD CONSTRAINT "pk_employers_id" 
    PRIMARY KEY ("id");

ALTER TABLE "public"."job_titles" 
    ADD CONSTRAINT "pk_job_titles_id" 
    PRIMARY KEY ("id");

ALTER TABLE "public"."users" 
    ADD CONSTRAINT "pk_users_id" 
    PRIMARY KEY ("id");

ALTER TABLE "public"."candidates" 
    ADD CONSTRAINT "uc_candidates_nationality_id" 
    UNIQUE ("nationality_id");

ALTER TABLE "public"."job_titles" 
    ADD CONSTRAINT "uc_job_titles_title" 
    UNIQUE ("title");

ALTER TABLE "public"."users" 
    ADD CONSTRAINT "uc_users_email" 
    UNIQUE ("email");

ALTER TABLE "public"."candidates" 
    ADD CONSTRAINT "fk_candidates_users" 
    FOREIGN KEY ("id") 
    REFERENCES "public"."users" ( "id");

ALTER TABLE "public"."employees" 
    ADD CONSTRAINT "fk_employees_users" 
    FOREIGN KEY ("id") 
    REFERENCES "public"."users" ( "id");

ALTER TABLE "public"."employer_activation_codes" 
    ADD CONSTRAINT "fk_employer_activation_codes_employers" 
    FOREIGN KEY ("employer_id") 
    REFERENCES "public"."employers" ( "id");

ALTER TABLE "public"."employer_activation_employees" 
    ADD CONSTRAINT "fk_employer_activation_employees_employees" 
    FOREIGN KEY ("confirmed_employee_id") 
    REFERENCES "public"."employees" ( "id");

ALTER TABLE "public"."employer_activation_employees" 
    ADD CONSTRAINT "fk_employer_activation_employees_employers" 
    FOREIGN KEY ("employer_id") 
    REFERENCES "public"."employers" ( "id");

ALTER TABLE "public"."employers" 
    ADD CONSTRAINT "fk_employers_users" 
    FOREIGN KEY ("id") 
    REFERENCES "public"."users" ( "id");

ALTER TABLE "public"."employer_activation_codes" 
    ALTER COLUMN "id" 
    SET DEFAULT nextval('"public"."employer_activation_codes_id_seq"');

ALTER TABLE "public"."employer_activation_codes" 
    ALTER COLUMN "is_confirmed" 
    SET DEFAULT false;

ALTER TABLE "public"."employer_activation_employees" 
    ALTER COLUMN "id" 
    SET DEFAULT nextval('"public"."employer_activation_employees_id_seq"');

ALTER TABLE "public"."employer_activation_employees" 
    ALTER COLUMN "is_confirmed" 
    SET DEFAULT false;

ALTER TABLE "public"."employers" 
    ALTER COLUMN "is_activated" 
    SET DEFAULT false;

ALTER TABLE "public"."job_titles" 
    ALTER COLUMN "id" 
    SET DEFAULT nextval('"public"."job_titles_id_seq"');

ALTER TABLE "public"."users" 
    ALTER COLUMN "id" 
    SET DEFAULT nextval('"public"."users_id_seq"');

INSERT INTO "public"."job_titles" (title) 
VALUES ('Software Developer'),('Software Architect');

DO $$
    DECLARE user_id integer;
BEGIN
	INSERT INTO "public"."users" (email,password) VALUES('aslanhassan98@gmail.com','testPassword12') RETURNING id INTO user_id;
	INSERT INTO "public"."candidates" (id,first_name,last_name,nationality_id,date_of_birth) VALUES(user_id,'Hasan','Aslan','27730769786','1998-31-03');
END $$;
