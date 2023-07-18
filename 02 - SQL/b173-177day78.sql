--------------DAY'8---------------------
--LIKE:%,_
--ILIKE

--REGEXP_LIKE:~/~*
-- ^,$,[],[-]

-- .* =>0 veya daha fazla karakter
--  . =>sadece bir karakter 

SELECT * FROM words;
--y ile başlayıp f ile biten kelimelerin tum bilgilerini yazdiran QUERY yazin

SELECT * 
FROM words
WHERE word ~* '^y.*f$'


SELECT * 
FROM words
WHERE word ~* '^y(.*)f$'

--y ile başlayıp f ile biten 3 harfli kelimelerin tum bilgilerini yazdiran QUERY yazin

SELECT * 
FROM words
WHERE word ~* '^y.f$'

--NOT LIKE:verilen karakter desenine benzemeyenleri filtreler
-- !~     :verilen karakter desenine benzemeyenleri filtreler


-- ilk harfi h veya H olmayan kelimelerin tum bilgilerini yazdiran QUERY yaziniz.

SELECT * 
FROM words
WHERE word NOT ILIKE 'h%'

SELECT * 
FROM words
WHERE word !~* '^h'

--2. harfi e,i veya o olmayan kelimelerin tum bilgilerini yazdiran QUERY yazin.ÖDEV


--39-String Fonk.

SELECT * FROM developers;

--developers tablosundaki kayıtların name değerlerinin başına Developer kelimesini ekleyerek güncelleyiniz.

UPDATE developers
SET name=CONCAT('Developer ',name );

--developers tablosundaki tüm kayıtların name değerlerini büyük harfe çevirerek görüntüleyiniz.

SELECT UPPER(name) FROM developers;

--developers tablosundaki kayıtların prog_lang değerlerinin küçük harfe çevirerek güncelleyiniz.

UPDATE developers
SET prog_lang=LOWER(prog_lang);

--words tablosunda tüm kelimeleri(word) ilk harfini büyük diğerleri küçük harfe çevirerek görüntüleyiniz.

SELECT INITCAP(word) FROM words;


--developers tablosunda isim ve isimlerin ilk 3 harfini listeleyiniz.

SELECT name,SUBSTRING(name,1,3)
FROM developers;

--developers tablosunda isim ve isimlerin uzunluğunu listeleyiniz.

SELECT name,LENGTH(name)
FROM developers;

--40-FETCH NEXT n ROW ONLY:sadece ilk n satırı gösterir 
--   LIMIT n:sadece ilk n satırı gösterir 
--   OFFSET n:n tane satırı atlayıp sonrakileri getirir

--developers tablosundan ekleme sırasına göre ilk 3 kaydı getiriniz.

SELECT *
FROM developers
FETCH NEXT 3 ROW ONLY;

SELECT *
FROM developers
LIMIT 3;

--developers tablosundan ekleme sırasına göre ilk 2 kayıttan sonraki ilk 3 kaydı getiriniz.

SELECT *
FROM developers
OFFSET 2 ROW--row olmasa da olur
FETCH NEXT 3 ROW ONLY;

--developers tablosundan maaşı en düşük ilk 3 kaydı getiriniz.

SELECT *
FROM developers
ORDER BY salary ASC
LIMIT 3;

--developers tablosundan maaşı en yüksek 2. developerın tüm bilgilerini getiriniz.

SELECT *
FROM developers
ORDER BY salary DESC
OFFSET 1
LIMIT 1;

--41-ALTER TABLE:tabloyu güncellemek için kullanılır.DDL
/*
add column ==> yeni sutun ekler
drop column ==> mevcut olan sutunu siler
rename column.. to.. ==> sutunun ismini degistirir      
rename.. to.. ==> tablonun ismini degistirir*/

--SYNTAX:ALTER TABLE tablo_adı ADD COLUMN sütunadı datatipi

SELECT * FROM calisanlar3;

--calisanlar3 tablosuna yas (int) seklinde yeni sutun ekleyiniz.

ALTER TABLE calisanlar3
ADD COLUMN yas int;


--calisanlar3 tablosuna remote (boolean) seklinde yeni sutun ekleyiniz.
--varsayılan olarak remote değeri TRUE olsun

ALTER TABLE calisanlar3
ADD COLUMN remote boolean DEFAULT TRUE;

--calisanlar3 tablosuna prog_dili (varchar) seklinde yeni sutun ekleyiniz
-- default degeri 'java' olsun 

