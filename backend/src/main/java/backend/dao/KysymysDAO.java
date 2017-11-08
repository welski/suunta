package backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import backend.bean.Kysymys;

@Repository
public class KysymysDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Tämä ei ole hyvä -> muutetaan maanantaina -Mikko
	public List<Kysymys> haeKaikki(int id) {
		String sql = "SELECT k.id, k.teksti, k.monivalinta, v.id AS vai_id, v.teksti AS vai_teksti, v.kysymys_id FROM kysymys AS k, vaihtoehto AS v WHERE k.id = ? AND v.kysymys_id = k.id";
		Object[] parametrit = new Object[] { id };
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		List<Kysymys> kysymykset = jdbcTemplate.query(sql, parametrit, mapper);
		
		return kysymykset;
	}

	public Kysymys etsi(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void poista(int id) {
		// TODO Auto-generated method stub
		
	}

	public void luoUusi(Kysymys kysymys) {
		final String sql = "INSERT INTO kysymys (nimi, kuvaus, kysely_id) VALUES (?, ?)";
		final String nimi = kysymys.getNimi();
		final String kuvaus = kysymys.getKuvaus();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement preSta = connection.prepareStatement(sql, new String[] { "nimi", "kuvaus" });
				preSta.setString(1, nimi);
				preSta.setString(2, kuvaus);
				return preSta;
			}
		}, idHolder);
		
		kysymys.setId(idHolder.getKey().intValue());
	}

}
