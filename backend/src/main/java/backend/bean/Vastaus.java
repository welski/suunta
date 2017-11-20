package backend.bean;

public class Vastaus {
	
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
	
	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", teksti=" + teksti;
	}
	
}
