package com.mtx.domain;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id", allocationSize=1) //每次增加多少
    private Long id;

    @Column(name="username",unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstname;


    @Column(name ="last_name") //all capital or _
    private String lastname; // camelcase

    @Column(unique = true)
    @NotNull
    private String email;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "passsword")
    private String password;

    public long getId() { return id;}

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username; }

    public String getFirstname() { return firstname;}
    public void setFirstname(String firstname) { this.firstname = firstname;}

    public String getLastname() { return lastname;}
    public void setLastname(String lastname) { this.lastname = lastname;}

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password;} //incapsulation

}
