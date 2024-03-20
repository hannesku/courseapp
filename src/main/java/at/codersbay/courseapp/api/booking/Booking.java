package at.codersbay.courseapp.api.booking;


import at.codersbay.courseapp.api.course.Course;
import at.codersbay.courseapp.api.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "TB_BOOKING")
public class Booking {

    @EmbeddedId
    private BookingId id;

    @JsonIgnore
    @OneToOne
    @MapsId("courseId")
    private Course course;

    @JsonIgnore
    @ManyToOne
    @MapsId("userId")
    private User user;

    @Column
    private LocalDateTime createOn = LocalDateTime.now();

    protected Booking() {

    }

    public Booking(Course course, User user) {
        this.course = course;
        this.user = user;
        this.id = new BookingId(course.getId(), user.getId());
    }


}
