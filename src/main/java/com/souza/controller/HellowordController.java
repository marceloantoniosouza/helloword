package com.souza.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souza.dto.EstadoDTO;
import com.souza.responses.Response;
import com.souza.service.HellowordService;


@RestController
@RequestMapping("/api/v1/helloword")
public class HellowordController {
	
	@Autowired
	HellowordService hellowordService;
	
	@GetMapping("/{codigo}")
	public Response<EstadoDTO> acessoService(@PathVariable ("codigo") Integer codigo) {
		Response<EstadoDTO> response = new Response<EstadoDTO>();
		
		response.setData(hellowordService.printService(codigo));
		return response;
	}
	

	@GetMapping("")
	public Response<List<EstadoDTO>> estados() {
		Response<List<EstadoDTO>> response = new Response<List<EstadoDTO>>();
		
		List<EstadoDTO> list = new ArrayList<EstadoDTO>();
		list.add(new EstadoDTO(1, "MG", "Minas Gerais"));
		list.add(new EstadoDTO(2, "SP", "São Paulo"));
		list.add(new EstadoDTO(3, "BA", "Bahia"));
		
		response.setData(list);
		
		return response;
	}
}
