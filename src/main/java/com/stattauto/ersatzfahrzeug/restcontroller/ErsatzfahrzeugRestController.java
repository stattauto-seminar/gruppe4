package com.stattauto.ersatzfahrzeug.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stattauto.ersatzfahrzeug.entity.Fahrzeug;
import com.stattauto.ersatzfahrzeug.repository.FahrzeugRepository;

@RefreshScope
@RestController
public class ErsatzfahrzeugRestController {

	@Autowired
	private FahrzeugRepository repo;
	
	@Value("${welcome.message}")
	private String message;

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return message + ": " + name;
	}

	@GetMapping("/hello2")
	public String hello(@RequestParam String vorname, @RequestParam String nachname) {
		return "Hello " + vorname + " " + nachname;
	}

	@GetMapping("/findAll")
	public Collection<Fahrzeug> getAllFahrzeuge() {
		return repo.findAll();
	}
	
	@GetMapping("/find/{kennzeichen}")
	public Fahrzeug getFahrzeug(@PathVariable String kennzeichen) {
		return repo.findByKennzeichen(kennzeichen);
	}

	@GetMapping("/findById/{id}")
	public Fahrzeug getFahrzeug(@PathVariable Fahrzeug id) {
		return id;
	}
	
	@PostMapping("/addFahrzeug")
	public void addFahrzeug(@RequestBody Fahrzeug fahrzeug) {
		repo.save(fahrzeug);
	}
}
