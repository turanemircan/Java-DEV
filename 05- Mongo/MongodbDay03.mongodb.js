44//Fiyatı 200 den düşük olan bütün döcumentlere price değerini 50 arttıralım

use ("products");
db.electronics.updateMany(
    {"price":{$lt:200}},
    {$inc:{"price":50}}
)

use ("products");
db.electronics.find();

45//bir documentı silmek istersek
//name i en ucuz olan ilk documentı sil

use ("products");
db.electronics.deleteOne({"name":"en ucuz"});

46//birden fazla document silmek istersek
//"name":"Woww" olan tüm documentlerı silelim

use ("products");
db.electronics.deleteMany({"name":"Woww"})

47//tüm documentları silelim

//1.yol
use ("products");
db.electronics.deleteMany({});

//2.yol
use ("products");
db.electronics.remove({}); //deprecated

//3.yol
use ("products");
db.electronics.delete(); //romoved


48//yeni bir document ekleyelim

use ("products");
db.electronics.insertOne({"name":"laptop",
                          "brand":{"name":"Lenovo","model":"ThinkPadX1"},
                          "city":["Ankara","Bursa"],
                          "active":true});

use ("products");
db.electronics.find({"brand.model":"ThinkPadX1"})

use ("products");
db.electronics.find({"city":"Bursa"})


//=================================================
//                   AGGREGATION
//=================================================
// 1) Aggregation, dokumanlardaki verilerin islenmesi ve hesaplanan 
//    sonuclarin donmesini saglayan islemlerdir. 
//
// 2) Aggregation islemleri, farklı dokumanlardaki degerleri gruplandirabilir.
//
// 3) Bu gruplanan veriler uzerinde cesitli islemlerin gereceklestirelerek tek 
//    bir sonuc degerinin donmesi saglanabilir.
//
// 4) MongoDB, 3 farklı yontem ile aggregation gerceklestirmeye izin verir.
//     A) aggregation pipeline (toplama boru hattı) --> best practice...
//     B) map-reduce function (map indirgeme)
//     C) single-purpose aggregation (tek-amaç toplama) 
//
// 5) Aggregiation, SQL'deki Join islemlerine benzetilebilir. 
//=================================================
//             AGGREGATION PIPELINE
//=================================================
// SYNTAX
// 
//   pipeline = [
//   { $match : { … }},
//   { $group : { … }},
//   { $sort : { … }},
//      ...
//   ]
//   db.collectionName.aggregate({pipeline}, {options})
//
//  $match() –> Verileri secerken filtrelemek icin
//  $group({_id : "$field"}) - >islenen verilerin gruplanmasi icin 
//  $sort() -> Sonuclarin siralanmasi icin

use('okul');
db.grades.insertMany([
{"_id":6305, "name": "A. MacDyver", "assignment":5, "points" :24},
{"_id":6308, "name": "B. Batlock", "assignment":3, "points" :22},
{"_id":6312, "name": "M. Tagnum", "assignment":5, "points" :30},
{"_id":6319, "name": "R. Stiles", "assignment":2, "points" :12},
{"_id":6322, "name": "A. MacDyver", "assignment":2, "points" :14},
{"_id":6334, "name": "R. Stiles", "assignment":1, "points" :10},
{"_id":6345, "name": "A. Stiles", "assignment":1, "points" :10}
]);

1//her bir assignment için toplam puanları listeleyelim

use('okul');
var pipeline=[
//taskin aşamaları filtreleme yok, gruplama var
{$group:{"_id":"$assignment","total_points":{$sum:"$points"}}} //"$points" demek points deki value yu yani değeri al demek 
];
db.grades.aggregate(pipeline);

2//her bir assignmentın ortalama puanlarını hesaplayın
//artan olarak sıralayın

use('okul');
var pipeline=[
//taskin aşamaları filtreleme yok, gruplama var
{$group:{"_id":"$assignment","avg_points":{$avg:"$points"}}}, //"$points" demek points deki value yu yani değeri al demek 
{$sort:{avg_points:1}}
];
db.grades.aggregate(pipeline);


3//her bir assignmentın min puanlarını hesaplayalım
//azalan şekilde listeleyelim

use('okul');
var pipeline=[
    {$group:{_id:"$assignment",min_points:{$min:"$points"}}},
    {$sort:{min_points:-1}}
]
db.grades.aggregate(pipeline);

//birden fazla şart olduğunda
//price ı 400 den küçük olan
//en büyük 2. elemanın name ini 
//en ucuz yapın
var pipeline=[
    {$match:{"price":{$lt:400}}},
    {$sort:{"price":-1}},
    {$skip:1},
    {$limit:1},
    {$set:{"name":"en ucuz"}}
]


4//assignment değeri 4 ten küçük olan
//her bir assignmentın max puanlarını hesaplayalım
//azalan şekilde listeleyelim

use('okul');
var pipeline=[
{$match:{"assignment":{$lt:4}}},
{$group:{"_id":"$assignment","max_puan":{$max:"$points"}}},
{$sort:{"max_puan":-1}}
]
db.grades.aggregate(pipeline);


5//ismi A ile başlayan document lerin toplam puanlarını
//hesaplayıp listeleyelim

use('okul');
var pipeline=[

    {$match:{"name":{$regex:"^A",$options:"i"}}}, //$options:"i" büyük küçük harf duyarsız hale getiriyor
    {$group:{"_id":"", "total_points":{$sum:"$points"}}}  //gruplama yok ise "" veya null kullanılı
]

db.grades.aggregate(pipeline);

6//ismi s ile biten documentların toplam puanlarını
//hesaplayıp listeleyelim
use('okul');
var pipeline=[

    {$match:{"name":{$regex:"s$"}}},
    {$group:{"_id":"", "total_points":{$sum:"$points"}}}  //gruplama yok ise "" veya null kullanılı
]

db.grades.aggregate(pipeline);

use('okul');
db.grades.find();

7//points değeri 19 dan düşük olan documentsların sayısını bulalım
1.yol

use('okul');
db.grades.find({"points":{$lt:19}}).count();

//2.yol
use('okul');
db.grades.count({"points":{$lt:19}});

//3.yol
use ("okul");
var pipeline=[
    {$match:{"points":{$lt:19}}},
    {$count:"düşük puanlar"}
];
db.grades.aggregate(pipeline);