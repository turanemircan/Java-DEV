------------------DAY'2------------------------
----TEKRAR--------
CREATE TABLE sairler(
id int,
name varchar(50),
email varchar(50)	
);

INSERT INTO sairler VALUES(1001,'Can Yücel','sair@gmail.com');
INSERT INTO sairler VALUES(1002,'İsmet Özel','sair@gmail.com');
INSERT INTO sairler VALUES(1003,'','sair@gmail.com');

INSERT INTO sairler(name) VALUES('Nazım Hikmet');


SELECT * FROM sairler;

--9-tabloya UNIQUE constrainti ekleme
CREATE TABLE developers(
id SERIAL,
name VARCHAR(50),
email VARCHAR(50) UNIQUE,
salary REAL,
prog_lang VARCHAR(20)
);

INSERT INTO developers(name,email,salary,prog_lang) VALUES('Mehmet Bey','dev@email.com',5000,'Java');
INSERT INTO developers(name,email,salary,prog_lang) VALUES('Ekim Hanım','developer@email.com',5000,'Java');
INSERT INTO developers(email,salary,prog_lang) VALUES('developer2@email.com',5000,'JavaScript');


SELECT * FROM developers;

--10-tabloya NOT NULL constrainti ekleme
CREATE TABLE doctors(
id SERIAL,
name VARCHAR(50) NOT NULL,
email VARCHAR(50) UNIQUE,
salary REAL
);

INSERT INTO doctors(name,email,salary) VALUES('Dr.Gregory House','dr@email.com',7000);
INSERT INTO doctors(email,salary) VALUES('doctor@email.com',7000);--name null old. için kabul etmez

INSERT INTO doctors(name,email,salary) VALUES('','doctorwho@email.com',7000);--isim empty
--''(empty) ile null aynı şey değildir.

SELECT * FROM doctors;

--11-PK constrainti ekleme
CREATE TABLE students2(
id int PRIMARY KEY,--not null,unique,başka bir tablo ile ilişki kurmak için kullanılacak
name varchar(50),
grade real,
register_date date
);

SELECT * FROM students2;

--11-PK constrainti ekleme:2. yöntem

CREATE TABLE students3(
id int,--not null,unique,başka bir tablo ile ilişki kurmak için kullanılacak
name varchar(50) NOT NULL,
grade real,
register_date date,
CONSTRAINT std_pk PRIMARY KEY(id)	
);

SELECT * FROM students3;

--composite key

CREATE TABLE students4(
id int,
name varchar(50) NOT NULL,--not null ı constraint olarak göstermez
grade real,
register_date date,
CONSTRAINT std4_pk PRIMARY KEY(id,name)--birden fazla field PK olarak belirlenebilir	
);

SELECT * FROM students4;

--12-FK tanımlama-students3-address3
CREATE TABLE address3(
address_id int,
street varchar(50),
city varchar(50),
student_id int,--FK,null kabul eder,duplicate kabul eder
CONSTRAINT add_fk FOREIGN KEY(student_id) REFERENCES students3(id)	
);

SELECT * FROM address3;

--13--CHECK const ekleme
CREATE TABLE personel(
id int,
name varchar(50) NOT NULL CHECK(name <> ''),-- <> : not equals
salary real CHECK(salary>5000),
age int CHECK(age>0) --negatif kabul etmez
);

INSERT INTO personel VALUES(1,'',10000,25);
INSERT INTO personel VALUES(2,'name',1000,25);
INSERT INTO personel VALUES(3,'name',10000,-5);
INSERT INTO personel VALUES(4,'Ali Can',10000,25);








