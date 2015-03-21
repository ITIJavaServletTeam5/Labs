package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.io.Serializable;

/**
 * User generated by hbm2java
 */
public class User  implements Serializable {


     private int id;
     private String email;
     private String password;
     private String username;
     private Boolean activated;
    private String role;



    public User() {
    }

	
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
   
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Boolean getActivated() {
        return this.activated;
    }
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
}


