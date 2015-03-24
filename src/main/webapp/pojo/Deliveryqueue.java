package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Deliveryqueue generated by hbm2java
 */
public class Deliveryqueue  implements java.io.Serializable , Comparable<Deliveryqueue>{


     private DeliveryqueueId id;
     private Lab lab;
     private Trainee trainee;
     private Date requestDate;
     private Boolean activated;

    public Deliveryqueue() {
    }

	
    public Deliveryqueue(DeliveryqueueId id, Lab lab, Trainee trainee) {
        this.id = id;
        this.lab = lab;
        this.trainee = trainee;
    }
    public Deliveryqueue(DeliveryqueueId id, Lab lab, Trainee trainee, Date requestDate, Boolean activated) {
       this.id = id;
       this.lab = lab;
       this.trainee = trainee;
       this.requestDate = requestDate;
       this.activated = activated;
    }
   
    public DeliveryqueueId getId() {
        return this.id;
    }
    
    public void setId(DeliveryqueueId id) {
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
    public int compareTo(Deliveryqueue o) {
        return this.requestDate.compareTo(requestDate);
    }




}


