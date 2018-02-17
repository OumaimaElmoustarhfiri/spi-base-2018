package fr.univbrest.dosi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class PromotionRepositoryTest {
	
	@Autowired
	PromotionRepository promotionRepo;
	
	@Before
	public void setup() {
		
		Promotion promotion1 = new Promotion(new PromotionPK("2013-2014","M2DOSI"), BigDecimal.valueOf(2.0), "DOSI4","LC117B");
		Promotion promotion2 = new Promotion(new PromotionPK("2014-2015","M2DOSI"), BigDecimal.valueOf(2.0), "DOSI5","LC117B");
		
		promotionRepo.save(promotion1);
		promotionRepo.save(promotion2);

	}

	@Test 
	public void doitRechercherParSiglePromotion() {
		
		List<Promotion> resultat = promotionRepo.findBySiglePromotion("DOSI4");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getSiglePromotion()).isEqualTo("DOSI4");
		
	}

	@Test
	public void doitRechercherParLieuRentree() {
		
		List<Promotion> resultat = promotionRepo.findByLieuRentree("LC117B");
		assertThat(resultat).hasSize(2);
		assertThat(resultat.get(0).getLieuRentree()).isEqualTo("LC117B");
		assertThat(resultat.get(0).getSiglePromotion()).isEqualTo("DOSI4");
		
	}
	
	@Test
	public void doitCompterLesPromotions() {
		long resultat = promotionRepo.count();
		
		assertThat(resultat).isEqualTo(2);
	}

}
