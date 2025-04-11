package com.crudapi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
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
    public Object getAllBirds(Model model) {
        //return new ResponseEntity<>(birdService.getAllBirds(), HttpStatus.OK);
        model.addAttribute("birdList", birdService.getAllBirds());
        model.addAttribute("title", "All Birds");
        return "bird-list";
    }

    /**
     * get a good bird by its ID
     * http://localhost:8080/birds/2
     *
     * @param birdId
     * @return one bird object
     */
 /**   @GetMapping("/{birdId}")
    public Object getOneBird(@PathVariable int birdId, Model model){
        //return new ResponseEntity<>(birdService.getBirdById(birdId), HttpStatus.OK);
        model.addAttribute("bird", birdService.getBirdById(birdId));
        model.addAttribute("title" , "Bird #: " + birdId);
        return "bird-details";
    }**/

    /**
     * get good birds by family
     * http://localhost:8080/birds/family/Columbidae
     * @param family
     * @return a list of bird objects matching the family
     */
    @GetMapping("/family/{family}")
    public Object getBirdsByFamily(@PathVariable String family, Model model){
        //return new ResponseEntity<>(birdService.getBirdsByFamily(family), HttpStatus.OK);
        model.addAttribute("birdList", birdService.getBirdsByFamily(family));
        model.addAttribute("title" , "Birds by Family: " + family);
        return "bird-list";
    }
    /**
     * Get a list of birds with names that contain the given string
     * http://localhost:8080/birds/name?search=eagle
     * @param search
     * @return list of bird objects matching search key
     * (not working)
     */
    @GetMapping("/name")
    public Object getBirdsByName(@RequestParam(name = "search", defaultValue = "") String search, Model model){
        //return new ResponseEntity<>(birdService.getBirdsByName(search), HttpStatus.OK);
        model.addAttribute("birdList", birdService.getBirdsByName(search));
        model.addAttribute("title", "Birds by Name: " + search);
        return "bird-list";
    }


    /**
     * get for bird-create.ftlh
     */
    @GetMapping("/new")
    public Object addNewBird(Model model){
        Bird newBird = new Bird();
        model.addAttribute("bird", newBird);
        model.addAttribute("title", "Create a new Bird");
        return "bird-create";
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
    public Object addNewBird(Bird newBird, Model model) {
        birdService.addNewBird(newBird);
        return "redirect:/birds/all";
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
    /**
     * display the update bird form
     * @param birdId
     * @param model
     * @return
     */
    @GetMapping("/update/{birdId}")
    public Object updateBird(@PathVariable int birdId, Model model){
        //birdService.updateBird(birdId, bird);
        model.addAttribute("bird", birdService.getBirdById(birdId));
        return "bird-update";
    }

    /**
     * actually update the bird object i think?
     * @param birdId
     * @return
     */
    @PostMapping("/update/{birdId}")
    public Object updateBird(@PathVariable int birdId, Bird bird){
        birdService.updateBird(birdId, bird);
        return "redirect:/birds/all";
    }

    @GetMapping("/delete/{birdId}")
    public Object deleteBirdById(@PathVariable int birdId) {
        birdService.deleteBirdById(birdId);
        //return new ResponseEntity<>(birdService.getAllBirds(), HttpStatus.OK);
        return "redirect:/birds/all";
    }

    @GetMapping("/about")
    public Object aboutPage(){
        return "birds-about";
    }

    @GetMapping("/details/{birdId}")
    public Object getOneBird(@PathVariable int birdId, Model model){
        model.addAttribute("bird", birdService.getBirdById(birdId));
        model.addAttribute("title", "Bird: " + birdService.getBirdById(birdId).getSpecies());
        return "bird-details";
    }

}
