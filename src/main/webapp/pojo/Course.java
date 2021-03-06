package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Course generated by hbm2java
 */
public class Course  implements java.io.Serializable {


     private Long id;
     private MyGroup myGroup;
     private String name;
     private String description;
     private Boolean activated;
     private Set labs = new LinkedHashSet(0);

    public Course() {
    }

    public Course(MyGroup myGroup, String name, String description, Boolean activated, Set instructors, Set labs) {
       this.myGroup = myGroup;
       this.name = name;
       this.description = description;
       this.activated = activated;
       this.labs = labs;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public MyGroup getMyGroup() {
        return this.myGroup;
    }
    
    public void setMyGroup(MyGroup myGroup) {
        this.myGroup = myGroup;
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

    public Set getLabs() {
        return this.labs;
    }
    
    public void setLabs(Set labs) {
        this.labs = labs;
    }




}


