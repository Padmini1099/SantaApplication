package chekk.santa.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import chekk.santa.domains.SantaDTO;
import chekk.santa.services.SantaService;

@RestController
@CrossOrigin(origins = "*")
public class SantaController {

	private Logger logger = LoggerFactory.getLogger(SantaController.class);

	@Autowired
	private SantaService santaService;

	@PostMapping("/santa-present")
	public ResponseEntity<ArrayList<Integer>> getCount(@RequestBody SantaDTO santaDTO) {
		return new ResponseEntity<>(santaService.count(santaDTO), HttpStatus.OK);
	}
}
