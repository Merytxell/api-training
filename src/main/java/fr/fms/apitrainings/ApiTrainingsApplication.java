package fr.fms.apitrainings;

import fr.fms.apitrainings.dao.CategoryRepository;
import fr.fms.apitrainings.dao.TrainingRepository;
import fr.fms.apitrainings.entities.Category;
import fr.fms.apitrainings.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTrainingsApplication implements CommandLineRunner {

	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private CategoryRepository categoryRepository;

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

		Category programmation = categoryRepository.save(new Category(null, "langage de programmation",null,null));
		Category informatique = categoryRepository.save(new Category(null, "informatique",null,null));

		trainingRepository.save(new Training(null,"java", "cours pour débutant", 3500, 1,  programmation));
		trainingRepository.save(new Training(null,"DotNet", "Dotnet et entityframework en 5 jours", 2700, 1, programmation));
		trainingRepository.save(new Training(null,"PowerBi", "Business intelligence en 5 jours", 2700, 1, programmation));
		trainingRepository.save(new Training(null,"Spring", "Ne travaillez pas avec un projet cloné", 2520, 1, programmation));
		trainingRepository.save(new Training(null,"NGRX", "ABRACADABRA un site tout prêt", 3200, 1, programmation));
		trainingRepository.save(new Training(null,"Linux", "adoptez un pingouin", 2500, 1, informatique));
		trainingRepository.save(new Training(null,"Windows Server", "prise en main d'active directory", 3000, 1, informatique));
		trainingRepository.save(new Training(null,"Powershell", "automatisation des tâches : comment gagner du temps", 2000, 1, informatique));
	}
}
