package backend.bean;

import backend.bean.Kysymys;

public class KysymysTeksti implements Kysymys {

	private int id;
	private String teksti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeksti() {
		return teksti;
	}
	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}
}
