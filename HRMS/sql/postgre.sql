--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-26 15:11:20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 57459)
-- Name: activation_codes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.activation_codes (
    id integer NOT NULL,
    user_id integer NOT NULL,
    code character varying NOT NULL,
    is_validated boolean DEFAULT false NOT NULL
);


ALTER TABLE public.activation_codes OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 57359)
-- Name: candidates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidates (
    id integer NOT NULL,
    user_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    nationality_id character varying(11) NOT NULL,
    date_of_birth date NOT NULL
);


ALTER TABLE public.candidates OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 57440)
-- Name: companies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.companies (
    id integer NOT NULL,
    user_id integer NOT NULL,
    company_name character varying NOT NULL,
    web_address character varying NOT NULL,
    phone_number character varying NOT NULL,
    is_activated boolean DEFAULT false NOT NULL
);


ALTER TABLE public.companies OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 57425)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 57420)
-- Name: job_titles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_titles (
    id integer NOT NULL,
    title character varying(255)
);


ALTER TABLE public.job_titles OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 57351)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying NOT NULL,
    password character varying(25) NOT NULL,
    is_validated boolean DEFAULT false NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2891 (class 2606 OID 57466)
-- Name: activation_codes activation_codes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_codes
    ADD CONSTRAINT activation_codes_pkey PRIMARY KEY (id);


--
-- TOC entry 2877 (class 2606 OID 57372)
-- Name: candidates candidates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_pkey PRIMARY KEY (id);


--
-- TOC entry 2886 (class 2606 OID 57448)
-- Name: companies companies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.companies
    ADD CONSTRAINT companies_pkey PRIMARY KEY (id);


--
-- TOC entry 2873 (class 2606 OID 57475)
-- Name: users email_uniqueness_on_users; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT email_uniqueness_on_users UNIQUE (email) INCLUDE (email);


--
-- TOC entry 2882 (class 2606 OID 57424)
-- Name: job_titles job_titles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_pkey PRIMARY KEY (id);


--
-- TOC entry 2884 (class 2606 OID 57450)
-- Name: job_titles job_titles_title_title1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_title_title1_key UNIQUE (title) INCLUDE (title);


--
-- TOC entry 2889 (class 2606 OID 57479)
-- Name: companies user-id_unique_on_companies; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.companies
    ADD CONSTRAINT "user-id_unique_on_companies" UNIQUE (user_id) INCLUDE (user_id);


--
-- TOC entry 2880 (class 2606 OID 57428)
-- Name: candidates user_id_uniqueness_on_candidates; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT user_id_uniqueness_on_candidates UNIQUE (user_id) INCLUDE (user_id);


--
-- TOC entry 2875 (class 2606 OID 57355)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2878 (class 1259 OID 57378)
-- Name: fki_Candidate_from_users; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_Candidate_from_users" ON public.candidates USING btree (user_id);


--
-- TOC entry 2887 (class 1259 OID 57456)
-- Name: fki_user_fk_on_companies; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_user_fk_on_companies ON public.companies USING btree (user_id);


--
-- TOC entry 2892 (class 1259 OID 57472)
-- Name: fki_user_id_fk_on_activation_codes; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_user_id_fk_on_activation_codes ON public.activation_codes USING btree (user_id);


--
-- TOC entry 2893 (class 2606 OID 57373)
-- Name: candidates Candidate_from_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT "Candidate_from_users" FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2894 (class 2606 OID 57451)
-- Name: companies user_fk_on_companies; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.companies
    ADD CONSTRAINT user_fk_on_companies FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2895 (class 2606 OID 57467)
-- Name: activation_codes user_id_fk_on_activation_codes; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_codes
    ADD CONSTRAINT user_id_fk_on_activation_codes FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


-- Completed on 2021-05-26 15:11:20

--
-- PostgreSQL database dump complete
--

