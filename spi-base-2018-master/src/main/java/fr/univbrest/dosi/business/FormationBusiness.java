package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Formation;
@Service
public interface FormationBusiness {
	
	 Formation creerFormation(Formation formationACreer);
	 void supprimerFormation(Formation supprimerCandidat);
	 List<Formation> rechercherFormationNom(String nom);
	 List<Formation> recupererToutesLesFormations();
		

}
