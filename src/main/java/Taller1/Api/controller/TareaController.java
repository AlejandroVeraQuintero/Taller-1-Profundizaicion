package Taller1.Api.controller;

import Taller1.Api.exceptions.TareaException;
import Taller1.Api.persistence.entity.Tarea;
import Taller1.Api.persistence.services.TareaService;
import Taller1.Api.persistence.services.dto.TareaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;


    @PostMapping
    public Tarea createTarea(@RequestBody TareaInDTO taskInDTO){
        return tareaService.createTarea(taskInDTO);
    }

    @GetMapping
    public List<Tarea> findAll(){
        return tareaService.findAll();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTareaById(@PathVariable("id") Long id){
        Tarea tarea = this.tareaService.deleteTareaById(id);
        if(Objects.isNull(tarea)){
            throw new TareaException("Task not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.noContent().build();
    }

}
