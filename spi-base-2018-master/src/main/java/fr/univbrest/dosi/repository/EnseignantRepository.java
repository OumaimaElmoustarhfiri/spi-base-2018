package fr.univbrest.dosi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantRepository extends CrudRepository<Enseignant, Long> {
	
	List<Enseignant> findByNom(String nom);
	List<Enseignant> findBynoEnseignant(long noEnseignant);
	

}
