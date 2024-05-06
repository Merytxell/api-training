package fr.fms.apitrainings.web;

import fr.fms.apitrainings.entities.Training;
import fr.fms.apitrainings.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @GetMapping("/trainings/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable("id") Long id){
        Optional<Training> training = implTrainingService.readTraining(id);
        if (training.isPresent()){
            return new ResponseEntity<>(training.get(), HttpStatus.OK);

        }
        return null;
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
