package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    void save(Student student);
    List<Student> getAll();
    Optional<Student> findById(Long id);//null pointer exception almamak için
                      //null yerine boş bir optional objesi döner
    void delete(Long id);

}
