package Taller1.Api.mapper;

import Taller1.Api.persistence.services.dto.UsuarioIdInDTO;
import Taller1.Api.persistence.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioIdInDTOToTask implements IMapper<UsuarioIdInDTO, Usuario> {
    @Override
    public Usuario map(UsuarioIdInDTO in) {
            Usuario usuario = new Usuario();
            usuario.setId(in.getUsuarioId());
        return usuario;
    }
}
