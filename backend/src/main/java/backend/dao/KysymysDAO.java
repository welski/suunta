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
import backend.bean.KysymysMonivalinta;
import backend.bean.KysymysTeksti;
import backend.bean.Vaihtoehto;

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

	public void luoUusiTekstikysymys(KysymysTeksti kysymys, int kyselyId) {
		final String sql = "INSERT INTO kysymys (teksti, monivalinta, kysely_id) VALUES (?, ?, ?)";
		final String teksti = kysymys.getTeksti();
		final boolean monivalinta = false;
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement preSta = connection.prepareStatement(sql, new String[] { "teksti", "monivalinta", "kysely_id" });
				preSta.setString(1, teksti);
				preSta.setBoolean(2, monivalinta);
				preSta.setInt(3, kyselyId);
				return preSta;
			}
		}, idHolder);
		
		kysymys.setId(idHolder.getKey().intValue());
	}
	
	public void luoUusiMonivalintaKysymys(VaihtoehtoDAO vdao, KysymysMonivalinta kysymys, int kysymysId, List<Vaihtoehto> vaihtoehdot) {
		final String sql = "INSERT INTO kysymys (teksti, monivalinta, kysely_id) VALUES (?, ?, ?)";
		final String teksti = kysymys.getTeksti();
		final boolean monivalinta = true;
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement preSta = connection.prepareStatement(sql, new String[] { "teksti", "monivalinta", "kysely_id" });
				preSta.setString(1, teksti);
				preSta.setBoolean(2, monivalinta);
				preSta.setInt(3, kysymysId);
				return preSta;
			}
		}, idHolder);

		// Tätä ei hyödynnetä toistaikseksi
		// kysymys.setId(idHolder.getKey().intValue());
		
		for (Vaihtoehto vaihtoehto : vaihtoehdot) {
			vdao.luoUusi(jdbcTemplate, vaihtoehto, kysymysId);
		}
		
	}
}
