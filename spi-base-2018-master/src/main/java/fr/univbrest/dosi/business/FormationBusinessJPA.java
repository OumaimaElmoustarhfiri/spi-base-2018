package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repository.FormationRepository;


@Component // c'est Spring ki va creer la classe et pouvoir injecter les dependnces et gerer les autres classes !!!!
public class FormationBusinessJPA implements FormationBusiness{
	
	private FormationRepository repos;
	
	@Autowired
	public FormationBusinessJPA(FormationRepository repos) {
		this.repos = repos;
	}

	@Override
	public Formation creerFormation(Formation formatioACreer) {
		formatioACreer.setDebutAccreditation(new Date());
		return repos.save(formatioACreer);
		
	}

	@Override
	public void supprimerFormation(Formation supprimerCandidat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Formation> rechercherFormationNom(String nom) {
		return repos.findByNomFormation(nom);
	}

	@Override
	public List<Formation> recupererToutesLesFormations() {
		return (List<Formation>) repos.findAll();
	}
	
}
