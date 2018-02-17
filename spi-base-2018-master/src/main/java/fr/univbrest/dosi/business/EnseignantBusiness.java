package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Enseignant;

@Service
public interface EnseignantBusiness {
	
	Enseignant creerEnseignant(Enseignant creerEnseignant);
	void supprimerEnseignant(long noEnseignant);
	List<Enseignant> rechercherEnseignantNom(String nom);
	List<Enseignant> recupererTousLesEnseignants();
	Enseignant rechercherEnseignantId(long noEnseignant);
	

}
