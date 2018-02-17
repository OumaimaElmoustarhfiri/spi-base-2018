package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import fr.univbrest.dosi.bean.Enseignant;

import fr.univbrest.dosi.repository.EnseignantRepository;

public class EnseignantBusinessJPATest {

	EnseignantBusinessJPA repos;

	
	  @Test 
	  public void doitCreerEnseignant() { EnseignantRepository repos = new  EnseignantRepositoryList();
	  EnseignantBusinessJPA business = new EnseignantBusinessJPA(repos);
	  Enseignant creerEnseignant = new Enseignant(1,"ELM", "MAROC", "OUMAIMA");
	  
	  Enseignant resultat = business.creerEnseignant(creerEnseignant);
	  assertThat(resultat.getNoEnseignant()).isEqualTo(1);
	  assertThat(repos.count()).isEqualTo(1);
	  	  
	  }
	 

	class EnseignantRepositoryList implements EnseignantRepository {

		@Override
		public <S extends Enseignant> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enseignant findOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Enseignant> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Enseignant> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void delete(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Enseignant entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Iterable<? extends Enseignant> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Enseignant> findByNom(String nom) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Enseignant> findBynoEnseignant(long noEnseignant) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
