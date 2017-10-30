package backend.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.bean.Kysely;
import backend.dao.KyselyDAO;

@Controller
public class KyselyController {
	@Inject
	KyselyDAO dao;

	// Kaikkien kyselyiden haku JSON-muodossa
	@RequestMapping(value = "kyselyt.json", method = RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselytJSON() {
		List<Kysely> kyselyt = dao.haeKaikki();
		return kyselyt;
	}

	// Uuden kyselyn luonti
	@RequestMapping(value = "kyselyt", method = RequestMethod.POST)
	public @ResponseBody Kysely luoKysely(@RequestBody Kysely kysely) {
		dao.luoUusi(kysely);
		return kysely;
	}

	// Kyselylista testaukseen
	@RequestMapping("hallinta/kyselyt")
	public String naytaKyselylista(Model model) {
		List<Kysely> kyselyt = dao.haeKaikki();
		model.addAttribute("kyselyt", kyselyt);
		return "hallinta/kyselylista";
	}
	
	// Yhden kyselyn haku
	@RequestMapping(value="kyselyt/{id}", method=RequestMethod.GET)
    public @ResponseBody Kysely haeKysely(@PathVariable int id) {
		Kysely kysely = dao.etsi(id);
        return kysely;
    }
	
	// Yhden kyselyn poisto
	@RequestMapping(value = "kyselyt/{id}", method = RequestMethod.DELETE)
	public void poistaKysely(@PathVariable int id) {
		dao.poista(id);
	}
}
