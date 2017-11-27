package backend.bean;

public class Vastaus {
	
	private int id;
	private String teksti;
	private int kysymysId;
	
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
	
	public int getKysymysId() {
		return kysymysId;
	}
	public void setKysymysId(int kysymysId) {
		this.kysymysId = kysymysId;
	}
	
	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", teksti=" + teksti;
	}
	
}
