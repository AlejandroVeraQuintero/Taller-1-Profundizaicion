package Taller1.Api.persistence.services;

import Taller1.Api.mapper.TareaInDTOToTask;
import Taller1.Api.persistence.entity.Tarea;
import Taller1.Api.persistence.entity.Usuario;
import Taller1.Api.persistence.repository.TareaRepository;
import Taller1.Api.persistence.services.dto.TareaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;
    private final TareaInDTOToTask tareaInDTOToTask;


    public Tarea createTarea(TareaInDTO tareaInDTO){
        Tarea tarea = tareaInDTOToTask.map(tareaInDTO);
        return this.tareaRepository.save(tarea);
    }

    public List<Tarea> findAll(){
        return this.tareaRepository.findAll();
    }

    public Tarea findById(long id) { return this.tareaRepository.findById(id).orElse(null); }
    @Transactional
    public Tarea deleteTareaById(Long id){
        Optional<Tarea> tarea = this.tareaRepository.findById(id);
        if(tarea.isEmpty()){
            return null;
        }
        this.tareaRepository.deleteById(id);
        return tarea.orElse(null);
    }
}
