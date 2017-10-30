package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import backend.bean.Kysely;

public class KyselyRowMapper implements RowMapper<Kysely> {
	
	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysely k = new Kysely();
		k.setId(rs.getInt("id"));
		k.setNimi(rs.getString("nimi"));
		k.setKuvaus(rs.getString("kuvaus"));
		
		return k;
	}

}