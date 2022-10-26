package Taller1.Api.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "fecha_nacimiento")
    private Date FechaNacimiento;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "dependencia")
    private Dependencia dependencia;

    @Column( name = "perfil")
    private String[] perfil;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Fila> filas;





}
