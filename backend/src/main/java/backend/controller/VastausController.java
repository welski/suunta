package backend.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.bean.Vastaus;
import backend.dao.VastausDAO;

@Controller
public class VastausController {
	
	@Inject
	VastausDAO dao;
	
	// REST, JSON-muotoisten vastausten tallentaminen yhdestä kysymyksestä
	@RequestMapping(value = "kyselyt/{kyselyId}/kysymykset/{kysymysId}", method = RequestMethod.POST)
	public @ResponseBody List<Vastaus> luoVastaukset(@PathVariable int kyselyId, @PathVariable int kysymysId, @RequestBody List<Vastaus> vastaukset) {
		
		for (Vastaus v : vastaukset) {
			dao.luoUusi(v, kysymysId);
		}
		
		return vastaukset;
	}

}
