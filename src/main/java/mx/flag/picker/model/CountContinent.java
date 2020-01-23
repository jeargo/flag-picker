package mx.flag.picker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "count_continent")
public class CountContinent {
	
	@Id
	private Long id_continent;
	
	private Long  count;

	public Long getId_continent() {
		return id_continent;
	}

	public void setId_continent(Long id_continent) {
		this.id_continent = id_continent;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	



}