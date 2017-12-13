package backend.controller;

import java.util.*;
import java.util.stream.Collectors;

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

	
	// REST, JSON-muotoisten vastausten tallentaminen yhdestä kysymyksestä
	@RequestMapping(value = "kyselyt/{kyselyId}/vastaukset", method = RequestMethod.POST)
	public @ResponseBody List<Vastaus> luoVastaukset(@PathVariable int kyselyId, @RequestBody List<Vastaus> vastaukset) {
		
		for (Vastaus v : vastaukset) {
			dao.luoUusi(v);
		}
		
		return vastaukset;
	}
	
	//REST, JSON-muodossa yhden kyselyn yhden kysymyksen kaikkien vastausten haku
	@RequestMapping(value = "kyselyt/{kyselyId}/kysymykset/{kysymysId}/vastaukset", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> haeKyselynVastauksetJSON(@PathVariable int kysymysId) {
		
		List<Vastaus> kysymyksenVastaukset = dao.haeKaikki(kysymysId);
		
		return kysymyksenVastaukset;
	}
	
	
	// JSP
	// Kysymyslista ja vaihtoehtolista
		@RequestMapping("hallinta/kyselyt/{kyselyId}/kysymykset/{kysymysId}/vastaukset")
		public String naytaVastaukset(Model model, @PathVariable int kyselyId, @PathVariable int kysymysId) {

			
			List<Vastaus> vastaukset = dao.haeKaikki(kysymysId);
			
			List<String> pelkatTekstit = new ArrayList<String>();
			
			for (Vastaus vastaus : vastaukset) {
				pelkatTekstit.add(vastaus.getTeksti());
			}
			
			Set<String> mySet = new HashSet<String>(pelkatTekstit);
			
			HashMap<String, Integer> hm = new HashMap<>();
			
			for(String s : mySet){
 				hm.put(s, Collections.frequency(pelkatTekstit,s));
			}
			
			Map<String, Integer> result = hm.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
			
			model.addAttribute("vastaukset", result);
			model.addAttribute("kyselyId", kyselyId);
			
			
			return "hallinta/vastaukset";
			
		}

}
