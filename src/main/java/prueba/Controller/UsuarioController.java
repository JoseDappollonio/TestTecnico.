package prueba.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prueba.Modelo.Usuario;
import prueba.Service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService userModel;

	@RequestMapping(value = "/ejercicioback", method = RequestMethod.POST)
	public HashMap<String, String> find(@RequestBody Usuario user) {
		HashMap<String, String> rpta = userModel.Select(user);
		return rpta;
	}

	@RequestMapping(value = "/traerDatos", method = RequestMethod.GET)
	public List<Usuario> selectAll() {
		List<Usuario> rpta = userModel.selectAll();
		return rpta;
	}

	@RequestMapping(value = "/traerDatosMail", method = RequestMethod.GET)
	public Object SelectForEmail(@RequestBody Usuario user) {
		Object response = userModel.SelectForEmail(user);
		return response;
	}

}
