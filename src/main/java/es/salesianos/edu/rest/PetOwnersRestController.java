package es.salesianos.edu.rest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.edu.model.LinkPetOwners;
import es.salesianos.edu.model.Owner;
import es.salesianos.edu.model.Pet;

import jdk.internal.org.jline.utils.Log;

@RestController
@RequestMapping(path = "/api")
public class PetOwnersRestController {
	
	List<Pet> lstPets = new ArrayList<Pet>();
	List<Owner> lstOwners = new ArrayList<Owner>();
	List<LinkPetOwners> lstPetOwners = new ArrayList<LinkPetOwners>();
	
	@PostMapping(path = "/saveOwner")
	public ResponseEntity<Owner> saveOwnerPost(@RequestParam String name, @RequestParam String dni) {
		Owner owner = new Owner();
		owner.setName(name);
		owner.setDni(dni);
		lstOwners.add(owner);

		return new ResponseEntity(owner, HttpStatus.ACCEPTED);
	}
	@PostMapping(path = "/savePet")
	public ResponseEntity<Owner> savePetPost(@RequestParam String name, @RequestParam String chip) {
		Pet pet = new Pet();
		pet.setName(name);
		pet.setChip(chip);
		lstPets.add(pet);
		
		return new ResponseEntity(pet, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/listOwners")
	public List<Owner> listOwners() {
		return lstOwners;
	}
	
	@GetMapping(path = "/listPets")
	public List<Pet> listPets() {
		return lstPets;
	}
	
	@PostMapping(path = "/linkOwnerPet")
	public ResponseEntity<Owner> saveLinkOwnerPetPost(@RequestBody Owner owner, @RequestBody Pet pet) {
		LinkPetOwners petOwners = new LinkPetOwners();
		petOwners.setOwner(owner);
		petOwners.setPet(pet);
		lstPetOwners.add(petOwners);
		return new ResponseEntity(pet, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/listOwnerPets")
	public List<LinkPetOwners> listOwnerPets() {
		return lstPetOwners;
	}
	
}
