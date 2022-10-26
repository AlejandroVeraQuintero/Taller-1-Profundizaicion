package Taller1.Api.mapper;

import Taller1.Api.persistence.entity.Usuario;
import Taller1.Api.persistence.services.dto.UsuarioInDTO;
import org.springframework.stereotype.Component;



@Component
public class UsuarioInDTOToTask implements IMapper<UsuarioInDTO, Usuario> {
    @Override
    public Usuario map(UsuarioInDTO in) {
        Usuario usuario = new Usuario();
        usuario.setId(in.getUsuarioId());
        usuario.setFechaNacimiento(in.getFechaNacimiento());
        usuario.setActivo(false);
        usuario.setPerfil(in.getPerfil());
        usuario.setDependencia(in.getDependencia());
        return usuario;
    }
}




