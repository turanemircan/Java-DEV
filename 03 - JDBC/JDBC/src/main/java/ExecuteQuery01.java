import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        //Database e baglanma
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");

        //Statement olusturma   //db ye iletim yapmak ve query calistirmasi icin olusturulur
        Statement st=con.createStatement();

        //ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.
        String query1="select country_name from countries where id between 5 and 10";
        boolean sql1=st.execute(query1);
        System.out.println("sql1 : "+sql1);

        //kayıtları gormek icın executeQuery() kullanmaliyiz
        ResultSet resultset=st.executeQuery(query1);
//        resultset.next();
//        System.out.println(resultset.getString("country_name"));
        //Resultset in first(),last(),next() gini methodları vardır
        //Resultset in geriye donusu yoktur
        while(resultset.next()){
            System.out.println("Ülke ismi : "+resultset.getString("country_name"));
        }

        System.out.println("-------------------Örnek 2---------------------------------");
        //ÖRNEK 2: phone_code'u 550 den büyük olan ülkelerin "phone_code" ve "country_name" bilgisini listeleyiniz
        String query2="SELECT phone_code,country_name from countries where phone_code>550";
        ResultSet rs2=st.executeQuery(query2);

        while(rs2.next()){
            System.out.println(rs2.getInt("phone_code")+"--"+rs2.getString("country_name"));

        }
        System.out.println("-------------------Örnek 3---------------------------------");
        //ÖRNEK 3:developers tablosunda "salary" değeri en düşük salary olan developerların tüm bilgilerini gösteriniz
        String query3="select * from developers where salary=(select min(salary) from developers)";
        ResultSet rs3=st.executeQuery(query3);
        while(rs3.next()) {
            System.out.println(rs3.getInt("id")+"--"+rs3.getString("name")+
                    "--"+rs3.getInt("salary")+"--"+rs3.getString("prog_lang"));
        }

        System.out.println("------------ÖRNEK 4-------------");
        //ÖRNEK 4:Puanı bölümlerin taban puanlarının ortalamasından yüksek olan öğrencilerin isim ve puanlarını listeleyiniz
        String query4="select isim,puan from ogrenciler where puan>(select avg(taban_puani) from bolumler)";
        ResultSet rs4= st.executeQuery(query4);

        while(rs4.next()){
            System.out.println(rs4.getString("isim")+"--"+rs4.getInt("puan"));
        }

    st.close();
    con.close();
    }

}
