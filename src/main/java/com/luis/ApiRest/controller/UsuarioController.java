package com.luis.ApiRest.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luis.ApiRest.entity.Usuario;

import com.luis.ApiRest.service.Imp.UsuarioServiceImp;




@Controller
@RequestMapping("usuarios")
public class UsuarioController {
	
	//private static final String COURSES_VIEW = "usuarios";
	
	private static Log LOG = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioServiceImp usuarioService;
	
	@GetMapping // http://localhost:8080/usuarios
	public ResponseEntity< List<Usuario> >mostrarUsuarios() {
		List<Usuario> usuario = usuarioService.listAllUsuarios();
		LOG.info("Call: " + "mostrarUsuarios() " +"in UsuarioController");
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping // http://localhost:8080/usuarios
	public ResponseEntity< Usuario > crearUsuario(@RequestBody Usuario usuario) {
		Usuario newUsuario = usuarioService.addUsuario(usuario);
		LOG.info("Call: " + "crearUsuario() " +"in UsuarioController" );
		return ResponseEntity.ok(newUsuario);
	}
	
	@PutMapping // http://localhost:8080/usuarios
	public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
		Usuario newUsuario = usuarioService.updateUsuario(usuario);
		LOG.info("Call: " + "actualizarUsuario() "+"in UsuarioController");
		return ResponseEntity.ok(newUsuario);	
	}
	
	@DeleteMapping(value="{usuarioId}") // http://localhost:8080/usuarios/{id}
	public ResponseEntity<Void> eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
		usuarioService.removeUsuario(usuarioId);
		LOG.warn("Call: " + "eliminarUsuario() " +"in UsuarioController");
		return ResponseEntity.ok(null);
	}
	
	@PatchMapping(value="{usuarioId}") // http://localhost:8080/usuarios/{id}
	public ResponseEntity<Optional<Usuario>> actualizarNombre( @PathVariable("usuarioId") Long usuarioId, @RequestBody Usuario usuario) {
		Optional<Usuario> newUsuario = usuarioService.updateNombreById(usuarioId, usuario.getNombre());
		LOG.info("Call: " + "actualizarNombre() " +"in UsuarioController");
	    return ResponseEntity.ok(newUsuario);
	}
	
	@RequestMapping(value="{usuarioId}") // http://localhost:8080/usuarios/{id}
	public ResponseEntity<Usuario> mostrarUsuario(@PathVariable("usuarioId") Long usuarioId) {
		Optional<Usuario> usuario = usuarioService.findUsuario(usuarioId);
		LOG.info("Call: " + "mostrarUsuario() " +"in UsuarioController");
		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}else {
			return ResponseEntity.noContent().build();
		}		
	}
	
	
}
