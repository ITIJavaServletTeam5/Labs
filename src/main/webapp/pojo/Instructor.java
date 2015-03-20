package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Instructor generated by hbm2java
 */
public class Instructor  implements java.io.Serializable {


     private int id;
     private User user;
     private Set courses = new HashSet(0);
     private Set labs = new HashSet(0);

    public Instructor() {
    }

	
    public Instructor(User user) {
        this.user = user;
    }
    public Instructor(User user, Set courses, Set labs) {
       this.user = user;
       this.courses = courses;
       this.labs = labs;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }
    public Set getLabs() {
        return this.labs;
    }
    
    public void setLabs(Set labs) {
        this.labs = labs;
    }




}


