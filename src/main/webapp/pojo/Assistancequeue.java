package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Assistancequeue generated by hbm2java
 */
public class Assistancequeue  implements java.io.Serializable, Comparable {


     private AssistancequeueId id;
     private Lab lab;
     private Trainee trainee;
     private Date requestDate;
     private Boolean activated;

    public Assistancequeue() {
    }


    public Assistancequeue(AssistancequeueId id, Lab lab, Trainee trainee) {
        this.id = id;
        this.lab = lab;
        this.trainee = trainee;
    }
    public Assistancequeue(AssistancequeueId id, Lab lab, Trainee trainee, Date requestDate, Boolean activated) {
       this.id = id;
       this.lab = lab;
       this.trainee = trainee;
       this.requestDate = requestDate;
       this.activated = activated;
    }
   
    public AssistancequeueId getId() {
        return this.id;
    }
    
    public void setId(AssistancequeueId id) {
        this.id = id;
    }
    public Lab getLab() {
        return this.lab;
    }
    
    public void setLab(Lab lab) {
        this.lab = lab;
    }
    public Trainee getTrainee() {
        return this.trainee;
    }
    
    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }
    public Date getRequestDate() {
        return this.requestDate;
    }
    
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    public Boolean getActivated() {
        return this.activated;
    }
    
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    @Override
    public int compareTo(Object o) {
        return this.requestDate.compareTo(((Assistancequeue)o).requestDate);
    }

    @Override
    public String toString() {
        return trainee.toString();
    }
}


