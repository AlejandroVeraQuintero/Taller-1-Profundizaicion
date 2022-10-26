package Taller1.Api.persistence.services.dto;

import Taller1.Api.persistence.entity.Dependencia;
import Taller1.Api.persistence.entity.Perfil;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UsuarioConListFilaInDTO {
    private long usuarioId;
    private boolean activo;
    private Date FechaNacimiento;
    private Dependencia dependencia;
    private String[] perfil;
    private List<FilaListaInDTO> filas;


}
