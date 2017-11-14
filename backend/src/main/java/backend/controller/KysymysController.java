package backend.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.bean.Kysymys;
import backend.bean.KysymysMonivalinta;
import backend.bean.KysymysTeksti;
import backend.bean.Vaihtoehto;
import backend.dao.KysymysDAO;
import backend.dao.VaihtoehtoDAO;

@Controller
public class KysymysController {
	@Inject
	KysymysDAO dao;
	
	@Inject
	VaihtoehtoDAO vdao;

	// REST, Kaikkien kysymysten haku JSON-muodossa
	@RequestMapping(value = "kyselyt/{id}/kysymykset", method = RequestMethod.GET)
	public @ResponseBody List<Kysymys> haeKysymyksetJSON(@PathVariable int id) {
		List<Kysymys> kysymykset = dao.haeKaikki(vdao, id);
		return kysymykset;
	}

	// Yhden kysymyksen haku
	@RequestMapping(value="kyselyt/{kyselyId}/kysymykset/{kysymysId}", method=RequestMethod.GET)
    public @ResponseBody Kysymys haeKysymys(@PathVariable int kyselyId, @PathVariable int kysymysId) {
		Kysymys kysymys = dao.etsi(vdao, kysymysId);
        return kysymys;
    }
	
	
	// TODO REVIEW kaksi eri metodia -> KysymyksTeksti ja KysymysMonivalinta ?
	
	// JSP, Uuden kysymyksen luonti
	// Muoto: teksti
	@RequestMapping(value="hallinta/kyselyt/{?}/uusi", method=RequestMethod.POST)
	public String luoUusiKysymysTeksti(Model model, @PathVariable int kysymysId, @ModelAttribute(value="kysymys") KysymysTeksti kysymys) {
		model.addAttribute("kysymys", kysymys);
		dao.luoUusiTekstikysymys(kysymys, kysymysId);
		return "redirect:/hallinta/kysymykset";
	}
	
	// JSP, Uuden kysymyksen luonti
	// Muoto: monivalinta
	@RequestMapping(value="hallinta/kyselyt/{?}/uusiMV", method=RequestMethod.POST)
	public String luoUusiKysymysMonivalinta(Model model, VaihtoehtoDAO vdao, @PathVariable int kysymysId, @ModelAttribute(value="kysymys") KysymysMonivalinta kysymys, @RequestParam("vaihtoehto") List<Vaihtoehto> vaihtoehdot) {
		model.addAttribute("kysymys", kysymys);
		dao.luoUusiMonivalintaKysymys(vdao, kysymys, kysymysId, vaihtoehdot);
		return "redirect:/hallinta/kysymykset";
	}


	
/*	
	// Kysymyslista testaukseen
	@RequestMapping("hallinta/kysymykset")
	public String naytaKysymyslista(Model model) {
		List<Kysymys> kysymykset = dao.haeKaikki();
		model.addAttribute("kysymykset", kysymykset);
		return "hallinta/kysymykset";
	}
*/	

	// Yhden kysymyksen poisto
	@RequestMapping(value = "kysymykset/{id}", method = RequestMethod.DELETE)
	public void poistaKysymys(@PathVariable int id) {
		dao.poista(id);
	}
}
