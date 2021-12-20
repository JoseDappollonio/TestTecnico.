package prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prueba.Modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
Usuario findByemail(String email);
}
