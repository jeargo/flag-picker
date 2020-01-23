package mx.flag.picker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.flag.picker.dao.IContinentDao;
import mx.flag.picker.dao.ICountryDao;
import mx.flag.picker.dto.ContinentDto;
import mx.flag.picker.dto.ContinentReq;

import mx.flag.picker.service.IContinentService;

@RestController
@RequestMapping("/api")
public class FlagsControlador {

	private static final Logger logger = LoggerFactory.getLogger(FlagsControlador.class);

	@Autowired
	private IContinentService iContinentService;

	@Autowired
	public IContinentDao iContinentDao;

	@Autowired
	public ICountryDao iCountryDao;

	@GetMapping("/continent")
	public ResponseEntity<List<ContinentDto>> continents() {
		return iContinentService.getContinets();
	}

	@GetMapping("/continent/{continent}")
	public ResponseEntity<List<ContinentDto>> continent(
			@PathVariable(value = "continent", required = true) String continent) {
		return iContinentService.getCountry(continent);
	}

	@PostMapping("/country")
	public ResponseEntity<List<ContinentDto>> country(@RequestBody ContinentReq continent) {
		return iContinentService.getFlag(continent);
	}

}