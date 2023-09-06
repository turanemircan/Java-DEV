--Advance SQL
--tek satırlı yorum yapma
/*
Çok satırlı yorum yapma
*/

--*****************************************************
--*******Değişken TANIMLAMA****************************
--*****************************************************

do $$  --do anonim kod bloğu
	   --dolar karekterlerin önüne ekstra tırnak kullanmamak için

declare
	counter integer :=1; --sadece = de yazılabilir
	first_name varchar(50) :='Ahmet';
	last_name varchar(50) :='Gok';
	payment numeric(4,2) :=20.5; --numeric(precision,scale) 1.si toplam kaç sayı olacak,2.si de virgülden sonra kaç sayı olacak

begin
	raise notice '% % % has been paid % USD', --raise notice ekrana yazdır komutu
		counter,
		first_name,
		last_name,
		payment;
end $$;

--Task 1:degiskenler olusturarak ekrana Ahmet ve Mehmet beyler 120 TL ye 
--bilet aldilar. cumlesini ekrana basiniz
do $$
declare
	first_person varchar(50):='Ahmet';
	second_person varchar(50):='Mehmet';
	payment numeric(3):=120;
begin
	raise notice '% ve % beyler % TL ye bilet aldılar',
		first_person,
		second_person,
		payment;
		
end $$;

--*****************************************
-- ********  BEKLETME KOMUDU **************
--*****************************************

do $$
declare
	create_at time:=now();
begin
	raise notice '%', create_at;
	perform pg_sleep(5);
	raise notice '%', create_at;
end $$;

--*************************************************	
--********* TABLODAN DATA TİPİNİ KOPYALAMA ********
--*************************************************

do $$
declare
	film_title film.title%type; --film tablosundaki title sütunundaki type i alır yani text olur
begin
	select title
	from film
	into film_title
	where id=1; --film tablosundan 1 id li filmin ismini film_title dğişkenine atar
	
	raise notice 'Film title with id=1 : %',film_title;
end $$;

--Task :1 id li filmin turunu yazdirin

do $$
declare
	film_type film.type%type;
begin
	select type
	from film
	into film_type
	where id=1;
	
	raise notice 'Film type with id =1 %',film_type;
end $$;

--************************************************
--***************** ROW TYPE *********************
--************************************************
do $$
declare
 selected_actor actor%rowtype; 
begin
	select *
	from actor
	into selected_actor
	where id=1;
	
	raise notice 'The actor name is % %',
		selected_actor.first_name,
		selected_actor.last_name;

end $$;


--******************************************
-- ******* Record Type *********************
--******************************************
--rowtype bütün satırdaki bilgileri hafıızsaına alır, burdan istediklerinizi kullanabilirsiniz
--record bir satırdaki bazı fieldlar için kullanılır. 2si arasında memory farkı vardır
do $$
declare
	rec record;
begin
	select id,title,type
	from film
	into rec
	where id=2;
	
	raise notice '% - % - % ',
		rec.id,
		rec.title,
		rec.type;

end $$;

--iç içe blok yapıları
do $$
<<outer_block>>
declare
	counter integer :=0;
begin
	counter :=counter+1;
	raise notice ' counter değeri : %',counter;
	
	<<inner_block>>
	declare --inner block başlangıcı
		counter integer :=0;
	begin
		counter=counter+10;
		raise notice 'iç blocktaki counter değerim : %',counter;
		raise notice 'dış blocktaki counter değerim : % ',outer_block.counter;
		
	end; --inner block sonu	
	
	
	
	raise notice 'dış bloktaki counter değerim : %',counter;

end $$;

--*************************************
-- ********** Constant ****************
--*************************************

do $$
declare
	rate constant numeric:=0.1;
	net_price numeric:=20.5;
begin
	raise notice 'Satış fiyatı : %',
		net_price*(1+rate);
		--rate:=0.05;
end $$;

-- //////////////////// Control Structures ///////////////////////

--***************************************************
-- ******************** If Statement ****************
--***************************************************
/*
syntax
if condition then
		statement;
end if;
*/
-- Task : 0 id li filmi bulalim eger yoksa ekrana uyari yazisi verelim
do $$
declare
	selected_film film%rowtype;
	input_film_id film.id%type:=0;
begin
	select *
	from film
	into selected_film
	where id=input_film_id;
	
	if not found then
		raise notice 'Girdiğiniz id li film bulunamadı : %',input_film_id;
	end if;

end $$;
--*********************************************
-- ************** IF-THEN-ELSE ****************
--*********************************************
/*
syntax:
if condition then 
	statement;
else
	altenative-statement;
end if;

*/

--Task : 2 id li filmi bulalim, eger yoksa ekrana uyari yazalim, varsa da ismini ekrana yazalim
do $$
declare
	selected_film record;
	input_film_id film.id%type:=2;
