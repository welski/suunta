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

import backend.bean.Vaihtoehto;

@Repository
public class VaihtoehtoDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Vaihtoehto> haeKaikki(int kysymysId) {
		String sql = "SELECT id, teksti FROM vaihtoehto WHERE kysymys_id = ?";
		Object[] parametrit = new Object[] { kysymysId };

		RowMapper<Vaihtoehto> mapper = new VaihtoehtoRowMapper();

		List<Vaihtoehto> vaihtoehdot = jdbcTemplate.query(sql, parametrit, mapper);
		
		return vaihtoehdot;
	}
	
	public void luoUusi(JdbcTemplate jdbcTemp, Vaihtoehto vaihtoehto, int kysymysId) {
		setJdbcTemplate(jdbcTemp);
		final String sql = "INSERT INTO vaihtoehto (teksti, kysymys_id) VALUES (?, ?)";
		final String teksti = vaihtoehto.getTeksti();
		
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
		
		// Tätä ei hyödynnetä toistaikseksi
		// vaihtoehto.setId(idHolder.getKey().intValue());
	}

	
}
