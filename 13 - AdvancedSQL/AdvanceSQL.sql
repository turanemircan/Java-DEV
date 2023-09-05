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
	insert into film (title)
	values (5,'Yeşil Yol');
	raise notice 'Yeni film eklendi.';
	else raise notice 'Film tablosu boş';
	end if;
end $$;

