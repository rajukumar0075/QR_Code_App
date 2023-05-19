package in.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.code.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
