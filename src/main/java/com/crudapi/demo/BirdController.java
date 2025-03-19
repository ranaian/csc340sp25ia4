package com.crudapi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/birds")
public class BirdController {

    @Autowired
    private BirdService birdService;

    /**
     * Get a list of good birds
     * http://localhost:8080/birds/all
     * @return a list of bird objects
     */
    @GetMapping("/all")
    public Object getAllBirds() {
        return new ResponseEntity<>(birdService.getAllBirds(), HttpStatus.OK);
    }

    /**
     * get a good bird by its ID
     * http://localhost:8080/birds/2
     *
     * @param birdId
     * @return one bird object
     */
    @GetMapping("/{birdId}")
    public Object getOneBird(@PathVariable int birdId){
        return new ResponseEntity<>(birdService.getBirdById(birdId), HttpStatus.OK);
    }

    /**
     * get good birds by family
     * http://localhost:8080/birds/family/Columbidae
     * @param family
     * @return a list of bird objects matching the family
     */
    @GetMapping("/family/{family}")
    public Object getBirdsByFamily(@PathVariable String family){
        return new ResponseEntity<>(birdService.getBirdsByFamily(family), HttpStatus.OK);
    }
    /**
     * Get a list of birds with names that contain the given string
     * http://localhost:8080/birds/name?search=eagle
     * @param search
     * @return list of bird objects matching search key
     * (not working)
     */
        @GetMapping("/name")
        public Object getBirdsByName(@RequestParam(name = "search", defaultValue = "") String search){
            return new ResponseEntity<>(birdService.getBirdsByName(search), HttpStatus.OK);
        }


    /**
     * Invent a totally new bird, unknown to traditional science!
     * http://localhost:8080/birds/new
     * --data '{ "name": "hypothetical pigeon",
     *           "family": "Columbidae",
     *           "species": "Columba Livia Hypothetical",
     *           "description": "a bird that may or may not exist"}'
     * @param newBird the new Bird object
     * @return the updated list of birds
     */
    @PostMapping("/new")
    public Object addNewBird(@RequestBody Bird newBird) {
        birdService.addNewBird(newBird);
        return new ResponseEntity<>(birdService.getAllBirds(), HttpStatus.OK);
    }

    /**
     * change the details of an existing bird object
     * http://localhost:8080/birds/update/2
     * --data '{ "birdId": 2,
     *           "birdName": "theoretical pigeon",
     *           "family":  "Columbidae"
     *           "species": "Columba Livia Theoretical"
     *           "description": "a bird that could exist"}'
     * @param birdId the unique bird id
     * @param bird the new updated bird details
     * @return the updated bird object
     */
    @PutMapping("/update/{birdId}")
    public Object updateBird(@PathVariable int birdId, @RequestBody Bird bird){
        birdService.updateBird(birdId, bird);
        return new ResponseEntity<>(birdService.getBirdById(birdId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{birdId}")
    public Object deleteBirdById(@PathVariable int birdId) {
        birdService.deleteBirdById(birdId);
        return new ResponseEntity<>(birdService.getAllBirds(), HttpStatus.OK);
    }

}
