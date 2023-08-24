package com.tpe.repository;

import com.tpe.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // optional
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);

}
