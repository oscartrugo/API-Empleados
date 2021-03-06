package com.example.empleados.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tbl_Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class User extends Base {
    @Column(name = "UserName")
    private String username;

    @Column(name = "Password") //Developer, DevOps
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_profile")
    )
    private List<Profile> profiles = new ArrayList<>();
    @Column(name="IdProfile")
    private int idprofile;

    @Column(name = "IdEmployee") //Developer, DevOps
    private int idemployee;

    @Column(name = "Status")
    private int status;

    @Column(name = "CreatedDate") //Developer, DevOps
    private Date createddate;

    @Column(name = "UpdatedDate")
    private Date updateddate;

    @Column(name = "Login") //Developer, DevOps
    private int login;
}
