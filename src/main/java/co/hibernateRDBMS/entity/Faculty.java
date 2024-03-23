package co.hibernateRDBMS.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name="Faculty") this annotation is not required when table name is same as class name
public class Faculty {
    //@Column(name = "")this annotation is not required when column name is same as property name
     @Id
     private Integer facultyId;
     private String facultyName;
     @OneToMany(cascade = CascadeType.ALL)//this is used to delete all batches for a particular faculty when faculty is deleted
     @JoinColumn(name = "facultyId")
     private Set<Batch> batches;

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Set<Batch> getBatches() {
        return batches;
    }

    public void setBatches(Set<Batch> batches) {
        this.batches = batches;
    }
}
