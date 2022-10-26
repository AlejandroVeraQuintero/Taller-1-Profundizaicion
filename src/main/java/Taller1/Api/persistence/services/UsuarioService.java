package Taller1.Api.persistence.services;


import Taller1.Api.exceptions.UsuarioException;
import Taller1.Api.mapper.UsuarioInDTOToTask;
import Taller1.Api.persistence.entity.Usuario;
import Taller1.Api.persistence.repository.UsuarioRepository;
import Taller1.Api.persistence.services.dto.UsuarioInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioInDTOToTask usuarioInDTOToTask;

    public Usuario createUsuario(UsuarioInDTO usuarioInDTO){
        Usuario usuario = usuarioInDTOToTask.map(usuarioInDTO);
        ValidarUsuario(usuario);
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return this.usuarioRepository.findAll();
    }

    public Usuario findById(long id) { return this.usuarioRepository.findById(id).orElse(null); }

    @Transactional
    public Usuario ActivateUser(Long usuarioId){
        Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioId);
        if(usuario.isEmpty()){
            return null;
        }
        this.usuarioRepository.ActivateUser(usuarioId);
        return usuario.orElse(null);
    }

    @Transactional
    public Usuario deleteUsuarioById(Long id){
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            return null;
        }
        this.usuarioRepository.deleteById(id);
        return usuario.orElse(null);
    }

    private void ValidarUsuario(Usuario usuario){
        ValidarEdad(usuario.getFechaNacimiento());
    }

    private void  ValidarEdad(Date fechaNacimiento){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = formatter.format(fechaNacimiento);

        LocalDate fechaNac = LocalDate.parse(fechaTexto, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

        if (periodo.getYears() <= 18){
            throw new UsuarioException("El usuario no puede ser registrado por ser menor de edad", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
