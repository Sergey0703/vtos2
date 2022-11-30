package local.vtos2.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Calendar;

@Entity
@Table
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message="Name must not be empty")
    @Size(min=6, max=255, message="Name must be between 6 and 255 letters long")
    @Column(name="username")
    private String username;
    @NotEmpty(message="Password must not be empty")
    @Size(min=8, max=255, message="Password must be between 6 and 255 symbols long")
    @Column(name="password")
    private String password;

    @Column(name="date_of_birth")
    @Temporal(TemporalType.DATE)
    private Calendar date_of_birth;

    public Person() {

    }

    public Person(String username, String password, Calendar date_of_birth) {
        this.username = username;
        this.password = password;
        this.date_of_birth = date_of_birth;
    }

    public int getId() {
        return id;
    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Calendar date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
