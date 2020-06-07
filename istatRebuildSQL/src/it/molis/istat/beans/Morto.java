package it.molis.istat.beans;

import java.time.LocalDate;

public class Morto {
	private int classeEta;
	private LocalDate data;
	private String sesso;
	
	public Morto(int classeEta, LocalDate data, String sesso) {
		super();
		this.classeEta = classeEta;
		this.data = data;
		this.sesso = sesso;
	}

	public int getClasseEta() {
		return classeEta;
	}

	public void setClasseEta(int classeEta) {
		this.classeEta = classeEta;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	
}
