package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import backend.bean.Vaihtoehto;

public class VaihtoehtoRowMapper implements RowMapper<Vaihtoehto> {
	
	public Vaihtoehto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vaihtoehto v = new Vaihtoehto();
		v.setId(rs.getInt("id"));
		v.setTeksti(rs.getString("teksti"));
		
		return v;
	}

}
