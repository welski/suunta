package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import backend.bean.Kysymys;

public class KysymysRowMapper implements RowMapper<Kysymys> {
	
	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysymys k = new Kysymys();
		k.setId(rs.getInt("id"));
		k.setTeksti(rs.getString("teksti"));
		
		return k;
	}

}