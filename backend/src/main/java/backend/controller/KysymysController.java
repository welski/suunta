package backend.controller;

import java.util.ArrayList;
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

	// REST, Yhden kysymyksen haku
	@RequestMapping(value="kyselyt/{kyselyId}/kysymykset/{kysymysId}", method=RequestMethod.GET)
    public @ResponseBody Kysymys haeKysymys(@PathVariable int kyselyId, @PathVariable int kysymysId) {
		Kysymys kysymys = dao.etsi(vdao, kysymysId);
        return kysymys;
    }
	
	
	// TODO REVIEW kaksi eri metodia -> KysymyksTeksti ja KysymysMonivalinta ?
	
	// JSP, Uuden kysymyksen luonti
	// Muoto: teksti
	@RequestMapping(value="hallinta/kyselyt/{kyselyId}/lisaaTeksti", method=RequestMethod.POST)
	public String luoUusiKysymysTeksti(Model model, @PathVariable int kyselyId, @ModelAttribute(value="kysymys") KysymysTeksti kysymys) {
		model.addAttribute("kysymys", kysymys);
		dao.luoUusiTekstikysymys(kysymys, kyselyId);
		return "redirect:/hallinta/kyselyt/{kyselyId}/kysymykset";
	}
	
	// JSP, Uuden kysymyksen luonti
	// Muoto: monivalinta
	@RequestMapping(value="hallinta/kyselyt/{kyselyId}/lisaaMonivalinta", method=RequestMethod.POST)
	public String luoUusiKysymysMonivalinta(Model model, VaihtoehtoDAO vdao, @PathVariable int kyselyId, @ModelAttribute(value="kysymysMv") KysymysMonivalinta kysymys, @RequestParam("vaihtoehto") List<String> vaihtoehtoKentat, @RequestParam("monivalinta") boolean monivalinta) {
		model.addAttribute("kysymys", kysymys);
		
		List<Vaihtoehto> vaihtoehdot = new ArrayList<Vaihtoehto>(3);
		
		for (String teksti : vaihtoehtoKentat){
			Vaihtoehto v = new Vaihtoehto();
			v.setTeksti(teksti);
			vaihtoehdot.add(v);
		}
		
		dao.luoUusiMonivalintaKysymys(vdao, kysymys, kyselyId, vaihtoehdot);
		return "redirect:/hallinta/kyselyt/{kyselyId}/kysymykset";
	}

	// Kysymyslista ja vaihtoehtolista
	@RequestMapping("hallinta/kyselyt/{kyselyId}/kysymykset")
	public String naytaKysymyslista(Model model, @PathVariable int kyselyId) {
		List<Kysymys> kysymykset = dao.haeKaikki(vdao, kyselyId);
		
		List<Vaihtoehto> vaihtoehdot = new ArrayList<>();
		
		for(Kysymys k : kysymykset) {
			vaihtoehdot = vdao.haeKaikki(k.getId());
		}
		
		model.addAttribute("vaihtoehdot", vaihtoehdot);
		model.addAttribute("kysymykset", kysymykset);
		model.addAttribute("kyselyId", kyselyId);
		
		return "hallinta/kysymykset";
	}
	
	

	// Yhden kysymyksen poisto
	@RequestMapping(value = "hallinta/kysymykset/{id}/poista")
	public String poistaKysymys(Model model, @PathVariable int id) {
		dao.poista(id);
		return "redirect:/hallinta/kyselyt";
	}
}
