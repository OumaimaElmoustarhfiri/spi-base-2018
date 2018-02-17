package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Candidat;
@Service
public interface CandidatBusiness {
	
	Candidat creerCandidat(Candidat creerCandidat);
	void supprimerCandidat(String noCandidat);
	void supprimerCandidatObjet(Candidat supprimerCandidat);
	List<Candidat> rechercherCandidatNom(String nom);
	List<Candidat> rechercherCandidatUniversite(String universiteOrigine);
	List<Candidat> recupererToutsLesCandidats();
	Candidat rechercheCandidatId(String noCandidat);

}
