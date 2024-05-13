package fr.fms.apitrainings.dao;

import fr.fms.apitrainings.entities.Category;
import fr.fms.apitrainings.entities.Training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


//@CrossOrigin
//@RepositoryRestResource
@Repository
public interface TrainingRepository extends JpaRepository <Training, Long> {
    List<Training> findByCategory(Category category);
//    public List <Training> findAll();

}
