/***MONGO DB-Practice**
**************
PRACTICE-2
**************

use("school");
db.students.find();
*/

//------------------------------------------------------------------------------
//1)"students" collectionında name i "Peyami Safa", olan bir kişinin bilgilerini 

"name":"Peyami Safa",
 "age":41,
 "city":"İstanbul",
 "grade":535,
 "department":{"name":"IT","language":"tr"},
 "books":[{"name":"Math","category":"lessson"},
          {"name":"Sefiller","category":"novel"}]

//ile  değiştiriniz.
//------------------------------------------------------------------------------


use("school");
db.students.findOneAndReplace({"name":"Peyami Safa"},{"name":"Peyami Safa",
"age":41,
"city":"İstanbul",
"grade":535,
"department":{"name":"IT","language":"tr"},
"books":[{"name":"Math","category":"lessson"},
         {"name":"Sefiller","category":"novel"}]});



//------------------------------------------------------------------------------
//2)"students" collectionında yaşı(age) 23 olan bir kişinin ismini "Elif Şafak"
//olarak güncelleyiniz, gradeni 50 artırınız, ve güncellenen documenti görüntüleyiniz.
//------------------------------------------------------------------------------

use("school");
db.students.findOneAndUpdate({"age":23},{$set:{name:"Elif Şafak"},$inc:{grade:50}},{returnNewDocument:true});



//------------------------------------------------------------------------------
//3)"students" collectionında ismi "Kemal Tahir"  olan varsa 
//age:36,city:"Konya",grade:411,department:"Chemistry"
// olarak güncelleyiniz yoksa document ekleyiniz ve görüntüleyiniz.
//------------------------------------------------------------------------------

use("school");
db.students.findOneAndUpdate({"name":"Kemal Tahir"},
                             {$set:{age:36,city:"Konya",grade:411,department:"Chemistry"}},
                             {returnNewDocument:true,upsert:true});


//------------------------------------------------------------------------------
//4)"students" collectionında İstanbulda yaşayanların citysini "Megakent"
//olarak güncelleyiniz.
//------------------------------------------------------------------------------

use("school");
db.students.updateMany({"city":"İstanbul"},
                       {$set:{city:"Megakent"}});



//------------------------------------------------------------------------------
//5)"students" collectionında department name i "Physics" olan bir kişiyi siliniz.
//------------------------------------------------------------------------------

use("school");
db.students.deleteOne({"department.name":"Physics"});



//------------------------------------------------------------------------------
//6)"students" collectionında yaşı 30 dan büyük ve 50 den küçük olanları siliniz.
//------------------------------------------------------------------------------


use("school");
db.students.find({$and:[{age:{$gt:30}},{age:{$lt:50}}]},{age:1}).count();

use("school");
db.students.deleteMany({$and:[{age:{$gt:30}},{age:{$lt:50}}]});


//------------------------------------------------------------------------------
//7)"students" collectionında tüm dökümanları siliniz.
//------------------------------------------------------------------------------

use("school");
db.students.deleteMany({});
//db.students.remove({})-->deprecated


//*******************************************************************
//===aggregation pipeline===//                                      *                        
// SYNTAX                                                           *        
//                                                                  *
// pipeline=[                                                       *            
// {$match:{...}},                                                  *
// {$group:{...}},                                                  *
// {$sort:{...}},                                                   *
//  ...                                                             *
//  ]                                                               *
//db.collectionName.aggregate(pipeline,options)                     *
//                                                                  *
// $match->verileri seçerken filtrelemek için                       *
// $group({_id:"$field"})-> islenen verilerin gruplanması için      *
// $sort->sonuçların sıralanması için                               *
//*******************************************************************

use ("school");
db.students.insertMany([]);

//------------------------------------------------------------------------------
//8)"students" collectionında her bir şehir için yaş ortalamalarını bulunuz.
//------------------------------------------------------------------------------

use ("school");
var pipeline=[
    {$group:{"_id":"$city","avg_age":{$avg:"$age"} }}
];

db.students.aggregate(pipeline);
//alternatif

use ("school");
db.students.aggregate({$group:{"_id":"$city","avg_age":{$avg:"$age"} }});

//------------------------------------------------------------------------------
//9)"students" collectionında her bir department name için max grade i bulunuz.
//------------------------------------------------------------------------------

use ("school");
var pipeline=[
    {$group:{"_id":"$department.name", "max_grade":{$max:"$grade"}}}
];
db.students.aggregate(pipeline);


//------------------------------------------------------------------------------
//10)"students" collectionında 40 yaşından büyüklerin her bir department name'i için
// min grade i bul.
//------------------------------------------------------------------------------

use ("school");
var pipeline=[
    {$match:{"age":{$gt:40}}},
    {$group:{"_id":"$department.name", "min_grade":{$min:"$grade"}}}
];
db.students.aggregate(pipeline);



//------------------------------------------------------------------------------
//11)"students" collectionında isminde "p veya s" olan ve 
//"y veya g" ile bitenlerin toplam puanını bulunuz.
//------------------------------------------------------------------------------

use ("school");
var pipeline=[
    {$match:{"name":{$regex:"[ps](.*)[gy]$"}}},
    {$group:{"_id":"", "total_grade":{$sum:"$grade"}}}
];
db.students.aggregate(pipeline);

//ÖDEVV
//------------------------------------------------------------------------------
//12)"students" collectionında "Ankara"da yaşayanların sayısını bulunuz.
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
//13)"students" collectionında yaşı 30 dan büyük olanların sayısını bulunuz.
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
//14)"students" collectionında yaşı 40 dan büyük olan 2. kişinin ismini
// "Jane Austen" olarak güncelleyiniz
//------------------------------------------------------------------------------


//------------------------------------------------------------------------------
//15)"students" collectionında isminde "p veya s" olan ve 
//"y veya g" ile bitenlerin isim ve yaşını görüntüleyiniz. 
//------------------------------------------------------------------------------