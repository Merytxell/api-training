package fr.fms.apitrainings.web;

import fr.fms.apitrainings.entities.Category;
import fr.fms.apitrainings.entities.Training;
import fr.fms.apitrainings.exception.RecordNotFoundException;
import fr.fms.apitrainings.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")


public class TrainingController {

    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/trainings")
    public List<Training> allTrainings(){
        return implTrainingService.getTrainings();
    }


    @DeleteMapping("/trainings/{id}")
    public void deleteTraining(@PathVariable("id") Long id) throws Exception {
        implTrainingService.deleteTraining(id);
    }

    @GetMapping("/category")
    public List<Category> allCategory(){
        return implTrainingService.getCategory();
    }

    @GetMapping("/trainings/category/{id}")
    public List<Training> getTrainingByCategory(@PathVariable("id") Long id){
        System.out.println("hello");
    return  implTrainingService.getTrainingCategory(id);
    }

    @GetMapping("/trainings/{id}")
    Training getTrainingById(@PathVariable("id") Long id){
    return implTrainingService.readTraining(id)
            .orElseThrow( () -> new RecordNotFoundException("Id de la formation" + id +"n'existe pas"));
    }

    @PostMapping("/trainings")
    public ResponseEntity<Training>saveTraining(@RequestBody Training t){
        Training training = implTrainingService.saveTraining(t);
        if (Objects.isNull(training)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(training.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
