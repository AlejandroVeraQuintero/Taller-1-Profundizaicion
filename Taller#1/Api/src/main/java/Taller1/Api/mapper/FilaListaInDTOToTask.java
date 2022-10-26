package Taller1.Api.mapper;

import Taller1.Api.persistence.entity.Fila;
import Taller1.Api.persistence.services.dto.FilaListaInDTO;
import org.springframework.stereotype.Component;

@Component
public class FilaListaInDTOToTask  implements IMapper<Fila, FilaListaInDTO>{
    @Override
    public FilaListaInDTO map(Fila in) {
        FilaListaInDTO filaDTO = new FilaListaInDTO();
        filaDTO.setFilaId(in.getFilaId());
        filaDTO.setDuracion(in.getDuracion());
        return filaDTO;
    }
}
