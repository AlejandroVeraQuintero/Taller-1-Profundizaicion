package Taller1.Api.persistence.services;

import Taller1.Api.exceptions.UsuarioException;
import Taller1.Api.mapper.FilaInDTOToTask;
import Taller1.Api.persistence.entity.Fila;
import Taller1.Api.persistence.entity.Tarea;
import Taller1.Api.persistence.entity.Usuario;
import Taller1.Api.persistence.repository.FilaRepository;
import Taller1.Api.persistence.services.dto.FilaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilaService {

    private final FilaRepository filaRepository;
    private final FilaInDTOToTask filaInDTOToTask;

    private final UsuarioService usuarioService;

    private final TareaService tareaService;

    public Fila createFila(FilaInDTO filaInDTO){
        Usuario usuario = usuarioService.findById(filaInDTO.getUsuario().getUsuarioId());
        Tarea tarea = tareaService.findById(filaInDTO.getTarea().getTareaId());
        Fila fila = filaInDTOToTask.map(filaInDTO);
        fila.setUsuario(usuario);
        fila.setTarea(tarea);
        ValidarFila(fila);
        return this.filaRepository.save(fila);
    }

    public List<Fila> findAll(){
        return this.filaRepository.findAll();
    }

    @Transactional
    public Fila deleteFilaById(Long id){
        Optional<Fila> fila = this.filaRepository.findById(id);
        if(fila.isEmpty()){
            return null;
        }
        this.filaRepository.deleteById(id);
        return fila.orElse(null);
    }

    private  void ValidarFila(Fila fila){
        ValidarDuracion(fila.getDuracion());
    }

    private void ValidarDuracion(int duracion){
        if(duracion < 1 || duracion > 60) throw new UsuarioException("La duracion Sobrepasa o esta por debajo del rango estipulado (1-60)", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
