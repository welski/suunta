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

import backend.bean.KysymysTeksti;
import backend.bean.Vastaus;

@Repository
public class VastausDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Palauttaa kaikki vastaukset yhteen kysymykseen
	public List<Vastaus> haeKaikki(int kysymysId) {
		String sql = "SELECT id, teksti FROM vastaus WHERE kysymys_id = ?";
		
		Object[] parametrit = new Object[] { kysymysId };
		RowMapper<Vastaus> mapper = new VastausRowMapper();
		List<Vastaus> vastaukset = jdbcTemplate.query(sql, parametrit, mapper);
		
		return vastaukset;
	}
	
	// Tallentaan yhden Vastaus-objektin tietokantaan
	public void luoUusi(Vastaus vastaus) {
		final String sql = "INSERT INTO vastaus (teksti, kysymys_id) VALUES (?, ?)";
		final String teksti = vastaus.getTeksti();
		final int kysymysId = vastaus.getKysymysId();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement preSta = connection.prepareStatement(sql, new String[] { "teksti", "kysymys_id" });
				preSta.setString(1, teksti);
				preSta.setInt(2, kysymysId);
				return preSta;
			}
		}, idHolder);
		
		vastaus.setId(idHolder.getKey().intValue());
	}

}
