package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Assignment generated by hbm2java
 */
public class Assignment  implements java.io.Serializable {


     private AssignmentId id;
     private Lab lab;
     private Trainee trainee;
     private Date uploadTime;
     private byte[] assignmentData;

    public Assignment() {
    }


    public Assignment(AssignmentId id, Lab lab, Trainee trainee) {
        this.id = id;
        this.lab = lab;
        this.trainee = trainee;
    }
    public Assignment(AssignmentId id, Lab lab, Trainee trainee, Date uploadTime, byte[] assignmentData) {
       this.id = id;
       this.lab = lab;
       this.trainee = trainee;
       this.uploadTime = uploadTime;
       this.assignmentData = assignmentData;
    }
   
    public AssignmentId getId() {
        return this.id;
    }

    public void setId(AssignmentId id) {
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
    public Date getUploadTime() {
        return this.uploadTime;
    }
    
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
    public byte[] getAssignmentData() {
        return this.assignmentData;
    }
    
    public void setAssignmentData(byte[] assignmentData) {
        this.assignmentData = assignmentData;
    }




}


