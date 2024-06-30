CREATE TABLE MEMBER(
mem_code NUMBER PRIMARY KEY,
mem_id VARCHAR2(30),
mem_name VARCHAR2(30),
mem_nickname VARCHAR2(30),
mem_pw VARCHAR2(30),
mem_address VARCHAR2(255),
mem_email VARCHAR2(100),
mem_phone VARCHAR2(30),
mem_ssn VARCHAR2(30),
mem_join_date DATE DEFAULT SYSDATE,
mem_gender CHAR(1)
);