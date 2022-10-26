package Taller1.Api.mapper;

import Taller1.Api.persistence.entity.Fila;
import Taller1.Api.persistence.entity.Usuario;
import Taller1.Api.persistence.services.dto.FilaListaInDTO;
import Taller1.Api.persistence.services.dto.UsuarioConListFilaInDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioConListFilaInDTOToTask  implements IMapper<Usuario,UsuarioConListFilaInDTO>{

    @Override
    public UsuarioConListFilaInDTO map(Usuario in) {
        UsuarioConListFilaInDTO usuarioDTO = new UsuarioConListFilaInDTO();
        usuarioDTO.setUsuarioId(in.getId());
        usuarioDTO.setActivo(in.isActivo());
        usuarioDTO.setFechaNacimiento(in.getFechaNacimiento());
        usuarioDTO.setDependencia(in.getDependencia());
        usuarioDTO.setPerfil(in.getPerfil());
        usuarioDTO.setFilas(ConvertirListaFilas(in.getFilas()));
        return usuarioDTO;
    }

    private List<FilaListaInDTO> ConvertirListaFilas(List<Fila> fl){

         List<FilaListaInDTO>filas = fl.stream().map(fila ->{
            FilaListaInDTO filaDTO = new FilaListaInDTO();
            filaDTO.setFilaId(fila.getFilaId());
            filaDTO.setDuracion(fila.getDuracion());
            return filaDTO;
        }).collect(Collectors.toList());
        return filas;
    }
}
