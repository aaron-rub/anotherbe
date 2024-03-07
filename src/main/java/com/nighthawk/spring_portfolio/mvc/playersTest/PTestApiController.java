package com.nighthawk.spring_portfolio.mvc.playersTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/ptest")  // all requests in file begin with this URI
@CrossOrigin(origins = "*", allowedHeaders = "*")  // Enable CORS for all origins
public class PTestApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private PTestJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<PTest>> getJokes() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }
    // Updates position
    @PostMapping("/move/{id}/{newPos}")
    public ResponseEntity<PTest> setPos(@PathVariable long id, @PathVariable int newPos) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<PTest> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            PTest joke = optional.get();  // value from findByID
            joke.setPos(newPos); // increment value
            repository.save(joke);  // save entity
            return new ResponseEntity<>(joke, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }
}
