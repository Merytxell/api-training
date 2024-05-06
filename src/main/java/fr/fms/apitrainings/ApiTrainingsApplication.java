package fr.fms.apitrainings;

import fr.fms.apitrainings.dao.TrainingRepository;
import fr.fms.apitrainings.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTrainingsApplication implements CommandLineRunner {

	@Autowired
	private TrainingRepository trainingRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiTrainingsApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		trainingRepository.save(new Training(null,"java", "cours pour débutant", 3500, 1));
		trainingRepository.save(new Training(null,"DotNet", "Dotnet et entityframework en 5 jours", 2700, 1));
		trainingRepository.save(new Training(null,"PowerBi", "Business intelligence en 5 jours", 2700, 1));
		trainingRepository.save(new Training(null,"Spring", "Ne travaillez pas avec un projet cloné", 2520, 1));
		trainingRepository.save(new Training(null,"NGRX", "ABRACADABRA un site tout prêt", 3200, 1));
	}
}
