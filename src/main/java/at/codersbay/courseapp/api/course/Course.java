package at.codersbay.courseapp.api.course;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name= "TB_COURSE")
public class Course {

    @Id
    @GeneratedValue(generator = "course-sequence-generator")
    @GenericGenerator(
            name = "course-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "course_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private int maxAttendee;

    public Course() {
    }

    public Course(String title, String description, int maxAttendee) {
        this.title = title;
        this.description = description;
        this.maxAttendee = maxAttendee;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxAttendee() {
        return maxAttendee;
    }

    public void setMaxAttendee(int maxAttendee) {
        this.maxAttendee = maxAttendee;
    }
}
