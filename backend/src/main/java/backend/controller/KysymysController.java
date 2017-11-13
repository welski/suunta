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

import backend.bean.Kysymys;
import backend.dao.KysymysDAO;
import backend.dao.VaihtoehtoDAO;

@Controller
public class KysymysController {
	@Inject
	KysymysDAO dao;
	
	@Inject
	VaihtoehtoDAO vdao;

	// REST, Kaikkien kysymysten haku JSON-muodossa
	@RequestMapping(value = "kyselyt/{id}/kysymykset/", method = RequestMethod.GET)
	public @ResponseBody List<Kysymys> haeKysymyksetJSON(@PathVariable int id) {
		List<Kysymys> kysymykset = dao.haeKaikki(vdao, id);
		return kysymykset;
	}

	// REST, Uuden kysymyksen luonti
//	@RequestMapping(value = "kysymykset", method = RequestMethod.POST)
//	public @ResponseBody Kysymys luoKysymys(@RequestBody Kysymys kysymys) {
//		dao.luoUusi(kysymys);
//		return kysymys;
//	}

/*	
	// JSP, Uuden kysymyksen luonti
	@RequestMapping(value="hallinta/kysymykset", method=RequestMethod.POST)
	public String luoUusiKysymys(Model model, @ModelAttribute(value="kysymys") Kysymys kysymys) {
		model.addAttribute("kysymys", kysymys);
		dao.luoUusi(kysymys);
		return "redirect:/hallinta/kysymykset";
	}
*/
	
/*	
	// Kysymyslista testaukseen
	@RequestMapping("hallinta/kysymykset")
	public String naytaKysymyslista(Model model) {
		List<Kysymys> kysymykset = dao.haeKaikki();
		model.addAttribute("kysymykset", kysymykset);
		return "hallinta/kysymykset";
	}
*/	
	// Yhden kysymyksen haku
	@RequestMapping(value="kysymykset/{id}", method=RequestMethod.GET)
    public @ResponseBody Kysymys haeKysymys(@PathVariable int id) {
		Kysymys kysymys = dao.etsi(id);
        return kysymys;
    }
	
	// Yhden kysymyksen poisto
	@RequestMapping(value = "kysymykset/{id}", method = RequestMethod.DELETE)
	public void poistaKysymys(@PathVariable int id) {
		dao.poista(id);
	}
}
