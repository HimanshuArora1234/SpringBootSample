package entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Created by galloisg on 26/07/2016.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 3807860860521706371L;

	@Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}