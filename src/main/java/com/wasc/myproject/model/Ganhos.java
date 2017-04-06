package com.wasc.myproject.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;




@Entity
public class Ganhos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	private SeletorMotorista motorista;
	
	@NotNull(message = "Valor é obrigatório")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorCorrida;
	
	@NotNull(message = "Data é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dtCorrida;
	
	private Long qtdeKm;
	private String hCorrida;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal dinamico;
	private BigDecimal totalCorrida;
	
	
	public BigDecimal getTotalCorrida() {
		return totalCorrida;
	}
	public void setTotalCorrida(BigDecimal totalCorrida) {
		this.totalCorrida = totalCorrida;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public SeletorMotorista getMotorista() {
		return motorista;
	}
	public void setMotorista(SeletorMotorista motorista) {
		this.motorista = motorista;
	}
	public boolean isClaudio(){
		return SeletorMotorista.CLAUDIO.equals(this.motorista);
	}
	
	public BigDecimal getValorCorrida() {
		return valorCorrida;
	}
	public void setValorCorrida(BigDecimal valorCorrida) {
		this.valorCorrida = valorCorrida;
	}
	public Date getDtCorrida() {
		return dtCorrida;
	}
	public void setDtCorrida(Date dtCorrida) {
		this.dtCorrida = dtCorrida;
	}
	public Long getQtdeKm() {
		return qtdeKm;
	}
	public void setQtdeKm(Long qtdeKm) {
		this.qtdeKm = qtdeKm;
	}
	public String gethCorrida() {
		return hCorrida;
	}
	public void sethCorrida(String hCorrida) {
		this.hCorrida = hCorrida;
	}
	public BigDecimal getDinamico() {
		return dinamico;
	}
	public void setDinamico(BigDecimal dinamico) {
		this.dinamico = dinamico;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ganhos other = (Ganhos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
