package backend.bean;

import java.util.ArrayList;

import backend.bean.Kysymys;

public class KysymysMonivalinta implements Kysymys {

	private int id;
	private String teksti;
	private boolean monivalinta;
	private ArrayList<Vaihtoehto> vaihtoehdot = new ArrayList<Vaihtoehto>();
	
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
	public ArrayList<Vaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}
	public void setVaihtoehdot(ArrayList<Vaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}
}