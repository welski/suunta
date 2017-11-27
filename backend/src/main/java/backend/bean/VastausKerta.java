package backend.bean;

import java.util.List;

public class VastausKerta {
	
	private int id;
	private List<Vastaus> vastaukset;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

}
