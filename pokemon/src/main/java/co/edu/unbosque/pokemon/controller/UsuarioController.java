package co.edu.unbosque.pokemon.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.pokemon.dto.UsuarioDTO;
import co.edu.unbosque.pokemon.service.UsuarioService;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(path = { "/usuario" })
public class UsuarioController {
	@Autowired
	private UsuarioService userSer;

	@PostMapping(path = "/crear")
	public ResponseEntity<String> crear(@RequestParam String correo, String nombre, String contrasenia,
			Date fechaNacimiento) {
		UsuarioDTO newUser = new UsuarioDTO(correo, nombre, contrasenia, fechaNacimiento);
		int status = userSer.create(newUser);
		if (status == 0) {
			return new ResponseEntity<>("Usuario creado con éxito", HttpStatus.CREATED);
		} else if (status == 1) {
			return new ResponseEntity<String>("Usuario ya existente, por favor ingrese otro nombre",
					HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<String>("Error al crear el Usuario", HttpStatus.NOT_ACCEPTABLE);

		}

	}

}
