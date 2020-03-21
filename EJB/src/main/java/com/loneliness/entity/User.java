package com.loneliness.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id", "name" })
public class User {
    @Id

    private String id;

    private String name;

    private String userpic;

    private String email;

    private String gender;

    private String locale;

    private LocalDateTime lastVisit;


}
