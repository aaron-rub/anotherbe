package com.nighthawk.spring_portfolio.mvc.player;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;

// RestController annotation is used to create RESTful web services using Spring MVC
@RestController
// RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers.
@RequestMapping("/api/players")
public class PlayerController {

    // ConcurrentHashMap is a thread-safe collection of key-value pairs.
    private ConcurrentHashMap<String, Player> players = new ConcurrentHashMap<>();

    // PostMapping annotation handles HTTP POST requests matched with given URI expression.
    @PostMapping
    public Player create(@RequestBody Player player) {
        // put method associates the specified value with the specified key in this map
        players.put(player.getUid(), player);
        return player;
    }

    // GetMapping annotation handles HTTP GET requests matched with given URI expression.
    @GetMapping
    public Collection<Player> getAll() {
        // values method returns a Collection view of the values contained in this map
        return players.values();
    }

    // PutMapping annotation handles HTTP PUT requests matched with given URI expression.
    @PutMapping("/{uid}")
    public Player update(@PathVariable String uid, @RequestBody Player playerDetails) {
        // get method returns the value to which the specified key is mapped
        Player player = players.get(uid);
        // update player details
        player.setName(playerDetails.getName());
        player.setUid(playerDetails.getUid());
        player.setDistance(playerDetails.getDistance());
        return player;
    }

    // DeleteMapping annotation handles HTTP DELETE requests matched with given URI expression.
    @DeleteMapping("/{uid}")
    public String delete(@PathVariable String uid) {
        // remove method removes the key (and its corresponding value) from this map
        Player removedPlayer = players.remove(uid);
        // check if player was removed
        return removedPlayer != null ? "Player removed" : "Player not found";
    }
}
