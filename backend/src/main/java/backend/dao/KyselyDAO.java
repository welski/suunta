package backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import backend.bean.Kysely;

@Repository
public class KyselyDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Kysely> haeKaikki() {
		String sql = "SELECT id, nimi, kuvaus FROM kysely";
		
		RowMapper<Kysely> mapper = new KyselyRowMapper();
		List<Kysely> kyselyt = jdbcTemplate.query(sql, mapper);
		
		return kyselyt;
	}

	public Kysely etsi(int id) {
		String sql = "SELECT id, nimi, kuvaus FROM kysely WHERE id = ?";
		
		Object[] parametrit = new Object[] { id };
		RowMapper<Kysely> mapper = new KyselyRowMapper();

		Kysely kysely = null;
		
		try {
			kysely = jdbcTemplate.queryForObject(sql, mapper, parametrit);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new RuntimeException(e);
		}
		
		return kysely;
	}

	public void poista(int id) {
		// TODO
		
	}

	public void luoUusi(Kysely kysely) {
		final String sql = "INSERT INTO kysely (nimi, kuvaus) VALUES (?, ?)";
		final String nimi = kysely.getNimi();
		final String kuvaus = kysely.getKuvaus();
		
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
		
		kysely.setId(idHolder.getKey().intValue());
	}

}
