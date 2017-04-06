package com.wasc.myproject.model;

public enum SeletorMotorista {
	
	CLAUDIO("Claudio"),
	JOAO("Joao");
	
	private String motorista;
	
	SeletorMotorista(String motorista){
		this.motorista = motorista;
	}
	public String getMotorista(){
		return motorista;
	}
}
