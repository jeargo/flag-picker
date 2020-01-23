package mx.flag.picker.dto;

import java.util.List;

public class ContinentDto {
	
	private String continent;
	
	private List<CountryDto> countries;
	
	

	public List<CountryDto> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryDto> countries) {
		this.countries = countries;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	

}
