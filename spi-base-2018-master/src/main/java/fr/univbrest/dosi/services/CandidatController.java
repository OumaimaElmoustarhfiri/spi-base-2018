package fr.univbrest.dosi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;

@RestController
@RequestMapping("/candidat")


public class CandidatController {
	
	private CandidatBusiness business;
	
	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Candidat creerCandidat(@RequestBody Candidat creerCandidat) {
		return business.creerCandidat(creerCandidat);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Candidat> recupererToutsLesCandidats() {
		return business.recupererToutsLesCandidats();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Candidat> recupererLeCandidatAvecLeNom(@PathVariable String nom){
		return business.rechercherCandidatNom(nom);
	} 
	
	@RequestMapping(method = RequestMethod.GET, value="/universiteOrigine/{universiteOrigine}")
	public List<Candidat> rechercherCandidatUniversite(@PathVariable String universiteOrigine) {
		return business.rechercherCandidatUniversite(universiteOrigine);
	} 
	
	@RequestMapping(method = RequestMethod.GET, value="/noCandidat/{noCandidat}")
	public Candidat rechercheCandidatId(@PathVariable String noCandidat) {
		return business.rechercheCandidatId(noCandidat);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void supprimerCandidatId(@PathVariable String id) {
		business.supprimerCandidat(id);;
	}
	

}
