package Taller1.Api.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "filas")

public class Fila {

    @Id
    @Column(name = "filaId")
    private long filaId;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "tareaId", unique = true)
    private Tarea tarea;

    @Column(name = "duracion")
    private int duracion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Usuario usuario;




}
