package Taller1.Api.controller;

import Taller1.Api.exceptions.UsuarioException;
import Taller1.Api.mapper.UsuarioConListFilaInDTOToTask;
import Taller1.Api.mapper.UsuarioInDTOToTask;
import Taller1.Api.persistence.entity.Usuario;
import Taller1.Api.persistence.services.UsuarioService;
import Taller1.Api.persistence.services.dto.UsuarioConListFilaInDTO;
import Taller1.Api.persistence.services.dto.UsuarioInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioConListFilaInDTOToTask usuarioConListaInDTOToTask;


    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioInDTO usuarioInDTO){
        usuarioService.createUsuario(usuarioInDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<UsuarioConListFilaInDTO> findAll(){

        return usuarioService.findAll().stream().map(usuario -> usuarioConListaInDTOToTask.map(usuario)).collect(Collectors.toList());
    }


    @PatchMapping("/Activate/{id}")
    public ResponseEntity<?>  ActivateUser(@PathVariable("id") Long id){
        Usuario task = this.usuarioService.ActivateUser(id);
        if(Objects.isNull(task)){
            throw new UsuarioException("Task not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuarioById(@PathVariable("id") Long id){
        Usuario usuario = this.usuarioService.deleteUsuarioById(id);
        if(Objects.isNull(usuario)){
            throw new UsuarioException("Task not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.noContent().build();
    }

}
