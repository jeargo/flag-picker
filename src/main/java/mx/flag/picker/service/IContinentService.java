package mx.flag.picker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import mx.flag.picker.dto.ContinentDto;
import mx.flag.picker.dto.ContinentReq;

public interface IContinentService {

	public ResponseEntity<List<ContinentDto>> getContinets();

	public ResponseEntity<List<ContinentDto>> getCountry(String continent);

	public ResponseEntity<List<ContinentDto>> getFlag(ContinentReq continent);
}
