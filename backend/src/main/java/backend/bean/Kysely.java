package backend.bean;

import java.util.ArrayList;
import java.util.List;

public class Kysely {

	private int id;
	private String nimi;
	private String kuvaus;
	private List<Kysymys> kysymykset = new ArrayList<Kysymys>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getKuvaus() {
		return kuvaus;
	}
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}
	public boolean add(Kysymys kysymys) {
		return kysymykset.add(kysymys);
	}
	public Kysymys remove(int id) {
		return kysymykset.remove(id);
	}
	
	@Override
	public String toString() {
		return "KyselyImpl [id=" + id + ", nimi=" + nimi + ", kuvaus="
				+ kuvaus + "]";
	}
}
