package es.salesianos.edu.model;

public class LinkPetOwners {
	
	private Pet pet;
	private Owner owner;
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
