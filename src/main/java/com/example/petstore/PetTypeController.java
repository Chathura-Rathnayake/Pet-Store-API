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


@Path("/petType")
public class PetTypeController {
 
 PetService petService=new PetService();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
 public List getPetTypes()
 {
 
  List listOfPets=petService.getAllPetTypes();
  return listOfPets;
 }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
 public PetTypeUpdation updatePetType(PetTypeUpdation p)
 {
  return petService.updatePetType(p);
 
 }
 
    @DELETE
    @Path("/{ptype}")
    @Produces(MediaType.APPLICATION_JSON)
 public void deletePetType(@PathParam("ptype") String ptype)
 {
    	petService.deletePetType(ptype);
 }


 
}