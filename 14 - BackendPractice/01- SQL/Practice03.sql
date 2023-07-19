
CREATE TABLE parent
(
vergi_no int PRIMARY KEY, 
firma_ismi VARCHAR(50), 
irtibat_ismi VARCHAR(50)
);

INSERT INTO parent VALUES (101, 'IBM', 'Kim Yon');
INSERT INTO parent VALUES (102, 'Huwaei', 'Çin Li');
INSERT INTO parent VALUES (103, 'Erikson', 'Maki Tammen');
INSERT INTO parent VALUES (104, 'Apple', 'Adam Eve');

CREATE TABLE child
(
ted_vergino int,
urun_id int,
urun_isim VARCHAR (50),
musteri_isim VARCHAR(50),

CONSTRAINT fk FOREIGN KEY (ted_vergino) REFERENCES parent (vergi_no)
);

INSERT INTO child VALUES (101, 1001, 'Laptop', 'Ayşe Can');
INSERT INTO child VALUES (102, 1002, 'Phone', 'Fatma Aka');
INSERT INTO child VALUES (102, 1003, 'TV', 'Ramazan Öz');
INSERT INTO child VALUES (102, 1004, 'Laptop', 'Veli Han');
INSERT INTO child VALUES (103, 1005, 'Phone', 'Canan Ak');
INSERT INTO child VALUES (104, 1006, 'TV', 'Ali Bak');
INSERT INTO child VALUES (104, 1007, 'Phone', 'Aslan Yılmaz');
select * from child;

--Soru 1: child tablosuna ted_vergi nosu 101 olan bir veri girişi yapınız
insert into child values(101,1008,'Araba','Fevzi Bey');

--Soru 2: child tablosuna ted_verginosu 105 olan veri girişi yapınız.
insert into child values(105,1008,'Araba','Fevzi Bey');
--105 verg,_no parentta olmadigi icin eklenemedi

--Soru 3:  child tablosuna ted_vergino null veri girişi olabilir mi

insert into child values(null,1010,'Bisiklet','Fatih Bey');
--null parentta olmasa da istisna olarak eklenebilir

--Soru 4: parent tablosundaki vergi_no 101 olan veriyi siliniz
delete from parent where vergi_no=101;

--Soru 5:child tablosunda ted_vergino 101 olan ürünleri siliniz.
delete from child where ted_vergino=101;

--Soru 6: parent tablosundaki vergi_no 101 olan veriyi siliniz
delete from parent where vergi_no=101;

--Soru 7: parent tablosunu siliniz.
drop table parent;
--child silinmeden parent silinmez

--Soru 8: child tablosunu siliniz
drop table child;

--Soru 9: parent tabloyu siliniz
drop table parent;

CREATE TABLE parent2
(
vergi_no int PRIMARY KEY, 
firma_ismi VARCHAR(50), 
irtibat_ismi VARCHAR(50)
);
INSERT INTO parent2 VALUES (101, 'IBM', 'Kim Yon');
INSERT INTO parent2 VALUES (102, 'Huwaei', 'Çin Li');
INSERT INTO parent2 VALUES (103, 'Erikson', 'Maki Tammen');
INSERT INTO parent2 VALUES (104, 'Apple', 'Adam Eve');
CREATE TABLE child2
(
ted_vergino int,
urun_id int,
urun_isim VARCHAR (50),
musteri_isim VARCHAR(50),

CONSTRAINT fk FOREIGN KEY (ted_vergino) REFERENCES parent2 (vergi_no)
ON DELETE CASCADE
);

INSERT INTO child2 VALUES (101, 1001, 'Laptop', 'Ayşe Can');
INSERT INTO child2 VALUES (102, 1002, 'Phone', 'Fatma Aka');
INSERT INTO child2 VALUES (102, 1003, 'TV', 'Ramazan Öz');
INSERT INTO child2 VALUES (102, 1004, 'Laptop', 'Veli Han');
INSERT INTO child2 VALUES (103, 1005, 'Phone', 'Canan Ak');
INSERT INTO child2 VALUES (104, 1006, 'TV', 'Ali Bak');
INSERT INTO child2 VALUES (104, 1007, 'Phone', 'Aslan Yılmaz');

--Soru 1:  parent2 tablosundaki tüm verileri siliniz
delete from parent2;

select * from child2;

--Soru 2:parent2 tablosunu siliniz
drop table parent2 cascade;

--Soru 3 : child tablosunu siliniz
drop table child2;

CREATE TABLE toptancilar
(
vergi_no int PRIMARY KEY,
sirket_ismi VARCHAR(40),
irtibat_ismi VARCHAR(30)
);

