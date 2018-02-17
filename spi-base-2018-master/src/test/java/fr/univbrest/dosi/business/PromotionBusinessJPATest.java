package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repository.PromotionRepository;

public class PromotionBusinessJPATest {
	
	PromotionBusinessJPA repos;
	
	@Test
	public void doitCreerPromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		PromotionBusinessJPA business = new PromotionBusinessJPA(repos);
		Promotion creerPromotion = new Promotion(new PromotionPK("2013-2014","M2DOSI"), BigDecimal.valueOf(2.0), "DOSI4","LC117B");
		
		Promotion resultat = business.creerPromotion(creerPromotion);
		assertThat(resultat.getId()).isEqualTo(new PromotionPK("2013-2014","M2DOSI"));
		assertThat(repos.count()).isEqualTo(1);	
		
	}

	@Test
	public void doitRechercherPromotionPArSiglePromotion() {
		Promotion creerPromotion = new Promotion(new PromotionPK("2013-2014","M2DOSI"), BigDecimal.valueOf(2.0), "DOSI4","LC117B");
		PromotionRepository repos = new PromotionRepositoryList();
		PromotionBusinessJPA business = new PromotionBusinessJPA(repos);
		
		business.creerPromotion(creerPromotion);
		List<Promotion> listPromotion = business.rechercherPromotionSiglePromotion("DOSI4");
		assertThat(listPromotion).hasSize(1);
		assertThat(listPromotion.get(0).getSiglePromotion()).isEqualTo("DOSI4");

	}

	@Test
	public void doitSupprimerPromotion() {
		Promotion creerPromotion = new Promotion(new PromotionPK("2013-2014","M2DOSI"), BigDecimal.valueOf(2.0), "DOSI4","LC117B");
		List<Promotion> listPromotion = Lists.newArrayList();
		listPromotion.add(creerPromotion);
		PromotionRepository repos = new PromotionRepositoryList(listPromotion);
		PromotionBusinessJPA business = new PromotionBusinessJPA(repos);
		
		business.supprimerPromotionObjet(creerPromotion);;
		assertThat(repos.count()).isEqualTo(0);
		
		
		
	}
	
	public class PromotionRepositoryList implements PromotionRepository{
		
		private List<Promotion> data;
		public PromotionRepositoryList() {
			data = Lists.newArrayList();
		}
		
		public PromotionRepositoryList(List<Promotion> listPromotion) {
			// TODO Auto-generated constructor stub
			data = listPromotion;
		}

		@Override
		public <S extends Promotion> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Promotion findOne(PromotionPK id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(PromotionPK id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Promotion> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			long resultat = data.size();
			return resultat;
		}

		@Override
		public void delete(PromotionPK id) {			
		}

		@Override
		public void delete(Promotion entity) {
			data.remove(entity);			
		}

		@Override
		public void delete(Iterable<? extends Promotion> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Promotion> findBySiglePromotion(String siglePromotion) {
			List<Promotion> listPromotion = new ArrayList<>();
			for (Promotion p : data) {
				if (p.getSiglePromotion().equals(siglePromotion)) {
					listPromotion.add(p);
					return listPromotion;
				}
			}
			return null;
		}

		@Override
		public List<Promotion> findByLieuRentree(String lieuRentree) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
