package Taller1.Api.mapper;

import Taller1.Api.persistence.services.dto.TareaIdInDTO;
import Taller1.Api.persistence.entity.Tarea;
import org.springframework.stereotype.Component;

@Component
public class TareaIdInDTOToTask implements IMapper<TareaIdInDTO, Tarea>{



    @Override
    public Tarea map(TareaIdInDTO in) {
        Tarea tarea = new Tarea();
        tarea.setTareaId(in.getTareaId());
        return tarea;
    }
}
