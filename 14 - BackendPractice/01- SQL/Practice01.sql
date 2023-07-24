--Tek satirli yorum
/*
cok satrili yorum

*/

--Ornek : Ogrenciler isimli bir tablo olusturalim

CREATE TABLE ogrenciler (
	id integer primary key,
	isim varchar(50),
	adres varchar(100),
	sinav_notu integer
);


--Tablonun icine ogrenci ekleyelim
insert into ogrenciler values(1,'Muhammed Emin Kaba','Ankara',100);


insert into ogrenciler (id,isim,adres,sinav_notu) values
	(2,'Burcu Ozturk','Istanbul',80),
	(3,'Cemal Dogan','Izmir',55);

		
select * from ogrenciler;

delete from ogrenciler;

drop table ogrenciler

--constraint :kisitlamalar
--primary key:Birincil anahtar, unique (benzersiz) ve not null olmamali
--Unique : Sutundaki verileri benzersiz olma kisitlmasi katar

----Soru 2: Bir onceki tabloyu create ederken isime unique constrainti ekleyin
CREATE TABLE ogrenciler (
	id integer primary key,
	isim varchar(50) unique,
	adres varchar(100),
	sinav_notu integer
);
insert into ogrenciler values(1,'Muhammed Emin Kaba','Ankara',100);


insert into ogrenciler (id,isim,adres,sinav_notu) values
	(2,'Burcu Ozturk','Istanbul',80),
	(3,'Burcu Ozturk','Izmir',55);
	
--Not null :Bir sutun bos birakilmamasi gerekiyorsa not null kullanilir
--Soru 3 Yukaridaki tabloyu siliniz sinav_notu degiskenine not null ekleyiniz
drop table ogrenciler;

CREATE TABLE ogrenciler (
	id integer primary key,
	isim varchar(50) unique,
	adres varchar(100),
	sinav_notu integer not null
);
insert into ogrenciler (id,isim,adres,sinav_notu) values
	(2,'Burcu Ozturk','Istanbul',80),
	(3,'Burcu Oztur','',55);	
	
insert into ogrenciler values(1,'Muhammed Emin Kaba','Ankara');

-check 

--Soru 3 Yukaridaki tabloyu silip sinav_notu not null yerine 70 ten buyuk olma sarti koyununuz 
drop table ogrenciler;


create table ogrenciler(
id integer primary key,
isim varchar unique,
adres varchar,
sinav_notu integer check(sinav_notu>70)
);
insert into ogrenciler values(1,'Muhammed Emin Kaba','Ankara',75);

--foreign key: tablolar arasi iliski kurulmasi istendiginde foreign key kullanilir
create table memurlar(
	id int primary key,
	isim varchar(30),
	maas int 
);

create table sendika(
	sendika_id int primary key,
	sendika_ismi varchar(50),
	memur_id int,
	constraint fk_memur_id foreign key(memur_id) references memurlar(id)
);

--memurlar tablosuna 3 veri ekleyelim
INSERT INTO memurlar (id, isim, maas) VALUES
(1, 'Ahmet', 6000),
(2, 'Ayşe', 7000),
(3, 'Mehmet', 5500);

INSERT INTO sendika (sendika_id, sendika_ismi, memur_id) VALUES
(1, 'Sendika A', 1),
(2, 'Sendika B', 2),
(3, 'Sendika C', 3);

select * from memurlar;





