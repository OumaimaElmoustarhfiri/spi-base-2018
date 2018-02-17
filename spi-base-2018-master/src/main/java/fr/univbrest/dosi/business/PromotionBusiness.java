package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
@Service
public interface PromotionBusiness {
	
	Promotion creerPromotion(Promotion creerPromotion);
	List<Promotion> rechercherPromotionSiglePromotion(String siglePromotion);
	List<Promotion> recupererToutesLesPromotions();
	Promotion rechercherPromotionId(PromotionPK id);
	void supprimerPromotion(PromotionPK id);
	void supprimerPromotionObjet(Promotion supprimerFormation);
	
	
	
	

}
