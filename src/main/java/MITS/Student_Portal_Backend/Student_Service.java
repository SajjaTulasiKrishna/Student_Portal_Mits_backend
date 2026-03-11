package MITS.Student_Portal_Backend;

import java.util.List;	

import org.springframework.stereotype.Service;

@Service
public class Student_Service {

	
	private final Student_Repo sr;

    public Student_Service(Student_Repo repo) {
        this.sr = repo;
    }
//Insert
    public Student register(Student stu) {
        return sr.save(stu);
    }

    public Student login(String email, String password) {
        Student user = sr.findByEmail(email);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }
    
    //Retrieve
    public List<Student> getAllUsers(){
		return sr.findAll();
    	
    }
    
    
 // UPDATE
    public Student updateStudent(Long id, Student product) {
        Student existing = sr.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setEmail(product.getEmail());
            existing.setPassword(product.getPassword());
            
            return sr.save(existing);
        }
        return null;
    }
    
 // DELETE
    public void deleteStudent(Long id) {
        sr.deleteById(id);
    }
    
    
}
