package com.prueba;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import prueba.Modelo.Usuario;
import prueba.Repository.UsuarioRepository;
import prueba.Service.UsuarioService;

class UsuarioServiceTest {
	
	@InjectMocks
	UsuarioRepository userRepository;
	
	@Mock
	UsuarioService userservice;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testSelect() {
		
		Usuario entity = new Usuario();
		entity.setEmail("grey23@gmail.com");
		entity.setName("nicolas");
		entity.setId(1);
		entity.setIsactive(true);
		when(userRepository.findByemail("grey23@gmail.com")).thenReturn(entity);

	}



}
