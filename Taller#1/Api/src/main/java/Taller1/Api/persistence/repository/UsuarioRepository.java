package Taller1.Api.persistence.repository;

import Taller1.Api.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    @Modifying
    @Query(value = "UPDATE USUARIOS SET activo=TRUE WHERE ID=:id",nativeQuery = true)
    void ActivateUser(@Param("id") long id);

}
