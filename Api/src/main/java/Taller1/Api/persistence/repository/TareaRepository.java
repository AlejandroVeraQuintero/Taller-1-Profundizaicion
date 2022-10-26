package Taller1.Api.persistence.repository;

import Taller1.Api.persistence.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository  extends JpaRepository<Tarea,Long> {

}
