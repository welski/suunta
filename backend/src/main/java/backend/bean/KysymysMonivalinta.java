package backend.bean;

import java.util.ArrayList;
import java.util.List;

public class KysymysMonivalinta implements Kysymys {

	private int id;
	private String teksti;
	private boolean monivalinta;
	private List<Vaihtoehto> vaihtoehdot = new ArrayList<Vaihtoehto>();
	
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
	public boolean isMonivalinta() {
		return monivalinta;
	}
	public void setMonivalinta(boolean monivalinta) {
		this.monivalinta = monivalinta;
	}
	public List<Vaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}
	public void setVaihtoehdot(List<Vaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}
}