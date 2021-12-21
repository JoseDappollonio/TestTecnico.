package prueba.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import prueba.Modelo.Phones;
import prueba.Modelo.Usuario;
import prueba.Repository.UsuarioRepository;
import prueba.utils.utils;

@SpringBootApplication
@ComponentScan("module-service")
public class UsuarioService {
	utils utl = new utils();

	@Autowired
	UsuarioRepository usuario;


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

			List<Phones> data= user.getPhones();
			Usuario usuario1 = new Usuario();
			usuario1.setFechaIngreso(utl.fechadeldia());
			usuario1.setFechaModificacion(utl.fechadeldia());
			usuario1.setUltimaConexion(utl.fechadeldia());
			usuario1.setIsactive(true);
			usuario1.setName(user.getName());			
			usuario1.setEmail(user.getEmail());
			usuario1.setPassword(user.getPassword());			
			usuario1.setPhones(data);
			usuario.save(usuario1);
			

			Usuario response = usuario.findByemail(user.getEmail());
			respuesta.put("usuario", response.getEmail());
			respuesta.put("id", "" + response.getUsuario_Id());
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
	
	public List<Usuario> selectAll() {	
		List <Usuario> response =usuario.findAll();			
		return response;
	}
	
	public Object SelectForEmail(Usuario user) {
		HashMap<String, String> response = new HashMap<>();
		try {
			if (user.getEmail() == null || user.getEmail() == "") {
				response.put("Mensaje", "Ingrese Mail para la busqueda");
				return response;
			} else {
				Usuario rpta = usuario.findByemail(user.getEmail());
				if (rpta.getEmail() == null) {
					response.put("Mensaje", "No existe Mail en DB");
					return response;
				} else {
					return rpta;
				}
				
			}		
		} catch (Exception e) {
			response.put("Mensaje", "No existe Mail en DB");
			
		}
		return response;
	}
		
		
		
	}



