package com.souza.service;

import org.springframework.stereotype.Service;

import com.souza.dto.EstadoDTO;

@Service
public class HellowordService {
	
	public EstadoDTO printService(Integer codigo) {
		return getEstado(codigo);
	}
	
	
	private EstadoDTO getEstado(Integer codigo) {
		return new EstadoDTO(null, "MG", "Minas Gerais");
	}
}
