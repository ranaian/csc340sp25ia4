package com.crudapi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    /**
     * fetch all birds
     * @return the list of all birds
     */
    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

    /**
     * attempt to fetch a unique bird
     * @param birdId the unique bird id
     * @return a unique bird object
     */
    public Bird getBirdById(int birdId) {
        return birdRepository.findById(birdId).orElse(null);
    }

    public List<Bird> getBirdsByName(String name) {
        return birdRepository.getBirdsByName(name);
    }

    public List<Bird> getBirdsByFamily(String family) {
        return birdRepository.getBirdsByFamily(family);
    }

    /**
     * add a new bird ot the database!
     *
     * @param newBird the bird to add
     */
    public void addNewBird(Bird newBird) {
        birdRepository.save(newBird);
    }

    /**
     * update an existing bird
     * @param birdId the unique bird id
     * @param bird the new bird details
     */
    public void updateBird(int birdId, Bird bird) {
        Bird existing = getBirdById(birdId);
        existing.setName(bird.getName());
        existing.setFamily(bird.getFamily());
        existing.setSpecies(bird.getSpecies());
        existing.setDescription(bird.getDescription());
        birdRepository.save(existing);
    }

    /**
     * remove a bird from the repository
     * you monster
     * @param birdId the bird id
     */
    public void deleteBirdById(int birdId) {
        birdRepository.deleteById(birdId);
    }

}
