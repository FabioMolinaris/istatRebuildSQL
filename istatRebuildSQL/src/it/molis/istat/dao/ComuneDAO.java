package it.molis.istat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import it.molis.istat.beans.Comune;

public class ComuneDAO {

	private Connection conn = DBConnect.getConnection();

	public Set<Comune> getAllComuni() {
		Set<Comune> comuni = new HashSet<Comune>();

		final String sql = "select regione, provincia, nomeRegione, nomeProvincia, nomeComune, codProvCom, tipoComune from Comune";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int regione = Integer.parseInt(rs.getString("regione"));
				int provincia = Integer.parseInt(rs.getString("provincia"));
				String nomeRegione = rs.getString("nomeRegione");
				String nomeProvincia = rs.getString("nomeProvincia");
				String nomeComune = rs.getString("nomeComune");
				int codProvCom = Integer.parseInt(rs.getString("codProvCom"));
				int tipoComune = Integer.parseInt(rs.getString("tipoComune"));

				Comune c = new Comune(regione, provincia, nomeRegione, nomeProvincia, nomeComune, codProvCom,
						tipoComune);

				comuni.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new RuntimeException("Errore di connessione al Database.");
			return new HashSet<Comune>();
		}
		return comuni;
	}

	public void addComuni(Set<Comune> comuni) {
		String sql = "INSERT INTO Comune(regione, provincia, nomeRegione, nomeProvincia, nomeComune, codProvCom, tipoComune) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (Comune c : comuni) {
			try {
				st.setInt(1, c.getRegione());
				st.setInt(2, c.getProvincia());
				st.setString(3, c.getNomeRegione());
				st.setString(4, c.getNomeProvincia());
				st.setString(5, c.getNomeComune());
				st.setInt(6, c.getCodProvCom());
				st.setInt(7, c.getTipoComune());

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
