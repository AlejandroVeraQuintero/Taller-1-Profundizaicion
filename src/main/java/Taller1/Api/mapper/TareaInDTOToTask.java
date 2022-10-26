package Taller1.Api.mapper;

import Taller1.Api.persistence.entity.Tarea;
import Taller1.Api.persistence.services.dto.TareaInDTO;
import org.springframework.stereotype.Component;

@Component
public class TareaInDTOToTask implements IMapper<TareaInDTO, Tarea> {

    @Override
    public Tarea map(TareaInDTO in) {
        Tarea tarea = new Tarea();
        tarea.setTareaId(in.getTareaId());
        tarea.setNombre(in.getNombre());
        return tarea;
    }
}
