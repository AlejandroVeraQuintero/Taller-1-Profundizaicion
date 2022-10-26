package Taller1.Api.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tareas")

public class Tarea {

    @Id
    @Column(name = "tarea_id")
    private Long tareaId;

    @Column(name = "nombre")
    private String nombre;


}
