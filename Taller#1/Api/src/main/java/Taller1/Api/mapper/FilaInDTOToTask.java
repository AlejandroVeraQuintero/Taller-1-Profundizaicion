package Taller1.Api.mapper;

import Taller1.Api.persistence.entity.Fila;
import Taller1.Api.persistence.services.dto.FilaInDTO;
import org.springframework.stereotype.Component;

@Component
public class FilaInDTOToTask implements IMapper<FilaInDTO, Fila> {

    private final TareaIdInDTOToTask tareaIdInDTOToTask;
    private final UsuarioIdInDTOToTask usuarioIdInDTOToTask;

    public FilaInDTOToTask(TareaIdInDTOToTask tareaInDTOToTask, UsuarioIdInDTOToTask usuarioInDTOToTask) {
        this.tareaIdInDTOToTask = tareaInDTOToTask;
        this.usuarioIdInDTOToTask = usuarioInDTOToTask;
    }

    @Override
    public Fila map(FilaInDTO in ) {
        Fila fila = new Fila();
        fila.setFilaId(in.getFilaId());
        fila.setDuracion(in.getDuracion());
        fila.setTarea(tareaIdInDTOToTask.map(in.getTarea()));
        fila.setUsuario(usuarioIdInDTOToTask.map(in.getUsuario()));
        return fila;
    }
}
