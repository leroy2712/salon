--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.4
-- Dumped by pg_dump version 9.6.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: admin; Type: TABLE; Schema: public; Owner: leroy
--

CREATE TABLE admin (
    id integer NOT NULL,
    email character varying,
    password character varying
);


ALTER TABLE admin OWNER TO leroy;

--
-- Name: admin_id_seq; Type: SEQUENCE; Schema: public; Owner: leroy
--

CREATE SEQUENCE admin_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE admin_id_seq OWNER TO leroy;

--
-- Name: admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: leroy
--

ALTER SEQUENCE admin_id_seq OWNED BY admin.id;


--
-- Name: clients; Type: TABLE; Schema: public; Owner: leroy
--

CREATE TABLE clients (
    id integer NOT NULL,
    client character varying,
    stylist_id integer,
    email character varying
);


ALTER TABLE clients OWNER TO leroy;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: leroy
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO leroy;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: leroy
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: newsletter; Type: TABLE; Schema: public; Owner: leroy
--

CREATE TABLE newsletter (
    id integer NOT NULL,
    email character varying
);


ALTER TABLE newsletter OWNER TO leroy;

--
-- Name: newsletter_id_seq; Type: SEQUENCE; Schema: public; Owner: leroy
--

CREATE SEQUENCE newsletter_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE newsletter_id_seq OWNER TO leroy;

--
-- Name: newsletter_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: leroy
--

ALTER SEQUENCE newsletter_id_seq OWNED BY newsletter.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: leroy
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying,
    image character varying,
    age integer,
    experience character varying,
    specialties character varying
);


ALTER TABLE stylists OWNER TO leroy;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: leroy
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO leroy;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: leroy
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: admin id; Type: DEFAULT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY admin ALTER COLUMN id SET DEFAULT nextval('admin_id_seq'::regclass);


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: newsletter id; Type: DEFAULT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY newsletter ALTER COLUMN id SET DEFAULT nextval('newsletter_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: leroy
--

COPY admin (id, email, password) FROM stdin;
1	taylorswift@gmail.com	1989isdecent
2	info@hairsalon@gmail.com	halamadrid
\.


--
-- Name: admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: leroy
--

SELECT pg_catalog.setval('admin_id_seq', 2, true);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: leroy
--

COPY clients (id, client, stylist_id, email) FROM stdin;
1	Najma Mohammed	3	najma@gmail.com
2	Habida Abdullah	3	habida@gmail.com
3	Maryanne Wangare	1	maryann@gmail.com
4	Samira Chepchumba	1	samira@gmail.com
5	June Kyalo	2	june@gmail.com
6	Savannah Masika	2	masika@gmail.com
7	Hannah Salome	4	salome@gmail.com
8	Eileen Atieno	4	atieno@gmail.com
9	Imani Juma	5	imani@gmail.com
10	Lisa Wairimu	5	wairimu@gmail.com
11	Faith Lenana	6	lenana@gmail.com
12	ABahati Nelion	6	nelion@gmail.com
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: leroy
--

SELECT pg_catalog.setval('clients_id_seq', 12, true);


--
-- Data for Name: newsletter; Type: TABLE DATA; Schema: public; Owner: leroy
--

COPY newsletter (id, email) FROM stdin;
1	leroyomondi@gmail.com
2	charlestheclassrep@gmail.com
3	albert@gmail.com
4	moringa@gmail.com
5	bhoke@gmail.com
6	samsung@gmail.com
7	zahahadid@gmail.com
8	gigihadid@gmail.com
9	anita@gmail.com
\.


--
-- Name: newsletter_id_seq; Type: SEQUENCE SET; Schema: public; Owner: leroy
--

SELECT pg_catalog.setval('newsletter_id_seq', 9, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: leroy
--

COPY stylists (id, name, image, age, experience, specialties) FROM stdin;
1	Karen Wambui	/images/s1.jpg	28	5 years	Hair, Make-Up
2	Sharon Okoth	/images/s2.jpg	30	7 years	Hair, Make-Up, Manicure and Pedicure
3	Imani Wambua	/images/s3.jpg	32	10 years	Hair, Make-Up, Manicure and Pedicure
4	Hamsa Wangeci	/images/s4.jpg	30	5 years	Hair, Make-Up, Manicure
5	Anne Moraa	/images/s5.jpg	29	6 years	Hair, Make-Up
6	Celine Makena	/images/s6.jpg	27	5 years	Hair
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: leroy
--

SELECT pg_catalog.setval('stylists_id_seq', 6, true);


--
-- Name: admin admin_pkey; Type: CONSTRAINT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: newsletter newsletter_pkey; Type: CONSTRAINT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY newsletter
    ADD CONSTRAINT newsletter_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: clients clients_stylist_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: leroy
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_stylist_id_fkey FOREIGN KEY (stylist_id) REFERENCES stylists(id);


--
-- PostgreSQL database dump complete
--

