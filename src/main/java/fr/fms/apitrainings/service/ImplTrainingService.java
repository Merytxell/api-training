package fr.fms.apitrainings.service;

import fr.fms.apitrainings.dao.TrainingRepository;
import fr.fms.apitrainings.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplTrainingService implements  ITrainingService{

    @Autowired
    TrainingRepository trainingRepository;


    public List<Training> getTrainings() {
       return trainingRepository.findAll();
    }
    @Override
    public Training saveTraining(Training t) {
        return trainingRepository.save(t);

    }

    public void deleteTraining(Long id) throws  Exception{
       trainingRepository.deleteById(id);
    }

    public Optional<Training> readTraining(Long id) {
        return trainingRepository.findById(id);
    }
}
