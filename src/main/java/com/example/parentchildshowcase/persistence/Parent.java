package com.example.parentchildshowcase.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Table(name = "parents")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "parent",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )

    List<Child> children = new ArrayList<>();
}