package com.torneioapi.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Long codigo;
	private String codigoText;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;		
	}
	
	public RecursoCriadoEvent(Object source, HttpServletResponse response, String codigo) {
		super(source);
		this.response = response;
		this.codigoText = codigo;	
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public String getCodigoText() {
		return codigoText;
	}
	

}

