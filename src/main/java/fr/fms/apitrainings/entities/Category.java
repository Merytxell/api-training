package fr.fms.apitrainings.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Category implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Training training;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    @JsonIgnore
    private Collection<Training> trainings;




}
