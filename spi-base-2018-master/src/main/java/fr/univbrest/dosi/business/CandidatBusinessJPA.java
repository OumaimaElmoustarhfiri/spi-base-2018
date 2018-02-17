package fr.univbrest.dosi.business;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repository.CandidatRepository;

@Component
public class CandidatBusinessJPA implements CandidatBusiness{
	
	private CandidatRepository repos;
	
	@Autowired
	public CandidatBusinessJPA(CandidatRepository repos) {
		this.repos = repos;
	}
	
	public Candidat creerCandidat(Candidat creerCandidat) {
		return repos.save(creerCandidat);
		
	}
	
	
	public void supprimerCandidat(String noCandidat) {
		repos.delete(noCandidat);		
		
	}
	
	
	public List<Candidat> rechercherCandidatNom(String nom) {
		return repos.findByNom(nom);
	}

	@Override
	public List<Candidat> rechercherCandidatUniversite(String universiteOrigine) {
	
		return repos.findByUniversiteOrigine(universiteOrigine);
	}

	@Override
	public List<Candidat> recupererToutsLesCandidats() {

		return (List<Candidat>) repos.findAll();
	}

	@Override
	public Candidat rechercheCandidatId(String noCandidat) {
		return repos.findOne(noCandidat);
	}

	@Override
	public void supprimerCandidatObjet(Candidat supprimerCandidat) {
		repos.delete(supprimerCandidat);
		
	}
	
	
	

}
