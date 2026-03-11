package MITS.Student_Portal_Backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Student_Repo extends JpaRepository<Student, Long>{

	Student findByEmail(String email);
}
