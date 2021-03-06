package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Group generated by hbm2java
 */
public class MyGroup implements java.io.Serializable {


     private Long id;
     private String name;
     private String description;
     private Boolean activated;
     private Set<Trainee> trainees = new LinkedHashSet(0);
     private Set<Course> courses = new LinkedHashSet(0);

    public MyGroup() {
    }

    public MyGroup(String name, String description, Boolean activated, Set trainees, Set courses) {
       this.name = name;
       this.description = description;
       this.activated = activated;
       this.trainees = trainees;
       this.courses = courses;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
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


    public boolean addTrainee(Trainee trainee) {
        return this.trainees.add(trainee);
    }
    public boolean removeTrainee(Trainee trainee) {
        return this.trainees.remove(trainee);
    }

    public boolean addCourse(Course course) {
        return this.courses.add(course);
    }
    public boolean removeCourse(Course course) {
        return this.courses.remove(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyGroup)) return false;

        MyGroup myGroup = (MyGroup) o;

        if (id != myGroup.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}


