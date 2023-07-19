create table arac ( 
id int,
marka varchar (30),
model varchar(30), 
fiyat int,
kilometre int, 
vites varchar(20)
)

insert into arac values (100, 'Citroen', 'C3', 500000, 5000, 'Otomatik' );
insert into arac values (101, 'Mercedes', 'C180', 900000, 10000, 'Otomatik' );
insert into arac values (102, 'Honda', 'Civic', 400000, 15000, 'Manuel' );
insert into arac values (103, 'Wolkswagen', 'Golf', 350000, 20000, 'Manuel' );  
insert into arac values (104, 'Ford', 'Mustang', 750000, 5000, 'Otomatik' );
insert into arac values (105, 'Porsche', 'Panamera', 850000, 5000, 'Otomatik' );
insert into arac values (106, 'Bugatti', 'Veyron', 950008, 5000, 'Otomatik' );

/*
AGGRAGATE FONKSİYON
avg,count, sum,min, max 
*/
--SORU1: arac tablosundaki en yüksek fiyat'ı listele
select max(fiyat) from arac;

--Soru 2:arac tablosundaki araçları toplam fiyatını bulunuz
select sum(fiyat) from arac;

--Soru 3:arac tablosundaki fiyat ortalamalarını bulunuz
select avg(fiyat) from arac;
select round(avg(fiyat)) from arac;
select round(avg(fiyat),2) from arac;

--Soru 4:arac tablosunda kaç tane araç olduğunu bulunuz
select count(id) from arac;
select count(*) from arac;

CREATE TABLE meslekler
(
id int PRIMARY KEY, 
isim VARCHAR(50), 
soyisim VARCHAR(50), 
meslek CHAR(9), 
maas int
);

INSERT INTO meslekler VALUES (1, 'Ali', 'Can', 'Doktor', '20000' ); 
INSERT INTO meslekler VALUES (2, 'Veli', 'Cem', 'Mühendis', '18000'); 
INSERT INTO meslekler VALUES (3, 'Mine', 'Bulut', 'Avukat', '17008'); 
INSERT INTO meslekler VALUES (4, 'Mahmut', 'Bulut', 'Ögretmen', '15000'); 
INSERT INTO meslekler VALUES (5, 'Mine', 'Yasa', 'Teknisyen', '13008'); 
INSERT INTO meslekler VALUES (6, 'Veli', 'Yilmaz', 'Hemşire', '12000'); 
INSERT INTO meslekler VALUES (7, 'Ali', 'Can', 'Marangoz', '10000' ); 
INSERT INTO meslekler VALUES (8, 'Veli', 'Cem', 'Tekniker', '14000');

--Soru 1: meslekler tablosunu isime göre sıralayınız
select * from meslekler order by isim;

--Soru 2: meslekler tablosunda maaşı büyükten küçüğe doğru sıralayınız
select * from meslekler order by maas desc; 

--Soru 3: meslekler tablosunda ismi Ali olanları maaşı büyükten küçüğe doğru sıralayınız
select * from meslekler where isim='Ali' order by maas desc;

--Soru 4: meslekler tablosunda soyisimi Bulut olanları, maaşı sıralı olarak sorgulayınız
SELECT *
FROM meslekler
WHERE soyisim='Bulut'
ORDER BY maas;


--Soru 5: meslekler tablosunda id değeri 5 ten büyük olan ilk iki veriyi listeleyiniz
select * from meslekler where id>5 limit 2;

--Soru 6: meslekler tablosunda maaşı en yüksek 3 kişinin bilgilerini getiriniz
select * from meslekler order by maas desc limit 3

INSERT INTO meslekler VALUES (9, 'Veli', 'Cem', NULL, 0);
INSERT INTO meslekler VALUES (10, 'Görür', 'Görmez', NULL, 0);

-Soru 9: meslekler tablosunda mesleği null olanları getiriniz
select * from meslekler where meslek is null

