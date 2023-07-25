package serialization;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;

    private String name;

    private String tc_no;

    //param const

    public User(Long id, String name, String tc_no) {
        this.id = id;
        this.name = name;
        this.tc_no = tc_no;
    }

    //getter-setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }
    //toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tc_no='" + tc_no + '\'' +
                '}';
    }
}
