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

	public List<Kysymys> haeKaikki(VaihtoehtoDAO vdao, int id) {
		String sql = "SELECT id, teksti, monivalinta FROM kysymys WHERE kysely_id = ?";
		
		Object[] parametrit = new Object[] { id };
		RowMapper<Kysymys> mapper = new KysymysRowMapper(vdao);
		List<Kysymys> kysymykset = jdbcTemplate.query(sql, parametrit, mapper);
		
		return kysymykset;
	}

	public Kysymys etsi(VaihtoehtoDAO vdao, int id) {
		String sql = "SELECT id, teksti, monivalinta FROM kysymys WHERE id = ?";
		
		Object[] parametrit = new Object[] { id };
		RowMapper<Kysymys> mapper = new KysymysRowMapper(vdao);

		Kysymys kysymys = null;
		
		try {
			kysymys = jdbcTemplate.queryForObject(sql, mapper, parametrit);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new RuntimeException(e);
		}
		
		return kysymys;
	}

	public void poista(int id) {
		final String sql = "DELETE FROM kysymys WHERE id = ?";
				
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement preSta = connection.prepareStatement(sql, new String[] { "id" });
					preSta.setInt(1, id);
					return preSta;
				}
			});
	}
/*
	// TO DO -Mikko 13/11/2017
	public void luoUusi(Kysymys kysymys) {
		
		final String sql = "INSERT INTO kysymys (teksti, monivalinta, kysely_id) VALUES (?, ?, ?)";
		final String teksti = kysymys.getTeksti();
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
	*/

}
