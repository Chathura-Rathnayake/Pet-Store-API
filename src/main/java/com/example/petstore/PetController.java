package com.example.petstore;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 
@Path("/pets")
public class PetController {
 
 PetService petService=new PetService();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
 public List getPets()
 {
 
  List listOfPets=petService.getAllPets();
  return listOfPets;
 }
 
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
 public Pet getPetById(@PathParam("id") int id)
 {
  return petService.getPet(id);
 }
    
    //pet search functionalities
    @GET
    @Path("/searchByName/{petName}")
    @Produces(MediaType.APPLICATION_JSON)
 public List getPetNameById(@PathParam("petName") String petName)
 {
    	return petService.searchByName(petName);
 }
    
    @GET
    @Path("/searchByAge/{petAge}")
    @Produces(MediaType.APPLICATION_JSON)
 public List getPetAgeById(@PathParam("petAge") int petAge)
 {
    	return petService.searchByAge(petAge);
 }
    
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
 public Pet addPet(Pet pet)
 {
  return petService.addPet(pet);
 }
 
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
 public Pet updatePet(Pet pet)
 {
  return petService.updatePet(pet);
 
 }
 
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
 public void petCountry(@PathParam("id") int id)
 {
   petService.deletePet(id);
 
 }
 
}
 