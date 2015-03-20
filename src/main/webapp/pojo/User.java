package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1



/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer id;
     private String email;
     private String password;
     private String username;
     private String role;
     private Boolean activated;
     private Trainee trainee;
     private Instructor instructor;

    public User() {
    }

	
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(String email, String password, String username, String role, Boolean activated, Trainee trainee, Instructor instructor) {
       this.email = email;
       this.password = password;
       this.username = username;
       this.role = role;
       this.activated = activated;
       this.trainee = trainee;
       this.instructor = instructor;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    public Boolean getActivated() {
        return this.activated;
    }
    
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
    public Trainee getTrainee() {
        return this.trainee;
    }
    
    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }
    public Instructor getInstructor() {
        return this.instructor;
    }
    
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }




}

