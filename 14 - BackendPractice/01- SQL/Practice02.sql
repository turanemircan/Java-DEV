--Practice 2----

--product ile image arasinda nasil bir iliski var
--one to many

--product ile shopping cart item arasindaki ilişki//bir urune ait birden fazla indirim kuponu olabilir
--one to many

--product ile brand arasinda //her urunun bir markası vardır bir markanın birden fazla urun cesiti olabilir
--many to one

---product ile category arasindaki iliski
--many to one
--product ile review arasinda iliski
--onetomany

--product ile order item arasindaki iliski
--onetomany

--user order coupon arasindaki ilişki
--one to many
/*
1.	Veri Sorgulama Dili (Data Query Language - DQL)
SELECT: Veri Tabanındaki verileri alır.

2.	Veri Kullanma Dili (Data Manipulation Language - DML)
INSERT : Veritabanına yeni veri ekler.  
UPDATE : Veritabanındaki verileri günceller.  
DELETE : Veritabanındaki verileri siler.

3.	Veri Tanimlama Dili (Data Definition Language - DDL)
CREATE : Bir veritabanı veya veritabanı içinde tablo oluşturur.  
ALTER : Bir veritabanı veya veritabanı içindeki tabloyu günceller.  
DROP : Bir veritabanını veya veritabanı içindeki tabloyu siler.

4.	Veri Kontrol Dili (Data Control Language - DCL)
GRANT : Bir kullanıcıya yetki vermek için kullanılır.
REVOKE : Bir kullanıcıya verilen yetkiyi geri almak için kullanılır.
*/

drop table ogrenciler;
drop table sendika;
CREATE TABLE ogrenciler (
    id INTEGER PRIMARY KEY,
    isim VARCHAR(50),
    adres VARCHAR(100),
    sinav_notu INTEGER
);
INSERT INTO ogrenciler (id, isim, adres, sinav_notu) VALUES
(1, 'Ahmet Yılmaz', 'Ankara', 80),
(2, 'Burcu Öztürk', 'İstanbul', 90),
(3, 'Cemal Doğan', 'İzmir', 70),
(4, 'Deniz Arslan', 'Adana', 85),
(5, 'Ebru Kaya', 'Bursa', 95),
(6, 'Fatih Demir', 'Antalya', 65),
(7, 'Gizem Tekin', 'Konya', 75);

--Soru 1: Öğrenciler tablosundaki id ve isim sütununu getiriniz
select id,isim from ogrenciler;

--Soru 2: Sınav notu 80 den büyük olan öğrencilerin tüm bilgilerini listele
select * from ogrenciler where sinav_notu>80;

--Soru 3:Adresi Ankara olan öğrencilerin tüm bilgilerini getir
select * from ogrenciler where adres='Ankara';

--Soru 4: Sınav notu 80 ve adresi Ankara Olan öğrenci ismini getirsin
select isim from ogrenciler where sinav_notu=80 and adres='Ankara';

--Soru 5: Sınav notu 65 veya 80 olan öğrencilerin tüm bilgilerini listeleme
select * from ogrenciler where sinav_notu=65 or sinav_notu=80;
select * from ogrenciler where sinav_notu in(65,80);

--Soru 6: Notu 65 ile 85 arasında olan öğrencilerin tüm bilgilerini listeleyin
select * from ogrenciler where sinav_notu between 65 and 85;

--Soru 7: id si 2 ile 4 arasında olmayan öğrencilerin isim ve notunu listeleyiniz
select * from ogrenciler where id not between 2 and 4;
--not: not between aralıktaki uc degerler dahil degil

--Soru 8: notu 80 olan satırı siliniz
delete from ogrenciler where sinav_notu=80;

--Soru 9: Adresi Adana olan satırı siliniz
delete from ogrenciler where adres='Adana';

--Soru 10: ismi Burcu Öztürk veya Fatih Demir olanları sil
delete from ogrenciler where isim='Burcu Öztürk' or isim='Fatih Demir'

--Soru 11: notu 80 den küçük olanları siliniz
delete from ogrenciler where sinav_notu<80;

--Soru 12: Tablolardaki tüm satırları siliniz
delete from ogrenciler;

drop table ogrenciler;



