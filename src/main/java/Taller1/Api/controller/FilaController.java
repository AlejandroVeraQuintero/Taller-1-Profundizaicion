package Taller1.Api.controller;

import Taller1.Api.exceptions.FilaException;
import Taller1.Api.mapper.FilaListaInDTOToTask;
import Taller1.Api.mapper.UsuarioConListFilaInDTOToTask;
import Taller1.Api.persistence.entity.Fila;
import Taller1.Api.persistence.services.FilaService;
import Taller1.Api.persistence.services.dto.FilaInDTO;
import Taller1.Api.persistence.services.dto.FilaListaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fila")
@RequiredArgsConstructor
public class FilaController {
    private final FilaService filaService;

    private final FilaListaInDTOToTask filaListaInDTOToTask;

    @PostMapping
    public ResponseEntity<?> createFila(@RequestBody FilaInDTO filaInDTO){
        filaService.createFila(filaInDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<FilaListaInDTO> findAll(){
        return filaService.findAll().stream().map(fila -> filaListaInDTOToTask.map(fila)).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilaById(@PathVariable("id") Long id){
        Fila fila = this.filaService.deleteFilaById(id);
        if(Objects.isNull(fila)){
            throw new FilaException("Task not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.noContent().build();
    }
}
