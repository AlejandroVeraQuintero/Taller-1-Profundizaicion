package Taller1.Api.persistence.services.dto;

import lombok.Data;

@Data
public class FilaInDTO {

    private long filaId;
    private int duracion;
    private TareaIdInDTO tarea;
    private UsuarioIdInDTO usuario;
}
