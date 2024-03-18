package at.codersbay.courseapp.api.user;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name= "TB_User")
public class User {
    @Id
    @GeneratedValue(generator = "user-sequence-generator")
    @GenericGenerator(
            name = "user-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @Column(nullable = false, unique = true)
    private String usernamen;

    @Column
    private String password;

    @Column
    private String email;

    public User() {
    }

    public User(String usernamen, String password, String email) {
        this.usernamen = usernamen;
        this.password = password;
        this.email = email;
    }

    public String getUsernamen() {
        return usernamen;
    }

    public void setUsernamen(String usernamen) {
        this.usernamen = usernamen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
