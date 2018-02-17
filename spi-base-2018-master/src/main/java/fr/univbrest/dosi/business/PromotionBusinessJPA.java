package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repository.PromotionRepository;
@Component
public class PromotionBusinessJPA implements PromotionBusiness {
	
	private PromotionRepository repos;
	
	@Autowired
	public PromotionBusinessJPA(PromotionRepository repos) {
		this.repos = repos;
	}

	@Override
	public Promotion creerPromotion(Promotion creerPromotion) {
		
		return repos.save(creerPromotion);
	}

	@Override
	public List<Promotion> rechercherPromotionSiglePromotion(String siglePromotion) {
		
		return repos.findBySiglePromotion(siglePromotion);
	}

	@Override
	public List<Promotion> recupererToutesLesPromotions() {
		
		return (List<Promotion>) repos.findAll();
	}

	@Override
	public Promotion rechercherPromotionId(PromotionPK id) {
		
		return repos.findOne(id);
	}

	@Override
	public void supprimerPromotion(PromotionPK id) {
		repos.delete(id);
		
	}

	@Override
	public void supprimerPromotionObjet(Promotion supprimerPromotion) {
		repos.delete(supprimerPromotion);
	}

	/*
	@Override
	public void supprimerCandidat(PromotionPK id) {
		repos.delete(id);
		
	}*/
	
	

}
