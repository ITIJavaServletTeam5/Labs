package pojo;
// Generated Mar 18, 2015 12:18:02 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Group generated by hbm2java
 */
public class Group  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String description;
     private Boolean activated;
     private Set trainees = new HashSet(0);
     private Set courses = new HashSet(0);

    public Group() {
    }

    public Group(String name, String description, Boolean activated, Set trainees, Set courses) {
       this.name = name;
       this.description = description;
       this.activated = activated;
       this.trainees = trainees;
       this.courses = courses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getActivated() {
        return this.activated;
    }
    
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
    public Set getTrainees() {
        return this.trainees;
    }
    
    public void setTrainees(Set trainees) {
        this.trainees = trainees;
    }
    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }




}

