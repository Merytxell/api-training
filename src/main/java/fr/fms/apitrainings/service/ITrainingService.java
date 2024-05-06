package fr.fms.apitrainings.service;

import fr.fms.apitrainings.entities.Training;
import org.springframework.stereotype.Service;


@Service
public interface ITrainingService {

    Training saveTraining(Training t) throws Exception;
}
