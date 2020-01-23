package mx.flag.picker.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.flag.picker.controller.FlagsControlador;
import mx.flag.picker.dao.IContinentDao;
import mx.flag.picker.dao.ICountContinentDao;
import mx.flag.picker.dao.ICountCountyDao;
import mx.flag.picker.dao.ICountryDao;
import mx.flag.picker.dto.ContinentDto;
import mx.flag.picker.dto.ContinentReq;
import mx.flag.picker.dto.CountryDto;
import mx.flag.picker.dto.CountryReq;
import mx.flag.picker.model.Continent;
import mx.flag.picker.model.CountContinent;
import mx.flag.picker.model.CountCountry;
import mx.flag.picker.model.Country;
import mx.flag.picker.service.IContinentService;
import static mx.flag.picker.service.util.HeaderServiceUtil.headerError;

@Service
public class ContinentService implements IContinentService {

	private static final Logger logger = LoggerFactory.getLogger(FlagsControlador.class);

	@Autowired
	public IContinentDao iContinentDao;

	@Autowired
	public ICountryDao iCountryDao;

	@Autowired
	public ICountContinentDao iCountContinentDao;

	@Autowired
	public ICountCountyDao iCountCountyDao;

	@Override
	public ResponseEntity<List<ContinentDto>> getContinets() {
		return convetContinent();
	}

	@Override
	public ResponseEntity<List<ContinentDto>> getCountry(String continent) {
		return convetCountry(continent);
	}

	@Override
	public ResponseEntity<List<ContinentDto>> getFlag(ContinentReq continent) {
		return convetFlags(continent);
	}

	public ResponseEntity<List<ContinentDto>> convetContinent() {

		List<Continent> continent = null;
		List<ContinentDto> continentDto = null;
		HttpStatus status = null;
		HttpHeaders headers = null;
		try {
			continent = iContinentDao.findAll();
			if (continent != null) {
				continentDto = doDtosmall(continent);
				status = HttpStatus.OK;
				headers = headerError("");
			} else {
				status = HttpStatus.BAD_REQUEST;
				headers = headerError("There are no records");
			}
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers = headerError(e.getMessage());
		}
		return new ResponseEntity<List<ContinentDto>>(continentDto, headers, status);

	}

	public ResponseEntity<List<ContinentDto>> convetCountry(String continent) {

		List<Continent> conti = null;
		List<ContinentDto> continentDto = null;
		HttpStatus status = null;
		HttpHeaders headers = null;
		try {
			conti = iContinentDao.findByContinentContaining(continent);
			if (conti != null) {

				continentDto = noflagdoDto(conti);
				status = HttpStatus.OK;
				headers = headerError("");
			} else {
				status = HttpStatus.BAD_REQUEST;
				headers = headerError("There are no records");
			}
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers = headerError(e.getMessage());
		}
		return new ResponseEntity<List<ContinentDto>>(continentDto, headers, status);

	}

	public ResponseEntity<List<ContinentDto>> convetFlags(ContinentReq continent) {
		List<Continent> conti = null;
		List<ContinentDto> continentDto = null;
		List<String> countrys = new ArrayList<String>();

		for (CountryReq conutryReq : continent.getCountries()) {

			String country = conutryReq.getName();
			countrys.add(country);

		}
		HttpStatus status = null;
		HttpHeaders headers = null;
		try {
			conti = iContinentDao.findByCountries_countryIn(countrys);
			if (conti != null) {
				// continentDto = doDto(conti, countrys);
				continentDto = noflagdoDto(conti);
				status = HttpStatus.OK;
				headers = headerError("");
			} else {
				status = HttpStatus.BAD_REQUEST;
				headers = headerError("There are no records");
			}
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers = headerError(e.getMessage());
		}
		return new ResponseEntity<List<ContinentDto>>(continentDto, headers, status);

	}

	public List<ContinentDto> doDto(List<Continent> conti, List<String> countrys) {

		List<ContinentDto> continentDto = new ArrayList<ContinentDto>();
		//Optional<CountContinent> count = Optional.empty();

		for (Continent cont : conti) {
			//count = Optional.empty();
			List<CountryDto> countryDtos = new ArrayList<CountryDto>();
			ContinentDto contDto = new ContinentDto();
			CountryDto countryDto = new CountryDto();
			contDto.setContinent(cont.getContinent());
			contDto.setCountries(countryDtos);
			

			//count = iCountContinentDao.findById(cont.getId_continent());

//			if (count != null) {
//				Long number = count.get().getCount();
//				count = Optional.empty();
//				count.get().setId_continent(cont.getId_continent());
//				count.get().setCount(number++);
//				iContinentDao.save(cont);
//			} else {
//				Long number = 0l;
//				count = Optional.empty();
//				count.get().setId_continent(cont.getId_continent());
//				count.get().setCount(number++);
//				iContinentDao.save(cont);
//			}
			continentDto.add(contDto);
			for (Country country : cont.getCountries()) {
				logger.info("mas" + country);
				for (String name : countrys) {
					logger.info("mas" + name);
					if (country.getCountry().equals(name)) {

						countryDto = new CountryDto();
						countryDto.setName(country.getCountry());
						countryDto.setFlag(country.getFlag());
						countryDtos.add(countryDto);
					}

				}

			}

		}
		return continentDto;
	}

	public List<ContinentDto> noflagdoDto(List<Continent> continent) {

		List<ContinentDto> continentDto = new ArrayList<ContinentDto>();
		//Optional<CountCountry> count = Optional.empty();
		for (Continent cont : continent) {
			List<CountryDto> countryDtos = new ArrayList<CountryDto>();
			ContinentDto contDto = new ContinentDto();

			contDto.setContinent(cont.getContinent());
			contDto.setCountries(countryDtos);
			continentDto.add(contDto);

			for (Country country : cont.getCountries()) {
				CountryDto countryDto = new CountryDto();
				countryDto.setName(country.getCountry());
			//	count = Optional.empty();
//				count = iCountCountyDao.findById(cont.getId_continent());
//
//				if (count != null) {
//					Long number = count.get().getCount();
//					count = Optional.empty();
//					count.get().setId_country(country.getId_country());
//					count.get().setCount(number++);
//					iContinentDao.save(cont);
//				} else {
//					Long number = 0l;
//					count = Optional.empty();
//					count.get().setId_country(country.getId_country());
//					count.get().setCount(number++);
//					iContinentDao.save(cont);
//				}

				countryDtos.add(countryDto);
			}
		}
		return continentDto;
	}

	public List<ContinentDto> doDtosmall(List<Continent> continent) {

		List<ContinentDto> continentDto = new ArrayList<ContinentDto>();

		for (Continent cont : continent) {
			ContinentDto contDto = new ContinentDto();

			contDto.setContinent(cont.getContinent());
			continentDto.add(contDto);
		}
		return continentDto;
	}

}
