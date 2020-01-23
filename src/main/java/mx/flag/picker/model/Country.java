package mx.flag.picker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	private Long  id_country;
	private String country;
	private String flag;
	private Long id_continent;
	public Long getId_country() {
		return id_country;
	}
	public void setId_country(Long id_country) {
		this.id_country = id_country;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Long getId_continent() {
		return id_continent;
	}
	public void setId_continent(Long id_continent) {
		this.id_continent = id_continent;
	}
	
	
}