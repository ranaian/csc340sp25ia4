package com.crudapi.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * providing search feature
 */
@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer> {


    List<Bird> getBirdsByFamily(String family);

    @Query(value = "select * from birds s where s.name like %?1%", nativeQuery = true)
    List<Bird> getBirdsByName(String name);


}
