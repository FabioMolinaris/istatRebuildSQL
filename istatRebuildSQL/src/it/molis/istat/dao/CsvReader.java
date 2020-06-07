package it.molis.istat.dao;

import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import it.molis.istat.beans.Comune;
import it.molis.istat.beans.Morto;

public class CsvReader {

	public Set<Comune> readCsv() {
		Set<Comune> comuni = new HashSet<Comune>();
		String line = "";
		String splitBy = ",";
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(
					"/home/fabio/Downloads/Dataset-decessi-comunali-giornalieri-e-tracciato-record-4giugno/comuni_giornaliero-decessi.csv"));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] riga = line.split(splitBy); // use comma as separator

				// salto se prima linea
				if (riga[0].equals("REG"))
					continue;

				int regione, provincia, codProvCom, tipoComune;
				String nomeRegione, nomeProvincia, nomeComune;
				int clEta, giorno, mese;
				int nm15 = 0, nm16 = 0, nm17 = 0, nm18 = 0, nm19 = 0, nm20 = 0;
				int nf15 = 0, nf16 = 0, nf17 = 0, nf18 = 0, nf19 = 0, nf20 = 0;
				try {
					regione = Integer.parseInt(riga[0]);
					provincia = Integer.parseInt(riga[1]);
					codProvCom = Integer.parseInt(riga[5]);
					tipoComune = Integer.parseInt(riga[6]);
					clEta = Integer.parseInt(riga[7]);
					giorno = Integer.parseInt("" + riga[8].charAt(2) + riga[8].charAt(3));
					mese = Integer.parseInt("" + riga[8].charAt(0) + riga[8].charAt(1));

					if (!riga[9].equals("n.d."))
						nm15 = Integer.parseInt(riga[9]);
					if (!riga[10].equals("n.d."))
						nm16 = Integer.parseInt(riga[10]);
					if (!riga[11].equals("n.d."))
						nm17 = Integer.parseInt(riga[11]);
					if (!riga[12].equals("n.d."))
						nm18 = Integer.parseInt(riga[12]);
					if (!riga[13].equals("n.d."))
						nm19 = Integer.parseInt(riga[13]);
					if (!riga[14].equals("n.d."))
						nm20 = Integer.parseInt(riga[14]);
					if (!riga[15].equals("n.d."))
						nf15 = Integer.parseInt(riga[15]);
					if (!riga[16].equals("n.d."))
						nf16 = Integer.parseInt(riga[16]);
					if (!riga[17].equals("n.d."))
						nf17 = Integer.parseInt(riga[17]);
					if (!riga[18].equals("n.d."))
						nf18 = Integer.parseInt(riga[18]);
					;
					if (!riga[18].equals("n.d."))
						nf19 = Integer.parseInt(riga[19]);
					if (!riga[20].equals("n.d."))
						nf20 = Integer.parseInt(riga[20]);

				} catch (NumberFormatException e) {
					regione = 0;
					provincia = 0;
					codProvCom = 0;
					tipoComune = 0;
					clEta = 0;
					giorno = 0;
					mese = 0;
				}
				nomeRegione = riga[2];
				nomeProvincia = riga[3];
				nomeComune = riga[4];
				// int regione, int provincia, String nomeRegione, String nomeProvincia, String
				// nomeComune,int codProvCom, int tipoComune
				Comune c = new Comune(regione, provincia, nomeRegione, nomeProvincia, nomeComune, codProvCom,
						tipoComune);

				if (!comuni.contains(c))
					comuni.add(c);

				for (Comune com : comuni)
					if (com.equals(c))
						c = com;

				for (int i = 0; i < nm15; i++) {
					LocalDate d = LocalDate.of(2015, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "uomo");
					c.getMorti().add(m);
				}
				for (int i = 0; i < nm16; i++) {
					LocalDate d = LocalDate.of(2016, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "uomo");
					c.addMorto(m);
				}
				for (int i = 0; i < nm17; i++) {
					LocalDate d = LocalDate.of(2017, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "uomo");
					c.addMorto(m);
				}
				for (int i = 0; i < nm18; i++) {
					LocalDate d = LocalDate.of(2018, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "uomo");
					c.addMorto(m);
				}
				for (int i = 0; i < nm19; i++) {
					LocalDate d = LocalDate.of(2019, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "uomo");
					c.addMorto(m);
				}
				for (int i = 0; i < nm20; i++) {
					LocalDate d = LocalDate.of(2020, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "uomo");
					c.addMorto(m);
				}
				for (int i = 0; i < nf15; i++) {
					LocalDate d = LocalDate.of(2015, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "donna");
					c.addMorto(m);
				}
				for (int i = 0; i < nf16; i++) {
					LocalDate d = LocalDate.of(2016, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "donna");
					c.addMorto(m);
				}
				for (int i = 0; i < nf17; i++) {
					LocalDate d = LocalDate.of(2017, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "donna");
					c.addMorto(m);
				}
				for (int i = 0; i < nf18; i++) {
					LocalDate d = LocalDate.of(2018, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "donna");
					c.addMorto(m);
				}
				for (int i = 0; i < nf19; i++) {
					LocalDate d = LocalDate.of(2019, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "donna");
					c.addMorto(m);
				}
				for (int i = 0; i < nf20; i++) {
					LocalDate d = LocalDate.of(2020, mese, giorno);
					// int classeEta, LocalDate data, String sesso
					Morto m = new Morto(clEta, d, "donna");
					c.addMorto(m);
				}

			}
			br.close();
			System.out.println("distinti comuni " + comuni.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comuni;
	}
}
