package com.tpe.hb14.entity_life_cycle;


import javax.persistence.*;
/*
Hinernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :

	Entity State :

		1) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok.
		 Bu durumda, nesne henüz bir Hibernate session'ına kaydedilmemiştir ve veritabanında bir karşılığı
		yoktur. Geçici durumdaki bir nesne, session'ın kapatılmasıyla birlikte kaybolur.

		2) Persisted or Managed : DB de row a karşılık geldiği durum, save(),get() vs. yapıldığı
		zamana denk geliyor. Bu durumda, nesne bir Hibernate session'ına kaydedilmiştir ve
		veritabanında bir karşılığı vardır. Kalıcı durumdaki bir nesne, session kapatılsa
		bile veritabanında kalır ve daha sonra yeniden kullanılabilir.

		3) Detached :  Bu durumda, nesne bir Hibernate session'ından ayrılmıştır. Artık bu
		session tarafından yönetilmiyor, ancak veritabanında hala bir karşılığı var. Ayrılmış
		durumdaki bir nesne, başka bir session'a bağlanarak kullanılabilir.

		4) Removed : obje remove yapıldığı zamanki durum.
*/

@Entity
public class Student14 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer grade;

    //getter-setter


    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student14{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @PrePersist
    public void print(){
        System.out.println("+++++Obje kaydediliyor");
    }

    @PostPersist
    public void postPersist(){
        System.out.println("-----Obje kaydedildi");
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println("-----Obje güncelleniyor");
    }

    @PostUpdate
    public void postUpdate(){
        System.out.println("-----Obje güncellendi");
    }

    @PostLoad
    public void postLoad(){
        System.out.println("-----Obje yüklendi");
    }

    @PreRemove
    public void preDelete(){
        System.out.println("-----Obje silinecek");
    }

    @PostRemove
    public void postDelete(){
        System.out.println("-----Obje silindi:(");
    }




}
