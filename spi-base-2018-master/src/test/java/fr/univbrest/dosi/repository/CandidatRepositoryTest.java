package fr.univbrest.dosi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class CandidatRepositoryTest {
	
	@Autowired
	CandidatRepository candidatRepo;
	
	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("1","Rabat Maroc","elmoustarhfiri@gmail.com","0667000000", "ELMOU", "Oumaima","FSR");
		Candidat candidat2 = new Candidat("2","Rabat Maroc","soukaina@gmail.com","06111111", "ELM", "Soukaina","FST");
		
		candidatRepo.save(candidat1);
		candidatRepo.save(candidat2);
		
		
	}
	
	@Test
	public void doitRechercherParNomCandidat() {
		
		List<Candidat> resultat = candidatRepo.findByNom("ELMOU");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("ELMOU");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("1");
	
	}
	
	@Test
	public void doitRechercherParUniversiteOrigine() {
		
		List<Candidat> resultat = candidatRepo.findByUniversiteOrigine("FST");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("FST");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("2");
		

	}
	 
	

}
