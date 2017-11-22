package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import backend.bean.Kysymys;
import backend.bean.KysymysMonivalinta;
import backend.bean.KysymysTeksti;

public class KysymysRowMapper implements RowMapper<Kysymys> {
	
	private VaihtoehtoDAO vdao;
	
	public KysymysRowMapper(VaihtoehtoDAO vdao) {
		this.vdao = vdao;
	}

	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Oletuksena kysymys on avoin tekstikysymys
		boolean monivalinta = false;

		// Haetaan kysymyksen perustiedot
		int id = rs.getInt("id");
		String teksti = rs.getString("teksti");
		
		// Tutkitaan, onko kyseessä monivalintakysymys
		try {
			if (vdao.haeKaikki(id) != null) {
				// Kysymys sisältää monta vastausvaihtoehtoa
				
				// Jos false -> radiobuttonit, jos true -> checkboxit
				monivalinta = rs.getBoolean("monivalinta");
				
				// Kyseessä monivalinta, haetaan vaihtoehdot listaan
				KysymysMonivalinta kysymys = new KysymysMonivalinta();
				kysymys.setId(id);
				kysymys.setTeksti(teksti);
				kysymys.setMonivalinta(monivalinta);
				
				kysymys.setVaihtoehdot(vdao.haeKaikki(id));
				
				return kysymys;
				
			} else {
				// Jos kyseessä ei ole monivalinta, luodaan ja palautetaan kysymys
				KysymysTeksti kysymys = new KysymysTeksti();
				kysymys.setId(id);
				kysymys.setTeksti(teksti);
				
				return kysymys;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}