--Soru 10: meslekler tablosundan mesleği null olmayanları getiriniz
SELECT * FROM meslekler WHERE meslek IS NOT NULL;
/*
Left join : Left join işlemi, ilk tablodaki tüm kayıtları ve ikinci tablodaki eşleşen kayıtları getirir.
Eğer ikinci tabloda eşleşen kayıt yoksa, sonuç olarak NULL değeri döndürür.
Right join : Right join işlemi, ilk tablodaki tüm kayıtları ve ikinci tablodaki eşleşen kayıtları getirir. 
Eğer ikinci tabloda eşleşen kayıt yoksa, sonuç olarak NULL değeri döndürür.
İnner join : Inner join işlemi, her iki tablodaki eşleşen kayıtları getirir ve eşleşmeyen kayıtları 
dışarıda bırakır.
Full Join : Full join işlemi, her iki tablodaki tüm kayıtları getirir ve eşleşen kayıtları birleştirir. 
Eğer bir tabloda eşleşen kayıt yoksa, o tablodaki diğer kayıtlar NULL değeri ile gösterilir.
Self Join : Aynı tablo içinde farklı satırları birleştirmek için kullanılan bir join işlemidir.
*/
create table filmler (
film_id int,
film_name varchar(30), 
category varchar(30) );

insert into filmler values (1, 'Eyvah Eyvah', 'Komedi');
insert into filmler values (2, 'Kurtlar Vadisi', 'Aksiyon');
insert into filmler values (3, 'Eltilerin Savasi', 'Komedi');
insert into filmler values (4, 'Aile Arasinda', 'Komedi');
insert into filmler values (5, 'GORA', 'Bilim Kurgu'); 
insert into filmler values (6, 'Organize Isler', 'Komedi');
insert into filmler values (7, 'Babam ve Oglum', 'Dram');

create table aktorler (
id int,
actor_name varchar(30),
film_id int
);
insert into aktorler values (1, 'Ata Demirer', 1); 
insert into aktorler values (2, 'Necati Sasmaz', 2);
insert into aktorler values (3, 'Gupse Ozay', 3);
insert into aktorler values (4, 'Engin Gunaydin', 4);
insert into aktorler values (5, 'Cem Yilmaz', 5);


select * from filmler;
--Soru1 Tüm film_namel leri, kategorilerini ve filmlerde oynayan 
--aktor_name leri listeleyin
select film_name,category,actor_name from
filmler as A left join aktorler as B
on A.film_id=B.film_id;

--right joinle aynı soru cozulmus olsa
select film_name,category,actor_name from
aktorler as A right join filmler  as B
on A.film_id=B.film_id;

--Soru 2: tüm actor_name leri ve film name leri listeleyiniz
select actor_name,film_name from
aktorler as A left join filmler as B
on A.film_id=B.film_id;

CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50)
);

INSERT INTO Customers (customer_id, name, email)
VALUES (1, 'Ali', 'ali@mail.com'),
       (2, 'Ayşe', 'ayse@mail.com'),
       (3, 'Fatih', 'fatih@mail.com');
	   
	   CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    product VARCHAR(50),
    price DECIMAL(8,2),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

INSERT INTO Orders (order_id, customer_id, product, price)
VALUES (101, 1, 'Laptop', 2500.00),
       (102, 1, 'Printer', 500.00),
       (103, 2, 'Tablet', 1200.00),
       (104, 3, 'Phone', 1500.00),
       (105, 3, 'Camera', 2000.00);
	  
select * from customers;

--Soru customer name o isme ait product ve price ı inner join kullanarak birleştiriniz
select name,product,price from
Customers as A inner join Orders as B
on A.customer_id=B.customer_id;

CREATE TABLE Employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    manager_id INT
);

INSERT INTO Employees (employee_id, name, department, manager_id)
VALUES (1, 'Ali', 'IT', 2),
       (2, 'Ayşe', 'IT', NULL),
       (3, 'Fatih', 'Marketing', 4),
       (4, 'Mehmet', 'Marketing', NULL),
       (5, 'Elif', 'DEV', 1);
select * from employees;

--Soru : inner join kullanarak emloyee_name ve manager_name leri gösteriniz
select A.name as employee_name, B.name as manager_name
from Employees as A inner join Employees as B
on A.manager_id=B.employee_id;

delete from orders;

INSERT INTO Orders (order_id, customer_id, product, price)
VALUES (101, 1, 'Laptop', 2500.00),
       (102, 1, 'Printer', 500.00),
       (103, 2, 'Tablet', 1200.00),
       (104, NULL, 'Phone', 1500.00),
       (105, NULL, 'Camera', 2000.00);

--Ödev Soru : customer name product ve price ların hepsini getiriniz(Full Join)
