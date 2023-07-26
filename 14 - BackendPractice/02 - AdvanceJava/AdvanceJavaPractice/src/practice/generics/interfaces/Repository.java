package practice.generics.interfaces;

//CRUD methodlari tanimlanacak
public interface Repository <T>{

    void add(T t);
    void get(T t);
    void update(T t);
    void delete(T t);
}
