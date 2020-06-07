package it.molis.istat.model;

import java.util.HashSet;
import java.util.Set;

import it.molis.istat.beans.Comune;
import it.molis.istat.dao.ComuneDAO;
import it.molis.istat.dao.CsvReader;
import it.molis.istat.dao.CsvWriter;
import it.molis.istat.dao.MortoDAO;

public class Model {
	
	private Set<Comune> comuni = new HashSet<Comune>();
	private Set<String> regioni = new HashSet<String>();
	private Set<String> provincie = new HashSet<String>();
	
	private ComuneDAO comuneDAO = new ComuneDAO();
	private MortoDAO mortoDAO = new MortoDAO();
	
	public void run() {
		readCsv();
		//writeCsv();
		addComuniToDB(comuni);
		System.out.println(getAllComuni().size());
		for(Comune c : comuni)
			addMortiComuneToDB(c);
	}
	
	public void readCsv() {
		CsvReader csvReader = new CsvReader();
		comuni.addAll(csvReader.readCsv());
		regioni.addAll(getRegioni());
		provincie.addAll(getProvincie());
	}
	
	private Set<String>  getRegioni() {
		Set<String> regioni = new HashSet<String>();
		for (Comune c : comuni)
			if (!regioni.contains(c.getNomeRegione()))
				regioni.add(c.getNomeRegione());
		return regioni;
	}
	
	private Set<String> getProvincie() {
		Set<String> provincie = new HashSet<String>();
		for (Comune c : comuni)
			if (!provincie.contains(c.getNomeProvincia()))
				provincie.add(c.getNomeProvincia());
		return provincie;
	}
	
	public void writeCsv() {
		CsvWriter csvWriter = new CsvWriter();
		csvWriter.writeYearRegioni(comuni, regioni);
		csvWriter.writeMonthRegioni(comuni, regioni);
		csvWriter.writeWeekRegioni(comuni, regioni);
		csvWriter.writeYearProvincie(comuni, provincie);
		csvWriter.writeMonthProvincie(comuni, provincie);
		csvWriter.writeWeekProvincie(comuni, provincie);
	}
	
	public void addComuniToDB(Set<Comune> comuni) {
		comuneDAO.addComuni(comuni);
	}
	
	private Set<Comune> getAllComuni(){
		return comuneDAO.getAllComuni();
	}
	
	public void addMortiComuneToDB(Comune comune) {
		mortoDAO.addMorti(comune, comune.getMorti());
	}
}