begin
	select title from film
	into selected_film
	where id=input_film_id;
	
	if not found then
		raise notice ' Girmiş olduğunuz id li film bulunamadı : %', input_film_id;
	else
		raise notice 'Filmin ismi : %', selected_film.title;
	end if;

end $$;

--Task : Eger film tablosu bos degilse (count methodu ile) film tablosuna id, title
--degerlerini ayarlayarak yeni veri girisi yapan kodu yazalim (5,Yeşil Yol)

do $$
declare
	count_rows integer ;
begin
	select count(*)
	from film
	into count_rows;
	
	if count_rows > 0 then
	insert into film (id,title)
	values (5,'Yeşil Yol');
	raise notice 'Yeni film eklendi.';
	else raise notice 'Film tablosu boş';
	end if;
end $$;
--*******************************************************
-- ************* IF-THEN-ELSE-IF ************************
--*******************************************************

--syntax:
if conditon_1 then
	statemnet_1;
	elsif condition_2 then
		statement_2 then
	elseif condition_3 then
		statement_3;....
	else 
		else_statemnet;
end if;

--Task : 1 id li film varsa ; 
			suresi 50 dakikanin altinda ise Kısa, 
			50<length<120 ise Orta, 
			length>=120 ise Uzun yazalim
			
do $$
declare
	v_film film%rowtype;
	len_description varchar(50);
begin
	select * from film
	into v_film
	where id=1;
	
	if not found then
	raise notice 'Film bulunamadı';
	else
		if v_film.length > 0 and v_film.length<50 then
			len_description='Kısa';
		elsif v_film.length>50 and v_film.length<120 then
			len_description='Orta';
		elseif v_film.length>=120 then
			len_description='Uzun';
		else
			len_description='Tanımlanamıyor';
		end if;
	raise notice '% filmin süresi : %', v_film.title,len_description;
	end if;

end $$;
--***************************************************
-- ******** Case Statement **************************
--***************************************************
--syntax:
case search-expression 
	when expression then
	statement
	[....
	else
		else-statement]
		
end case;
-- Task : Filmin turune gore cocuklara uygun olup olmadigini ekrana yazalim

do $$
declare
	tur film.type%type;
	uyari varchar(50);
begin
	select type
	from film
	into tur
	where id=1;
	
	if found then
	case tur
		when 'Korku' then
			uyari='Çocuklar için uygun değil.';
		when 'Macera' then
			uyari='Ebeveyn tercihinde izleyebilir';
		when 'Animasyon' then
			uyari='Tavsiye edilir';
		else 
			uyari='Tanımlanmayan tür.';
		end case;
		raise notice '% türü %',tur,uyari;
	end if;
end $$;
--******************************************
--************** LOOP **********************
--******************************************
--syntax--1.örnek
<<label>>
loop
	statement;
end loop;

--loop u sonlandırmak için if yapısını kullanabiliriz
<<label>>--2.örnek
loop
	statement;
	if condition then
		exit;
	end if;
end loop;

--nested loop örneği-3.örnek
<<outer>>
loop
	statement;
	<<inner>>
	loop
	/*...*/
	exit;--inner loop tan çıkış
	end loop;
	exit;--outer loop tan çık
	end loopİ outer loop u bitir

--Task :loop kullanarak ekrana counter 1 den 4 e kadar yazdırın
do $$
declare
	counter integer :=0;
begin
	loop
	exit when counter=4;
	counter=counter+1;
	raise notice 'counter %',counter;
	end loop;

end $$;

-- Task : Fibonacci serisinde, belli bir siradaki sayiyi ekrana getirelim
--Fibonacci sayıları 1, 1, 2, 3, 5, 8, 12, 21, 34, 55...
do $$
declare
	n integer:=10;
	counter integer:=0;
	i integer:=0;
	j integer:=1;
	fib integer:=0;
	
begin
	if n<1 then
		fib:=0;
	end if;
	loop 
	exit when counter=n;
	counter=counter+1;
	select j,i+j into i,j;  -- seçim(0,1)->(1,1)/2.işlem de seçim(1,1)->(1,2)/3.işlem(1,2)->(2,3)
	end loop;
	fib:=i;
	raise notice '%',fib;
		
end $$;

--Task  : Film tablosundaki film sayisi 10 dan az ise "Film sayisi az" yazdirin, 
--10 dan cok ise "Film sayisi yeterli" yazdiralim
do $$
declare
	sayi integer:=0;
begin
	select count(*)
	from film
	into sayi;
	
	if sayi<10 then
		raise notice 'Film sayısı az';
		else
		raise notice 'Film sayısı yeterli';
	end if;
end $$;

--Ödev
-- Task : user_age isminde integer data turunde bir degisken tanimlayip default olarak bir deger verelim, 
--If yapisi ile girilen deger 18 den buyuk ise Access Granted, kucuk ise Access Denied yazdiralim 

