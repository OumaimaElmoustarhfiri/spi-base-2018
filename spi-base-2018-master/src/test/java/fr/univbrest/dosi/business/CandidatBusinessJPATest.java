package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repository.CandidatRepository;

public class CandidatBusinessJPATest {
	
	CandidatBusinessJPA repos;
	
	@Test
	public void doitCreerCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		CandidatBusinessJPA business = new CandidatBusinessJPA(repos);
		Candidat creerCandidat = new Candidat("1", "RABAT", "test@gmail.com", "0000", "ELM", "OUMAIMA", "FSR");
		
		Candidat resultat = business.creerCandidat(creerCandidat);
		assertThat(resultat.getNoCandidat()).isEqualTo("1");
		assertThat(repos.count()).isEqualTo(1);		
	}
	
	@Test
	public void doitSupprimerCandidat() {
		Candidat creerCandidat = new Candidat("1", "RABAT", "test@gmail.com", "0000", "ELM", "OUMAIMA", "FSR");
		List<Candidat> listCandidat = Lists.newArrayList();
		listCandidat.add(creerCandidat);
		CandidatRepository repos = new CandidatRepositoryList(listCandidat);
		CandidatBusinessJPA business = new CandidatBusinessJPA(repos);
		
		business.supprimerCandidatObjet(creerCandidat);
		assertThat(repos.count()).isEqualTo(0);		

		
		
	}
	
	@Test
	public void doitRechercherParNomCandidat() {
		Candidat candidat = new Candidat("1", "RABAT", "test@gmail.com", "0000", "ELM", "OUMAIMA", "FSR");
		CandidatRepository repos = new CandidatRepositoryList();
		CandidatBusinessJPA business = new CandidatBusinessJPA(repos);
		business.creerCandidat(candidat);
		List<Candidat> listCandidat = business.rechercherCandidatNom("ELM");
		
		assertThat(listCandidat).hasSize(1);
		assertThat(listCandidat.get(0).getNoCandidat()).isEqualTo("1");
	
	}

	@Test
	public void doitRechercherParUniversiteOrigine() {
		Candidat candidat = new Candidat("1", "RABAT", "test@gmail.com", "0000", "ELM", "OUMAIMA", "FSR");
		CandidatRepository repos = new CandidatRepositoryList();
		CandidatBusinessJPA business = new CandidatBusinessJPA(repos);
		business.creerCandidat(candidat);
		List<Candidat> listCandidat = business.rechercherCandidatUniversite("FSR");
		
		assertThat(listCandidat).hasSize(1);
		assertThat(listCandidat.get(0).getNoCandidat()).isEqualTo("1");
	}
		
	class CandidatRepositoryList implements CandidatRepository{
		private List<Candidat> data;
		public CandidatRepositoryList() {
			data = Lists.newArrayList();
		}

		public CandidatRepositoryList(List<Candidat> listCandidat) {
			// TODO Auto-generated constructor stub
			data = listCandidat;
		}

		@Override
		public <S extends Candidat> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Candidat> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Candidat findOne(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Candidat> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Candidat> findAll(Iterable<String> ids) {
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
		public void delete(Candidat entity) {
			data.remove(entity);
		}

		@Override
		public void delete(Iterable<? extends Candidat> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Candidat> findByNom(String nom) {
			List<Candidat> listCandidat = new ArrayList<>();
			for (Candidat c : data) {
				if(c.getNom().equals(nom)) {
					listCandidat.add(c);
					return listCandidat;
				}
			}
			return null;
		}

		@Override
		public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
			List<Candidat> listCandidat = new ArrayList<>();
			for (Candidat c : data) {
				if(c.getUniversiteOrigine().equals(universiteOrigine)) {
					listCandidat.add(c);
					return listCandidat;
				}
			}
			return null;
		}
	
		
	}

}