INSERT INTO toptancilar VALUES (201, 'IBM', 'Kadir Şen'); 
INSERT INTO toptancilar VALUES (202, 'Huawei', 'Çetin Hoş');
INSERT INTO toptancilar VALUES (203,'Erikson', 'Mehmet Gör'); 
INSERT INTO toptancilar VALUES (204, 'Apple', 'Adem Coş');

CREATE TABLE malzemeler  
(
ted_vergino int,
malzeme_id int,
malzeme_isim VARCHAR(20),
musteri_isim VARCHAR(25),
CONSTRAINT FK FOREIGN KEY (ted_vergino) REFERENCES toptancilar (vergi_no) on delete cascade
);
INSERT INTO malzemeler VALUES (201, 1001, 'Laptop', 'Asli Can'); 
INSERT INTO malzemeler VALUES (202, 1002, 'Telefon', 'Fatih Ak'); 
INSERT INTO malzemeler VALUES (202, 1003, 'TV', 'Ramiz Özmen');
INSERT INTO malzemeler VALUES (202, 1004, 'Laptop', 'Veli Tan');

select * from malzemeler;

--Soru 1: vergi_no su 202 olan toptancının şirket_ismini ‘VivoBook’ olarak güncelleyin
update toptancilar set sirket_ismi='VivoBook' where vergi_no=202;

--Soru 2: toptancilar tablosundaki tüm şirket isimlerini ‘NOKIA’ olarak güncelleyiniz
update toptancilar set sirket_ismi='NOKIA';

--Soru 3: vergi_no su 201 olan toptancının şirket ismini nokia ve irtibat_ismini Canan Can olarak güncelleyiniz
update toptancilar set sirket_ismi='nokia',irtibat_ismi='Canan Can' where vergi_no=201;

--Soru 4: toptancılar tablosunda Şirket ismi nokia olan firmanın irtibat ismini Bilal Ayhan diye güncelle
UPDATE toptancilar
SET irtibat_ismi='Bilal Ayhan'
WHERE sirket_ismi='nokia';

--Soru 5 : malzemeler tablosundaki Telefon değerlerini phone olarak güncelleyiniz
UPDATE malzemeler SET malzeme_isim = 'phone' WHERE malzeme_isim = 'Telefon';

--Soru 6: Malzemeler tablosundaki malzeme_id değeri 1002 den büyük olanların malzeme id lerini 1 arttırınız
UPDATE malzemeler
SET  malzeme_id = malzeme_id+1
WHERE malzeme_id > 1002;

--Soru 7: malzemeler tablosundaki tüm malzemelerin malzeme_id değerlerini tedarik vergi no ile toplayarak güncelleyiniz
UPDATE malzemeler
SET malzeme_id=ted_vergino+malzeme_id;

--Tabloları siliniz

CREATE TABLE toptancilar
(
vergi_no int PRIMARY KEY,
sirket_ismi VARCHAR(40),
irtibat_ismi VARCHAR(30)
);
INSERT INTO toptancilar VALUES (201, 'IBM', 'Kadir Şen'); 
INSERT INTO toptancilar VALUES (202, 'Huawei', 'Çetin Hoş');
INSERT INTO toptancilar VALUES (203,'Erikson', 'Mehmet Gör'); 
INSERT INTO toptancilar VALUES (204, 'Apple', 'Adem Coş');

CREATE TABLE malzemeler  
(
ted_vergino int,
malzeme_id int,
malzeme_isim VARCHAR(20),
musteri_isim VARCHAR(25),
CONSTRAINT FK FOREIGN KEY (ted_vergino) REFERENCES toptancilar (vergi_no) on delete cascade
);

INSERT INTO malzemeler VALUES (201, 1001, 'Laptop', 'Asli Can'); 
INSERT INTO malzemeler VALUES (202, 1002, 'Telefon', 'Fatih Ak'); 
INSERT INTO malzemeler VALUES (202, 1003, 'TV', 'Ramiz Özmen');
INSERT INTO malzemeler VALUES (202, 1004, 'Laptop', 'Veli Tan');
select * from malzemeler;

--SORU: Malzemeler tablosundaki musteri_isim'i Asli Can olan malzeme_isim'ini, --toptancılar
--tablosunda irtibat_ismi 'Adem Coş' olan sirket_ismi ile güncelleyiniz.
update malzemeler set malzeme_isim=(select sirket_ismi from toptancilar  where irtibat_ismi='Adem Coş')
where musteri_isim='Asli Can'

--select sirket_ismi from toptancilar  where irtibat_ismi='Adem Coş'






