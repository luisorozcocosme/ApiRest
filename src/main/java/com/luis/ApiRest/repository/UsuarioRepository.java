package com.luis.ApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luis.ApiRest.entity.Usuario;


@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Transactional
	@Modifying
	@Query("update Usuario u set u.nombre = ?1 where u.id = ?2")
	int updateNombre( String nombre,long id);
}
