package backend.dao;

import java.util.List;

import backend.bean.Kysely;

public interface KyselyDAOInterface {

	public List<Kysely> haeKaikki();

	public Kysely etsi(int id);

	public void poista(int id);

	public void luoUusi(Kysely kysely);
}
