package pojo;
// Generated Mar 20, 2015 2:19:00 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Instructor generated by hbm2java
 */
public class Instructor extends User implements java.io.Serializable {


     private Set labs = new LinkedHashSet(0);

    public Instructor() {
    }

	
    public Instructor(Set courses, Set labs) {
       this.labs = labs;
    }



    public Set getLabs() {
        return this.labs;
    }
    
    public void setLabs(Set labs) {
        this.labs = labs;
    }




}


