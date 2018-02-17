package fr.univbrest.dosi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@RequestMapping("/enseignant")
public class EnseignantController {
	
	private EnseignantBusiness business;
	
	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant creerEnseignant) {
		return business.creerEnseignant(creerEnseignant);
	}

	public List<Enseignant> recupererTousLesEnseignants() {
		return business.recupererTousLesEnseignants();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Enseignant> rechercheCandidatNom(@PathVariable String nom) {
		return business.rechercherEnseignantNom(nom);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/noEnseignant/{noEnseignanat}")
	public Enseignant rechercheEnseignantId(@PathVariable long noEnseignant) {
		return business.rechercherEnseignantId(noEnseignant);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{noEnseignant}")
	public void supprimerCandidatId(@PathVariable long noEnseignant) {
		business.supprimerEnseignant(noEnseignant);
	}
}