-- Task : a ve b isimli integer turunde 2 degisken tanimlayip default degerlerini verelim, 
--eger a nin degeri b den buyukse "a , b den buyuktur" yazalim, tam tersi durum icin "b, a dan buyuktur" yazalim, 
--iki deger birbirine esit ise " a,  b'ye esittir" yazalim: 

-- Task : kullaniciYasi isimli bir degisken olusturup default degerini verin, girilen yas 18 den buyukse "Oy kullanabilirsiniz", 
--18 den kucuk ise "Oy kullanamazsiniz" yazisini yazalim.

--**************************************************
-- ************ WHILE LOOP *************************
--**************************************************
--syntax
while condition loop
	statement;
end loop;
-- Task : 1 dan 4 e kadar counter degerlerini ekrana basalim

do $$
declare
	n integer:=4;
	counter integer:=0;
begin
	while counter<n loop
		counter=counter+1;
	raise notice '%',counter;
	end loop;

end $$;
--***********************************************
-- **************  FOR LOOP *********************
--***********************************************
--syntax
FOR loop_counter IN [REVERSE] FROM..TO [ by step] LOOP
	statement;
	END LOOP;

--Örnek 1 in kullnımı
do $$

begin
	for counter in 1..5 loop 
		raise notice 'counter : %',counter;
	end loop;
end $$;
--Not:değişken kullanılmayacakse declare yazılmasına gerek yok

--Örnek 2 reverse kullanımı
do $$
begin
	for counter in reverse 5..1 loop
		raise notice 'counter : %',counter;
	end loop;
	
end $$

--3.Örnek by kullanımı
do $$

begin
	for counter in 1..10 by 2 loop
		raise notice 'counter : %',counter;
	end loop;
end $$;

-- Task : 10 dan 20 ye kadar 2 ser 2 ser ekrana sayilari basalim : 

do $$
begin
	for counter in 10..20 by 2 loop
		raise notice 'conter : %',counter;
	end loop;
end $$;

--dizilerin elemanları içinde gezinme
do $$
declare
	array_int int[]=array[11,22,33,44,55,66,77,88];
	var int[];
begin
	for var in select array_int loop
	raise notice '%',var;
	end loop;

end $$;


--db de loop örneği
--syntax
FOR target IN query loop
	statement;
end loop;
-- Task : Filmleri suresine gore siraladigimizda en uzun 2 filmi gosterelim
do $$
declare
 f record;

begin
	for f in select title,length
	from film
	order by length desc
	limit 2
	
	loop
		raise notice '% (% dakika )',f.title,f.length;
	end loop;
end $$;

CREATE TABLE employees (
  employee_id serial PRIMARY KEY,
  full_name VARCHAR NOT NULL,
  manager_id INT
);

INSERT INTO employees (
  employee_id,
  full_name,
  manager_id
)
VALUES
  (1, 'M.S Dhoni', NULL),
  (2, 'Sachin Tendulkar', 1),
  (3, 'R. Sharma', 1),
  (4, 'S. Raina', 1),
  (5, 'B. Kumar', 1),
  (6, 'Y. Singh', 2),
  (7, 'Virender Sehwag ', 2),
  (8, 'Ajinkya Rahane', 2),
  (9, 'Shikhar Dhawan', 2),
  (10, 'Mohammed Shami', 3),
  (11, 'Shreyas Iyer', 3),
  (12, 'Mayank Agarwal', 3),
  (13, 'K. L. Rahul', 3),
  (14, 'Hardik Pandya', 4),
  (15, 'Dinesh Karthik', 4),
  (16, 'Jasprit Bumrah', 7),
  (17, 'Kuldeep Yadav', 7),
  (18, 'Yuzvendra Chahal', 8),
  (19, 'Rishabh Pant', 8),
  (20, 'Sanju Samson', 8);
  
    -- Task :  manager ID si en buyuk ilk 10 kisiyi ekrana yazalim 

do $$
declare
	f record;

begin
	for f in select full_name,manager_id
	from employees
	order by manager_id desc
	limit 10
	
	loop
	raise notice '% - %',f.manager_id,f.full_name;
	end loop;

end $$;

--*****************************************
-- ************ CONTINUE ******************
--*****************************************

--syntax
continue when condition ...
-- Task : continue yapisi kullanarak 1 dahil 10 a kadar olan tek sayilari ekrana basalim
do $$
declare
	counter integer:=0;

begin
	loop
		counter=counter+1;--loop içinde counter değeri 1 artar
		exit when counter>10;--counter 10 olunca lop tan çıkar
		continue when mod(counter,2)=0; --counter sayısının 2 ile bölümünden kalan o ise atlar
		raise notice '%',counter;
	end loop;
end $$;