ALTER TABLE calisanlar3
ADD COLUMN prog_dili VARCHAR(20) DEFAULT 'java';

--calisanlar3 tablosunda yas sutununu siliniz.

ALTER TABLE calisanlar3
DROP COLUMN yas;

--calisanlar3 tablosundaki maas sutununun data tipini real olarak güncelleyiniz.

ALTER TABLE calisanlar3
ALTER COLUMN maas TYPE real;

--calisanlar3 tablosundaki maas sutununun data tipini int olarak güncelleyiniz.

ALTER TABLE calisanlar3
ALTER COLUMN maas TYPE int;

--calisanlar3 tablosundaki maas sutununun ismini gelir olarak güncelleyiniz.

ALTER TABLE calisanlar3
RENAME COLUMN maas TO gelir;

--calisanlar3 tablosunun ismini employees olarak güncelleyiniz.

ALTER TABLE calisanlar3 RENAME TO employees; 

--employees tablosunda id sütunun data tipini varchar olarak güncelleyiniz.
ALTER TABLE employees
ALTER COLUMN id TYPE VARCHAR(20)

--employees tablosunda id sütunun data tipini int olarak güncelleyiniz.
ALTER TABLE employees
ALTER COLUMN id TYPE int USING id::integer

--employees tablosunda isim sütununa NOT NULL constrainti ekleyiniz.
ALTER TABLE employees
ALTER COLUMN isim SET NOT NULL;


INSERT INTO employees(sehir) VALUES ('Ankara');

--NOT:içinde kayıtlar bulunan bir tabloyu güncellerken bir sütuna 
--NOT NULL,PK,FK,UNIQUE vs constraintleri ekleyebilmek için önce
--bu sütunların değerleri ilgili const.  sağlıyor olmalı.

--employees tablosunda id sütununa PRIMARY KEY constrainti ekleyiniz.
UPDATE employees
SET id=1
WHERE isim='Veli Yilmaz' AND sehir='Izmir'

ALTER TABLE employees
ADD PRIMARY KEY(id);

/*ALTER TABLE employees
ADD UNIQUE(isim);

ALTER TABLE employees
ADD FOREIGN KEY(id) REFERENCES diğertablonun(PKsütunu) ;
*/

SELECT * FROM employees;


--42-TRANSACTION:databasede en küçük işlem birimi
--   BEGIN:transactionı başlatır.
--   COMMIT:transactionı onaylar, transactionı sonlandırır.
--   ROLLBACK:değişiklikleri mevcut duruma döndürür,transactionı sonlandırır.  


CREATE TABLE hesaplar
(
hesap_no int UNIQUE,
isim VARCHAR(50),
bakiye real       
);

INSERT INTO hesaplar VALUES(1234,'Harry Potter',5500.3);
INSERT INTO hesaplar VALUES(5678,'Jack Sparrow',8500.5);


SELECT * FROM hesaplar;

UPDATE hesaplar SET bakiye=bakiye-1000 WHERE hesap_no=1234;
--sistemde hata oluştu
UPDATE hesaplar SET bakiye=bakiye+1000 WHERE hesap_no=5678;--bu sorgu çalışamadı.
--veriler tutarsız


SELECT * FROM hesaplar;

------------------------------------------------------

BEGIN;
CREATE TABLE hesaplar
(
hesap_no int UNIQUE,
isim VARCHAR(50),
bakiye real       
);
--tablo oluşmadı.
COMMIT;
--tablo oluştu

BEGIN;
INSERT INTO hesaplar VALUES(1234,'Harry Potter',5500.3);
INSERT INTO hesaplar VALUES(5678,'Jack Sparrow',8500.5);

savepoint x;--hata oluşunca geri dönmek istediğimiz noktayı belirtiriz


UPDATE hesaplar SET bakiye=bakiye-1000 WHERE hesap_no=1234;
--sistemde hata oluştu
UPDATE hesaplar SET bakiye=bakiye+1000 WHERE hesap_no=5678;--bu sorgu çalışamadı.

--catch bloğunda rollback çalıştır.
ROLLBACK TO x;
---------------------------
--pozitif senaryo

UPDATE hesaplar SET bakiye=bakiye-1000 WHERE hesap_no=1234;

UPDATE hesaplar SET bakiye=bakiye+1000 WHERE hesap_no=5678;
--try bloğunda hata oluşmazsa commit çağrılacak
COMMIT;


SELECT * FROM hesaplar;

















