package fr.fms.apitrainings.entities;



import fr.fms.apitrainings.dao.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
public class Training implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    @ManyToOne
    private Category category;

    public Training(Long id, String name, String description, double price, int quantity, Category category) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
        this.category=category;
    }
}

