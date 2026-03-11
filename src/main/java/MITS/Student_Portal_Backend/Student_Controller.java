package MITS.Student_Portal_Backend;

import java.util.List;	

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Student_Controller {

	
	private final Student_Service ss;

    public Student_Controller(Student_Service service) {
        this.ss = service;
    }

    //insert 
    
    @PostMapping("/register")
    public String register(@RequestBody Student user) {
    	ss.register(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Student user) {
        return ss.login(user.getEmail(), user.getPassword()) != null ?
                "Login successful!" : "Invalid credentials!";
    }
            
    //Retrieve
    
    @GetMapping("/users")
    public List<Student> getUsers() {
        return ss.getAllUsers();
    }
	
	//update
    
    @PutMapping("update/{id}")
    public Student updateProduct(@PathVariable Long id,
                                 @RequestBody Student stu) {
        return ss.updateStudent(id, stu);
    }
    
    //delete
    
    @DeleteMapping("del/{id}")
    public String deletestudent(@PathVariable Long id) {
        ss.deleteStudent(id);
        return "Product deleted successfully";
    }   
    
}
