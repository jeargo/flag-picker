package mx.flag.picker.dto;

import java.util.List;

public class ContinentReq {
	
	
	private String continent;
	
	private List<CountryReq> countries;
	

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public List<CountryReq> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryReq> countries) {
		this.countries = countries;
	}
	
	
	
	

}
