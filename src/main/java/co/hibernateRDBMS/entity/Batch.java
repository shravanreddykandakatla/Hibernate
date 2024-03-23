package co.hibernateRDBMS.entity;

import javax.persistence.*;

//@Table(name="Faculty") this annotation is not required when table name is same as class name
@Entity
public class Batch {
    //@Column(name="")this annotation is not required when column name is same as property name
    @Id
    @GeneratedValue
    private Integer batchId;

    private String courseName;
    @ManyToOne
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    public Batch(String courseName, Faculty faculty) {
        super();
        this.courseName = courseName;
        this.faculty = faculty;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
