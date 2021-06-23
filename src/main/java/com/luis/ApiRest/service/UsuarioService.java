package com.luis.ApiRest.service;

import java.util.List;
import java.util.Optional;
import com.luis.ApiRest.entity.Usuario;



public interface UsuarioService {
	
	public abstract List<Usuario> listAllUsuarios();
	
	public abstract Usuario addUsuario( Usuario usuario);
	
	public abstract int removeUsuario(long id);
	
	public abstract Usuario updateUsuario(Usuario usuario);
	
	public abstract Optional<Usuario> updateNombreById(long id, String nombre);
	
	public abstract Optional<Usuario> findUsuario(long id);
}
