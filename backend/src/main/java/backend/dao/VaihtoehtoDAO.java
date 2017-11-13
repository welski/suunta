package backend.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import backend.bean.Vaihtoehto;

@Repository
public class VaihtoehtoDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public List<Vaihtoehto> haeKaikki(int kysymysId) {
		String sql = "SELECT id, teksti FROM vaihtoehto WHERE kysymys_id = ?";
		Object[] parametrit = new Object[] { kysymysId };

		RowMapper<Vaihtoehto> mapper = new VaihtoehtoRowMapper();

		List<Vaihtoehto> vaihtoehdot = jdbcTemplate.query(sql, parametrit, mapper);
		
		return vaihtoehdot;
	}
}
