package com.luis.ApiRest.service.Imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.luis.ApiRest.entity.Usuario;
import com.luis.ApiRest.repository.UsuarioRepository;
import com.luis.ApiRest.service.UsuarioService;

@Service("usuarioServiceImpl")
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	private static Log LOG = LogFactory.getLog(UsuarioServiceImp.class);
	
	@Override
	public List<Usuario> listAllUsuarios() {
		LOG.info("Call: " + "listAllUsuarios() "+" in UsuarioServiceImpl" );
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario addUsuario(Usuario usuario) {
		LOG.info("Call: " + "addUsuario() " +"in UsuarioServiceImpl" );
		return usuarioRepository.save(usuario);
	}

	@Override
	public int removeUsuario(long id) {
		LOG.warn("Call: " + "removeUsuario() " +"in UsuarioServiceImpl");
		usuarioRepository.deleteById(id);
		return 0;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		LOG.info("Call: " + "updateUsuario() "+"in UsuarioServiceImpl" );
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findUsuario(long id) {	
		LOG.info("Call: " + "findUsuario() " +"in UsuarioServiceImpl");
		return usuarioRepository.findById(id);
	}

	@Override
	public Optional<Usuario> updateNombreById(long id, String nombre) {	
		LOG.info("Call: " + "updateNombreById() " +"in UsuarioServiceImpl");
		if (usuarioRepository.updateNombre(nombre, id)>0) {
			return usuarioRepository.findById(id);
		} else {
			return usuarioRepository.findById(id);
		}
		 
	}

	

}
