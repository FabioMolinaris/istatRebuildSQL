package it.molis.istat.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Set;

import it.molis.istat.beans.Comune;
import it.molis.istat.beans.Morto;

public class CsvWriter {

	public void writeYearRegioni(Set<Comune> comuni, Set<String> regioni) {

		try (PrintWriter writer = new PrintWriter(new File("/home/fabio/Downloads/Regioni_annuale.csv"))) {
			StringBuilder sb = new StringBuilder();

			sb.append("Regione,");
			for (int i = 2015; i < 2021; i++)
				sb.append(i + ",");
			sb.append('\n');
			
			for(String regione : regioni) {
				sb.append(regione + ",");
				for (int i = 2015; i < 2021; i++)
					sb.append(doStatsYearRegioni(comuni, regione, i) + ",");
				sb.append('\n');
			}
			
			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void writeMonthRegioni(Set<Comune> comuni, Set<String> regioni) {

		try (PrintWriter writer = new PrintWriter(new File("/home/fabio/Downloads/Regioni_mensile.csv"))) {
			StringBuilder sb = new StringBuilder();

			sb.append("Regione,");
			for (int i = 2015; i < 2021; i++)
				for (int j = 1; j < 5; j++)
					sb.append(i + "-" + j + ",");
			sb.append('\n');
			
			for(String regione : regioni) {
				sb.append(regione + ",");
				for (int i = 2015; i < 2021; i++)
					for (int j = 1; j < 5; j++)
						sb.append(doStatsMonthRegioni(comuni, regione, i, j) + ",");
				sb.append('\n');
			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void writeWeekRegioni(Set<Comune> comuni, Set<String> regioni) {

		try (PrintWriter writer = new PrintWriter(new File("/home/fabio/Downloads/Regioni_settimanale.csv"))) {
			StringBuilder sb = new StringBuilder();

			sb.append("Regione,");
			for (int i = 2015; i < 2021; i++)
				for (int j = 1; j < 19; j++)
					sb.append(i + "-" + j + ",");
			sb.append('\n');
			
			for(String regione : regioni) {
				sb.append(regione + ",");
				for (int i = 2015; i < 2021; i++)
					for (int j = 1; j < 19; j++)
						sb.append(doStatsWeekRegioni(comuni, regione, i, j) + ",");
				sb.append('\n');
			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public int doStatsYearRegioni(Set<Comune> comuni, String regione, int anno) {
		int numeroMorti = 0;
		for (Comune c : comuni) {
			if (c.getNomeRegione().contains(regione)) {
				for (Morto m : c.getMorti()) {
					if (m.getData().getYear() == anno) {
						numeroMorti++;
					}
				}
			}
		}
		// System.out.println(numeroMorti);
		return numeroMorti;
	}

	public int doStatsMonthRegioni(Set<Comune> comuni, String regione, int anno, int mese) {
		int numeroMorti = 0;
		for (Comune c : comuni) {
			if (c.getNomeRegione().contains(regione)) {
				for (Morto m : c.getMorti()) {
					if (m.getData().getYear() == anno && m.getData().getMonthValue() == mese) {
						numeroMorti++;
					}
				}
			}
		}
		//System.out.println(numeroMorti);
		return numeroMorti;
	}
	
	public int doStatsWeekRegioni(Set<Comune> comuni, String regione, int anno, int settimana) {
		int numeroMorti = 0;
		for (Comune c : comuni) {
			if (c.getNomeRegione().contains(regione)) {
				for (Morto m : c.getMorti()) {
					int weekNumber = m.getData().get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
					if (m.getData().getYear() == anno && weekNumber == settimana) {
						numeroMorti++;
					}
				}
			}
		}
		//System.out.println(numeroMorti);
		return numeroMorti;
	}
	
	public void writeYearProvincie(Set<Comune> comuni, Set<String> provincie) {

		try (PrintWriter writer = new PrintWriter(new File("/home/fabio/Downloads/Provincie_annuale.csv"))) {
			StringBuilder sb = new StringBuilder();

			sb.append("Provincia,");
			for (int i = 2015; i < 2021; i++)
				sb.append(i + ",");
			sb.append('\n');
			
			for(String provincia : provincie) {
				sb.append(provincia + ",");
				for (int i = 2015; i < 2021; i++)
					sb.append(doStatsYearProvincie(comuni, provincia, i) + ",");
				sb.append('\n');
			}
			
			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void writeMonthProvincie(Set<Comune> comuni, Set<String> provincie) {

		try (PrintWriter writer = new PrintWriter(new File("/home/fabio/Downloads/Provincie_mensile.csv"))) {
			StringBuilder sb = new StringBuilder();

			sb.append("Provincia,");
			for (int i = 2015; i < 2021; i++)
				for (int j = 1; j < 5; j++)
					sb.append(i + "-" + j + ",");
			sb.append('\n');
			
			for(String provincia : provincie) {
				sb.append(provincia + ",");
				for (int i = 2015; i < 2021; i++)
					for (int j = 1; j < 5; j++)
						sb.append(doStatsMonthProvincie(comuni, provincia, i, j) + ",");
				sb.append('\n');
			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void writeWeekProvincie(Set<Comune> comuni, Set<String> provincie) {

		try (PrintWriter writer = new PrintWriter(new File("/home/fabio/Downloads/Provincie_settimanale.csv"))) {
			StringBuilder sb = new StringBuilder();

			sb.append("Provincia,");
			for (int i = 2015; i < 2021; i++)
				for (int j = 1; j < 19; j++)
					sb.append(i + "-" + j + ",");
			sb.append('\n');
			
			for(String provincia : provincie) {
				sb.append(provincia + ",");
				for (int i = 2015; i < 2021; i++)
					for (int j = 1; j < 19; j++)
						sb.append(doStatsWeekProvincie(comuni, provincia, i, j) + ",");
				sb.append('\n');
			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int doStatsYearProvincie(Set<Comune> comuni, String provincia, int anno) {
		int numeroMorti = 0;
		for (Comune c : comuni) {
			if (c.getNomeProvincia().contains(provincia)) {
				for (Morto m : c.getMorti()) {
					if (m.getData().getYear() == anno) {
						numeroMorti++;
					}
				}
			}
		}
		// System.out.println(numeroMorti);
		return numeroMorti;
	}

	public int doStatsMonthProvincie(Set<Comune> comuni, String provincia, int anno, int mese) {
		int numeroMorti = 0;
		for (Comune c : comuni) {
			if (c.getNomeProvincia().contains(provincia)) {
				for (Morto m : c.getMorti()) {
					if (m.getData().getYear() == anno && m.getData().getMonthValue() == mese) {
						numeroMorti++;
					}
				}
			}
		}
		//System.out.println(numeroMorti);
		return numeroMorti;
	}
	
	public int doStatsWeekProvincie(Set<Comune> comuni, String provincia, int anno, int settimana) {
		int numeroMorti = 0;
		for (Comune c : comuni) {
			if (c.getNomeProvincia().contains(provincia)) {
				for (Morto m : c.getMorti()) {
					int weekNumber = m.getData().get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
					if (m.getData().getYear() == anno && weekNumber == settimana) {
						numeroMorti++;
					}
				}
			}
		}
		//System.out.println(numeroMorti);
		return numeroMorti;
	}
}
