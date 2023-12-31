PGDMP         %                {         	   agit_test    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16398 	   agit_test    DATABASE     �   CREATE DATABASE agit_test WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Indonesia.1252';
    DROP DATABASE agit_test;
                postgres    false            �            1259    16414    tbl_buku    TABLE     1  CREATE TABLE public.tbl_buku (
    id bigint NOT NULL,
    bukuid character varying(255),
    halaman character varying(255),
    judul character varying(255),
    penertbit character varying(255),
    pengarang character varying(255),
    status integer,
    tanggalterbit timestamp without time zone
);
    DROP TABLE public.tbl_buku;
       public         heap    postgres    false            �            1259    16406    tbl_buku_seq    SEQUENCE     v   CREATE SEQUENCE public.tbl_buku_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.tbl_buku_seq;
       public          postgres    false            �            1259    16421    trx_peminjaman    TABLE     �   CREATE TABLE public.trx_peminjaman (
    id bigint NOT NULL,
    bukuid character varying(255),
    peminjam character varying(255),
    tanggalkembali timestamp without time zone,
    tanggalpinjam timestamp without time zone
);
 "   DROP TABLE public.trx_peminjaman;
       public         heap    postgres    false            �            1259    16428    trx_peminjaman_seq    SEQUENCE     |   CREATE SEQUENCE public.trx_peminjaman_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.trx_peminjaman_seq;
       public          postgres    false            �          0    16414    tbl_buku 
   TABLE DATA           k   COPY public.tbl_buku (id, bukuid, halaman, judul, penertbit, pengarang, status, tanggalterbit) FROM stdin;
    public          postgres    false    215          �          0    16421    trx_peminjaman 
   TABLE DATA           ]   COPY public.trx_peminjaman (id, bukuid, peminjam, tanggalkembali, tanggalpinjam) FROM stdin;
    public          postgres    false    216   o                  0    0    tbl_buku_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.tbl_buku_seq', 151, true);
          public          postgres    false    214                       0    0    trx_peminjaman_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.trx_peminjaman_seq', 51, true);
          public          postgres    false    217            k           2606    16420    tbl_buku tbl_buku_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tbl_buku
    ADD CONSTRAINT tbl_buku_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.tbl_buku DROP CONSTRAINT tbl_buku_pkey;
       public            postgres    false    215            m           2606    16427 "   trx_peminjaman trx_peminjaman_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.trx_peminjaman
    ADD CONSTRAINT trx_peminjaman_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.trx_peminjaman DROP CONSTRAINT trx_peminjaman_pkey;
       public            postgres    false    216            �   P   x�340�40t�420��(�J���I-JU�ɬL�4 �Z�������q� �D����$�c�e��+F��� t�O      �   /   x�3�40������4202�50�50R00�20 "��!\�+F��� C�
�     