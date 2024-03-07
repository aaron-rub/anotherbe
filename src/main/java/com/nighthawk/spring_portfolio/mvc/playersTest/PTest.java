package com.nighthawk.spring_portfolio.mvc.playersTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class PTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String playerName;

    private int pos;
    //private int pos;

    // starting players
    public static String[] init() {
        final String[] playerNames2 = {
            "P1",
            "P2",
            "P3",
            "P4"
        };
        return playerNames2;
    }
}