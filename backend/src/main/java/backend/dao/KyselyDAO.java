package backend.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import backend.bean.Kysely;

@Repository
public class KyselyDAO implements KyselyDAOInterface {
	
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
		// TODO Auto-generated method stub
		return null;
	}

	public void poista(int id) {
		// TODO Auto-generated method stub
		
	}

	public void luoUusi(Kysely kysely) {
		// TODO Auto-generated method stub
		
	}

}
