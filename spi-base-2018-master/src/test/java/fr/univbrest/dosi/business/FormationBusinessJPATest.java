package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repository.FormationRepository;

public class FormationBusinessJPATest {
	
	FormationBusinessJPA repos;
	
	@Test
	public void doitCreerUneFormation() {

		FormationRepository repos = new FormationRepositoryList();
		FormationBusinessJPA business = new FormationBusinessJPA(repos);
		Formation formationACreer = new Formation("1","MASTER","M2", BigDecimal.valueOf(2.0),"DOSI");
		
		Formation resultat = business.creerFormation(formationACreer);
		assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date(), 500);
		assertThat(repos.count()).isEqualTo(1);
		
		
	}
	
	@Test
	public void doitRechercherParNomFormation() {
		Formation formation = new Formation("1","MASTER","M2", BigDecimal.valueOf(2.0),"DOSI");
		FormationRepository repos = new FormationRepositoryList();
		FormationBusinessJPA business = new FormationBusinessJPA(repos);
		business.creerFormation(formation);
		List<Formation> listFormation = business.rechercherFormationNom("DOSI");
		
		assertThat(listFormation).hasSize(1);
		assertThat(listFormation.get(0).getNomFormation()).isEqualTo("DOSI");
	
	}
	
	
	class FormationRepositoryList implements FormationRepository{
		private List<Formation> data;
		public FormationRepositoryList() {
			data = Lists.newArrayList();
		}
		@Override
		public <S extends Formation> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Formation> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Formation findOne(String id) {
			/*Formation formation = new Formation();
			if (formation.getCodeFormation().equals(id)) {
				return formation;
			}*/
			return null;
		}

		@Override
		public boolean exists(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Formation> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Formation> findAll(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			long resultat = data.size();
			return resultat;
		}

		@Override
		public void delete(String id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Formation entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Iterable<? extends Formation> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Formation> findByNomFormation(String nom) {
			List<Formation> listCandidat = new ArrayList<>();
			for (Formation f : data) {
				if(f.getNomFormation().equals(nom)) {
					listCandidat.add(f);
					return listCandidat;
				}
			}
			return null;
		}
		
	}
	

}
