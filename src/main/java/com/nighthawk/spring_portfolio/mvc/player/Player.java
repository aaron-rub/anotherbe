package com.nighthawk.spring_portfolio.mvc.player;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "uid", unique = true, nullable = false)
    private String uid;

    @Column(name = "distance", nullable = false)
    private int distance;

    // getters and setters

    public Player(String name, String uid, int i) {
        this.name = name;
        this.uid = uid;
        this.distance = i;
    }
// getters and setters

Player player1 = new Player("Azeem Khan", "azeemK", 45);
Player player2 = new Player("Ahad Biabani", "ahadB", 41);
Player player3 = new Player("Akshat Parikh", "akshatP", 40);
Player player4 = new Player("Josh Williams", "joshW", 38);

public String getUid() {
    return null;
}

public Object getName() {
    return null;
}

public void setName(Object name2) {
}

public void setUid(String uid2) {
}

public Object getDistance() {
    return null;
}

public void setDistance(Object distance2) {
}

}
