package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Trainee generated by hbm2java
 */
public class Trainee extends User implements java.io.Serializable {


//     private int id;
     private Set assistancequeues = new LinkedHashSet(0);
     private Set assignments = new LinkedHashSet(0);
     private Set deliveryqueues = new LinkedHashSet(0);
     private Set groups = new LinkedHashSet(0);

    public Trainee() {
    }

	
    public Trainee(User user, Set assistancequeues, Set assignments, Set deliveryqueues, Set groups) {
       this.assistancequeues = assistancequeues;
       this.assignments = assignments;
       this.deliveryqueues = deliveryqueues;
       this.groups = groups;
    }
   
//    public int getId() {
//        return this.id;
//    }
    
//    public void setId(int id) {
//        this.id = id;
//    }
    
    public Set getAssistancequeues() {
        return this.assistancequeues;
    }
    
    public void setAssistancequeues(Set assistancequeues) {
        this.assistancequeues = assistancequeues;
    }
    public Set getAssignments() {
        return this.assignments;
    }
    
    public void setAssignments(Set assignments) {
        this.assignments = assignments;
    }
    public Set getDeliveryqueues() {
        return this.deliveryqueues;
    }
    
    public void setDeliveryqueues(Set deliveryqueues) {
        this.deliveryqueues = deliveryqueues;
    }
    public Set getGroups() {
        return this.groups;
    }
    
    public void setGroups(Set groups) {
        this.groups = groups;
    }
}


