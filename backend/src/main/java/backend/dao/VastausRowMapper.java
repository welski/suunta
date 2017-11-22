package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import backend.bean.Vastaus;

public class VastausRowMapper implements RowMapper<Vastaus> {
	
	public Vastaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vastaus v = new Vastaus();
		v.setId(rs.getInt("id"));
		v.setTeksti(rs.getString("teksti"));
		
		return v;
	}

}
