package it.molis.istat.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.molis.istat.beans.Comune;
import it.molis.istat.beans.Morto;

public class MortoDAO {
	
	private Connection conn = DBConnect.getConnection();

	public Set<Morto> getAllMorti() {
		Set<Morto> morti = new HashSet<Morto>();

		final String sql = "select classeEta, data, sesso from Morto";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int classeEta = Integer.parseInt(rs.getString("classeEta"));
				LocalDate data = rs.getDate("data").toLocalDate();
				String sesso = rs.getString("sesso");

				Morto m = new Morto(classeEta, data, sesso);

				morti.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new RuntimeException("Errore di connessione al Database.");
			return new HashSet<Morto>();
		}
		return morti;
	}
	
	public void addMorti(Comune comune, List<Morto> morti) {
		final String sql = "INSERT INTO Morto(classeEta, data, sesso, nomeComune) " + "VALUES (?, ?, ?, ?)";

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (Morto m : morti) {
			try {
				st.setInt(1, m.getClasseEta());

				String data = "" + m.getData().getYear() + "-" + m.getData().getMonthValue() + "-"
						+ m.getData().getDayOfMonth();

				st.setDate(2, Date.valueOf(data));
				st.setString(3, m.getSesso());
				st.setString(4, comune.getNomeComune());

				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Errore di connessione al Database.");
			}
		}
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
