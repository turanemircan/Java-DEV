import java.sql.*;

//4- DB ile iletisimde olan class (connection,statement, prepared statement)
public class StudentRepository {

    private Connection con;
    private Statement st;
    private PreparedStatement prst;


    //5-Connection icin method olustur
    private void getConnection(){
        try {
            this.con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //6- Statement icin method olustur
    private void getStatement(){
        try {
            this.st=con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //7-PreparedStatement icin method olustur
    private void getPreparedStatement(String sql){
        try {
            this.prst=con.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //8-tablo olusturma
    public void createTable(){
        getConnection();
        getStatement();

        try {
            st.execute("create table if not exists t_student(id serial,name varchar(50)," +
                    "lastname varchar(50),city varchar(50),age int)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    //12-tabloya veri ekleme
    public void save(Student student) {
        getConnection();
        String sql="insert into t_student(name,lastname,city,age) values (?,?,?,?)";
        getPreparedStatement(sql);

        try {
            prst.setString(1, student.getName());
            prst.setString(2,student.getLastname());
            prst.setString(3,student.getCity());
            prst.setInt(4,student.getAge());
            prst.executeUpdate();
            System.out.println("Kayıt işlemi başarı ile gerçekleşmiştir...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    //14-Tüm kayıtları listeleme
    public void findAll() {
        getConnection();
        getStatement();
        String sql="select * from t_student";


        try {
            ResultSet resultset=st.executeQuery(sql);
            System.out.println("+"+"-".repeat(80)+"+");
            System.out.printf("| %-5s | %-20s | %-20s |%-20s | %-5s\n","id","ad","soyad","şehir","yaş");
            while(resultset.next()){
                System.out.printf("| %-5d | %-20s | %-20s |%-20s | %-5d\n",
                        resultset.getInt("id"),
                        resultset.getString("name"),
                        resultset.getString("lastname"),
                        resultset.getString("city"),
                        resultset.getInt("age")
                        );
            }
            System.out.println("+"+"-".repeat(80)+"+");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }


    //16-tablodan veri silme
    public void delete(int id) {
        getConnection();
        String sql="delete from t_student where id=?";
        getPreparedStatement(sql);

        try {
            prst.setInt(1,id);
            int deleted=prst.executeUpdate();
            if(deleted>0){
                System.out.println("id : "+id+" olan kayıt silinmiştir...");
            } else{
                System.out.println("id : "+id+" şeklinde bir kayıt bulunamadı");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
