package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import backend.bean.Kysymys;
import backend.bean.KysymysTeksti;

public class KysymysRowMapper implements RowMapper<Kysymys> {
	
	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Oletuksena kysymys on avoin tekstikysymys
		boolean monivalinta = false;
		
		// Tutkitaan, onko kyseessä monivalintakysymys
		try {
			monivalinta = rs.getBoolean("monivalinta");
		} catch (SQLException e) {
			throw new Exception(e);
		}
		
		// Haetaan kysymyksen perustiedot
		int id = rs.getInt("id");
		String teksti = rs.getString("teksti");
		
		// Jos kyseessä ei ole monivalinta, luodaan ja palautetaan kysymys		
		if (!monivalinta) {
			KysymysTeksti kysymys = new KysymysTeksti();
			kysymys.setId(id);
			kysymys.setTeksti(teksti);
			
			return kysymys;
		} else {
			
		}
		
				return k;
	}

}