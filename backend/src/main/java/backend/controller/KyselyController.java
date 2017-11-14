package backend.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.bean.Kysely;
import backend.dao.KyselyDAO;

@Controller
public class KyselyController {
	@Inject
	KyselyDAO dao;

	// REST, Kaikkien kyselyiden haku JSON-muodossa
	@RequestMapping(value = "kyselyt", method = RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselytJSON() {
		List<Kysely> kyselyt = dao.haeKaikki();
		return kyselyt;
	}

	// Yhden kyselyn haku
	@RequestMapping(value="kyselyt/{id}", method=RequestMethod.GET)
    public @ResponseBody Kysely haeKysely(@PathVariable int id) {
		Kysely kysely = dao.etsi(id);
        return kysely;
    }
	
	// REST, Uuden kyselyn luonti
	// @RequestMapping(value = "kyselyt", method = RequestMethod.POST)
	// public @ResponseBody Kysely luoKysely(@RequestBody Kysely kysely) {
	// 		dao.luoUusi(kysely);
	//	return kysely;
	// }
	
	// JSP, Uuden kyselyn luonti
	@RequestMapping(value="hallinta/kyselyt", method=RequestMethod.POST)
	public String luoUusiKysely(Model model, @ModelAttribute(value="kysely") Kysely kysely) {
		model.addAttribute("kysely", kysely);
		dao.luoUusi(kysely);
		return "redirect:/hallinta/kyselyt";
	}

	// JSP, lista kyselyist�
	@RequestMapping("hallinta/kyselyt")
	public String naytaKyselylista(Model model) {
		List<Kysely> kyselyt = dao.haeKaikki();
		model.addAttribute("kyselyt", kyselyt);
		return "hallinta/kyselyt";
	}
	
	// JSP, uuden tekstikysymyksen lis�ys
	@RequestMapping("hallinta/kyselyt/{id}/lisaaTeksti")
	public String naytaTekstikysymysLomake(Model model, @PathVariable int id) {
		Kysely kysely = dao.etsi(id);
		model.addAttribute("kysely", kysely);
		return "hallinta/uusiKysymysTeksti";
	}

	
	// Yhden kyselyn poisto
	@RequestMapping(value = "kyselyt/{id}", method = RequestMethod.DELETE)
	public void poistaKysely(@PathVariable int id) {
		dao.poista(id);
	}
}
