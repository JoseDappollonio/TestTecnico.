package prueba.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import prueba.Modelo.Phones;
import prueba.Modelo.Usuario;
import prueba.Repository.PhonesRepository;
import prueba.Repository.UsuarioRepository;
import prueba.utils.utils;

@SpringBootApplication
@ComponentScan("module-service")
public class UsuarioService {
	utils utl = new utils();

	@Autowired
	UsuarioRepository usuario;

	@Autowired
	PhonesRepository phones;

	// Select Inicial
	public HashMap<String, String> Select(Usuario user) {
		HashMap<String, String> respuesta = new HashMap<>();
		try {
			if (registrado(user)) {
				respuesta.put("mensaje", "El correo ya existe");
				return respuesta;

			} else {
				if (utl.ValidarMail(user.getEmail()) && utl.ValidaPass(user.getPassword())) {
					respuesta = insert(user);
					return respuesta;
				} else {
					respuesta.put("mensaje", "Tu correo o contraseña no cumplen los requisitos");
					return respuesta;

				}
			}

		} catch (Exception e) {
			throw e;
		}

	}

	// consulta si está registrado
	public boolean registrado(Usuario user) {
		try {
			String email = user.getEmail();
			Usuario response = usuario.findByemail(email);
			if (response == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// insertar Usuario
	public HashMap<String, String> insert(Usuario user) {
		HashMap<String, String> respuesta = new HashMap<>();
		try {
			user.setFechaIngreso(utl.fechadeldia());
			user.setFechaModificacion(utl.fechadeldia());
			user.setUltimaConexion(utl.fechadeldia());
			user.setIsactive(true);
			usuario.save(user);

			List<Phones> data;
			data = user.getPhones();

			phones.saveAll(data);

			Usuario response = usuario.findByemail(user.getEmail());
			respuesta.put("usuario", response.getEmail());
			respuesta.put("id", "" + response.getId());
			respuesta.put("created", "" + response.getFechaIngreso());
			respuesta.put("modified", "" + response.getFechaModificacion());
			respuesta.put("last_login", "" + response.getUltimaConexion());
			respuesta.put("isactive", "" + response.getIsactive());
			respuesta.put("token", "token");

			return respuesta;
		} catch (Exception e) {
			respuesta.put("mensaje", "Error al realizar el insert");
			return respuesta;
		}

	}



}
