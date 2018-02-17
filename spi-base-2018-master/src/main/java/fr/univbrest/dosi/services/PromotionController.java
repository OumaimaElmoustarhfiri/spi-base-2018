package fr.univbrest.dosi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

	private PromotionBusiness business;
	
	@Autowired
	public PromotionController(PromotionBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> recupererToutesLesPromotions() {
		return business.recupererToutesLesPromotions();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/siglePromotion/{siglePromotion}")
	public List<Promotion> recupererLaPromotionAvecSiglePromotion(@PathVariable String siglePromotion) {
		return business.rechercherPromotionSiglePromotion(siglePromotion);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void supprimerPromotionId(@PathVariable PromotionPK id) {
		business.supprimerPromotion(id);;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Promotion creerPromotion(@RequestBody Promotion creerPromotion) {
		return business.creerPromotion(creerPromotion);
	}
}
