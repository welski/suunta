package backend.bean;

import backend.bean.KyselyInterface;

public class Kysely implements KyselyInterface {

	private int id;
	private String nimi;
	private String kuvaus;
	
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
	
	@Override
	public String toString() {
		return "KyselyImpl [id=" + id + ", nimi=" + nimi + ", kuvaus="
				+ kuvaus + "]";
	}
	
	
}
