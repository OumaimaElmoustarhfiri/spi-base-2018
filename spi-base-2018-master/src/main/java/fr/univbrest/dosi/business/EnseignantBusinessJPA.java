package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repository.EnseignantRepository;
@Component
public class EnseignantBusinessJPA implements EnseignantBusiness{
	
	private EnseignantRepository repos;
	
	@Autowired
	public EnseignantBusinessJPA(EnseignantRepository repos) {
		this.repos = repos;
	}

	@Override
	public Enseignant creerEnseignant(Enseignant creerEnseignant) {
		
		return repos.save(creerEnseignant);
	}

	@Override
	public void supprimerEnseignant(long noEnseignant) {
		repos.delete(noEnseignant);
	}

	@Override
	public List<Enseignant> rechercherEnseignantNom(String nom) {
		return repos.findByNom(nom);
	}

	@Override
	public List<Enseignant> recupererTousLesEnseignants() {
		
		return (List<Enseignant>) repos.findAll();
	}

	@Override
	public Enseignant rechercherEnseignantId(long noEnseignant) {
		return repos.findOne(noEnseignant);
	}

}
