package mx.flag.picker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "continent")
public class Continent {
	
	@Id
	private Long id_continent;
	
	private String continent;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_continent")
    private List<Country> countries;
	
		
	
	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	

	public Long getId_continent() {
		return id_continent;
	}

	public void setId_continent(Long id_continent) {
		this.id_continent = id_continent;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

}
