package mx.flag.picker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.flag.picker.model.Continent;
import mx.flag.picker.model.Country;

public interface IContinentDao extends JpaRepository<Continent, Long> {

	
	public List<Continent> findByCountries_countryIn(@Param("countrys") List<String> countrys);

	@Query("from Continent where continent like %?1% ")
	public List<Continent> findByContinentContaining(String continent);
}
