package mx.flag.picker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.flag.picker.model.Country;

public interface ICountryDao extends JpaRepository<Country , Long> {
	


}
