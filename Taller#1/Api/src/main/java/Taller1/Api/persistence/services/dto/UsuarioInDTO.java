package Taller1.Api.persistence.services.dto;

import Taller1.Api.persistence.entity.Dependencia;
import Taller1.Api.persistence.entity.Perfil;
import lombok.Data;

import java.util.Date;

@Data
public class UsuarioInDTO {

    private long usuarioId;
    private Date FechaNacimiento;
    private Dependencia dependencia;
    private Perfil[] perfil ;
}
