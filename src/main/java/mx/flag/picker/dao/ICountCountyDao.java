package mx.flag.picker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.flag.picker.model.CountCountry;

public interface ICountCountyDao  extends JpaRepository<CountCountry, Long> {

}