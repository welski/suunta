package backend.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import wat.beans.Kysely;

@Controller
public class KyselyController {
	@Inject
	KyselyDAO dao;

	@RequestMapping(value = "kyselyt.json", method = RequestMethod.GET)
	public @ResponseBody List<Kysely> haeKyselytJSON() {
		List<Kysely> kyselyt = dao.haeKaikki();
		return kyselyt;
	}

	@RequestMapping(value = "kyselyt", method = RequestMethod.POST)
	public @ResponseBody Kysely luoKysely(@RequestBody KyselyImpl kysely) {
		dao.talleta(kysely);
		return kysely;
	}

	@RequestMapping("kyselyt")
	public String naytaKyselylista() {
		return "henk/kyselylista";
	}
	@RequestMapping(value="kyselyt/{id}", method=RequestMethod.GET)
    public @ResponseBody Kysely haeKysely(@PathVariable int id) {
        Kysely kysely = dao.etsi(id);
        return kysely;
    }
	@RequestMapping(value = "kyselyt/{id}", method = RequestMethod.DELETE)
	public void poistaKysely(@PathVariable int id) {
		dao.poista(id);
	}
}
