package it.molis.istat.beans;

import java.util.ArrayList;
import java.util.List;

public class Comune {
	private int regione;
	private int provincia;
	private String nomeRegione;
	private String nomeProvincia;
	private String nomeComune;
	private int codProvCom;
	private int tipoComune;
	private List<Morto> morti = new ArrayList<Morto>();
	
	public Comune(int regione, int provincia, String nomeRegione, String nomeProvincia, String nomeComune,
			int codProvCom, int tipoComune) {
		super();
		this.regione = regione;
		this.provincia = provincia;
		this.nomeRegione = nomeRegione;
		this.nomeProvincia = nomeProvincia;
		this.nomeComune = nomeComune;
		this.codProvCom = codProvCom;
		this.tipoComune = tipoComune;
	}

	public int getRegione() {
		return regione;
	}

	public void setRegione(int regione) {
		this.regione = regione;
	}

	public int getProvincia() {
		return provincia;
	}

	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}

	public String getNomeRegione() {
		return nomeRegione;
	}

	public void setNomeRegione(String nomeRegione) {
		this.nomeRegione = nomeRegione;
	}

	public String getNomeProvincia() {
		return nomeProvincia;
	}

	public void setNomeProvincia(String nomeProvincia) {
		this.nomeProvincia = nomeProvincia;
	}

	public String getNomeComune() {
		return nomeComune;
	}

	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}

	public int getCodProvCom() {
		return codProvCom;
	}

	public void setCodProvCom(int codProvCom) {
		this.codProvCom = codProvCom;
	}

	public int getTipoComune() {
		return tipoComune;
	}

	public void setTipoComune(int tipoComune) {
		this.tipoComune = tipoComune;
	}

	public List<Morto> getMorti() {
		return morti;
	}

	public void setMorti(List<Morto> morti) {
		this.morti = morti;
	}

	public void addMorto(Morto m) {
		this.morti.add(m);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeComune == null) ? 0 : nomeComune.hashCode());
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
		Comune other = (Comune) obj;
		if (nomeComune == null) {
			if (other.nomeComune != null)
				return false;
		} else if (!nomeComune.equals(other.nomeComune))
			return false;
		return true;
	}
		
}
