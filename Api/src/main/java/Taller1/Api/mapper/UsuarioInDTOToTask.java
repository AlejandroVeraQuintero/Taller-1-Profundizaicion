package Taller1.Api.mapper;

import Taller1.Api.persistence.entity.Perfil;
import Taller1.Api.persistence.entity.Usuario;
import Taller1.Api.persistence.services.dto.UsuarioInDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class UsuarioInDTOToTask implements IMapper<UsuarioInDTO, Usuario> {
    @Override
    public Usuario map(UsuarioInDTO in) {
        Usuario usuario = new Usuario();
        usuario.setId(in.getUsuarioId());
        usuario.setFechaNacimiento(in.getFechaNacimiento());
        usuario.setActivo(false);
        usuario.setPerfil(ConvertirPerfilToString(in.getPerfil()));
        usuario.setDependencia(in.getDependencia());
        return usuario;
    }

    private String[] ConvertirPerfilToString(Perfil[] perfiles ){
        String[] perfilArray = new String[perfiles.length];
        int i = 0;
        for (Perfil p: perfiles){
            perfilArray[i]=p.toString();
            i++;
        }
        return perfilArray;
    }
}




