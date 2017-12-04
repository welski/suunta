package backend.controller;

import java.util.*;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.bean.Kysymys;
import backend.bean.Vastaus;
import backend.dao.KysymysDAO;
import backend.dao.VaihtoehtoDAO;
import backend.dao.VastausDAO;

@Controller
public class VastausController {
	
	@Inject
	VastausDAO dao;
	
	@Inject
	KysymysDAO kdao;
	
	@Inject
	VaihtoehtoDAO vdao;
	
	// REST, JSON-muotoisten vastausten tallentaminen yhdestä kysymyksestä
	@RequestMapping(value = "kyselyt/{kyselyId}/vastaukset", method = RequestMethod.POST)
	public @ResponseBody List<Vastaus> luoVastaukset(@PathVariable int kyselyId, @RequestBody List<Vastaus> vastaukset) {
		
		for (Vastaus v : vastaukset) {
			dao.luoUusi(v);
		}
		
		return vastaukset;
	}
	
	//REST, JSON-muodossa vastausten lähettmäminen kaikista kysymyksistä
	@RequestMapping(value = "kyselyt/{kyselyId}/kysymykset/{kysymysId}", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> haeVastauksetJSON(@PathVariable int kyselyId, int kysymysId) {
		
		List<Vastaus> kysymyksenVastaukset = dao.haeKaikki(kysymysId);
		
		return kysymyksenVastaukset;
	}
	
	
	// JSP
	// Kysymyslista ja vaihtoehtolista
		@RequestMapping("hallinta/kysymykset/{id}/vastaukset")
		public String naytaVastaukset(Model model, @PathVariable int id) {

			
			List<Vastaus> vastaukset = dao.haeKaikki(id);
			
			List<String> pelkatTekstit = new ArrayList<String>();
			for (Vastaus vastaus : vastaukset) {
				pelkatTekstit.add(vastaus.getTeksti());
			}
			Set<String> mySet = new HashSet<String>(pelkatTekstit);
			HashMap hm = new HashMap();
			for(String s : mySet){
 				hm.put(s, Collections.frequency(pelkatTekstit,s));
			}
			
			model.addAttribute("vastaukset", hm);
			
			return "hallinta/vastaukset";
			
		}

}
