package mx.flag.picker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.flag.picker.model.CountContinent;

public interface ICountContinentDao extends JpaRepository<CountContinent, Long> {

}
