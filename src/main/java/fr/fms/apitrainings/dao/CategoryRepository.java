package fr.fms.apitrainings.dao;

import fr.fms.apitrainings.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
