package com.example.petstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PetService {
 
 static HashMap<Integer,Pet> petIdMap=getPetIdMap();
 
 public PetService() {
  super();
 
  if(petIdMap==null)
  {
   petIdMap=new HashMap<Integer,Pet>();
   
  // Creating Pet objects while initializing
   Pet p1=new Pet(1, "kitty",3, "cat");
   Pet p2=new Pet(4, "rex",5, "dog");
   Pet p3=new Pet(3, "goldie",1, "fish");
   Pet p4=new Pet(2, "tarzan",7, "dog");
   Pet p5=new Pet(5, "puus",6, "cat");
   Pet p6=new Pet(6, "parroty",2, "bird");
 
   petIdMap.put(1,p1);
   petIdMap.put(4,p2);
   petIdMap.put(3,p3);
   petIdMap.put(2,p4);
   petIdMap.put(5,p5);
   petIdMap.put(6,p6);
  }
 }
 
 public List getAllPets()
 {
  List pets = new ArrayList(petIdMap.values());
  return pets;
 }
 
 public List getAllPetTypes()
 {
  List pets = new ArrayList(petIdMap.values());
  
  //get all pet types  
  ArrayList<String> pTypes = new ArrayList<String>(); //creating a new string list - to store pet types
  
  for (int i : petIdMap.keySet()) {
	  pTypes.add(petIdMap.get(i).petType);
  }

  //get all distinct pet type values
 List<String> listDistinct = pTypes.stream().distinct().collect(Collectors.toList());
		  
  //return the distinct values list
  return listDistinct;
 }
 
 public ArrayList searchByName(String pName)
 {
	 ArrayList<Pet> searchResults = new ArrayList<Pet>(); //creating a new string list - to store pet types
	  
	  for (int i : petIdMap.keySet()) {
		  if((petIdMap.get(i).petName).equals(pName)) { //if a pet's name matches,
			  searchResults.add(petIdMap.get(i));			  
		  }
	  }
	  
	  return searchResults;
 }
 
 public ArrayList searchByAge(int pAge)
 {
	 ArrayList<Pet> searchResults = new ArrayList<Pet>(); //creating a new string list - to store pet types
	  
	  for (int i : petIdMap.keySet()) {
		  if((petIdMap.get(i).age) == pAge) { //if a pet's name matches,
			  searchResults.add(petIdMap.get(i));			  
		  }
	  }
	  
	  return searchResults;
 }
 
 
 
 public Pet getPet(int id)
 {
  Pet pet= petIdMap.get(id);
  return pet;
 }
 
 public Pet addPet(Pet pet)
 {
  pet.setId(petIdMap.size()+1);
  petIdMap.put(pet.getId(), pet);
  return pet;
 }
 
 public Pet updatePet(Pet pet)
 {
  if(pet.getId()<=0)
   return null;
  petIdMap.put(pet.getId(), pet);
  return pet;
 
 }
 
 public PetTypeUpdation updatePetType(PetTypeUpdation p)
 { 
	 //update all the pets with the given type
	  for (int i : petIdMap.keySet()) {
		  if((petIdMap.get(i).petType).equals(p.oldType)) { //if a pet's type matches, then update
			  petIdMap.get(i).petType = p.newType;
		  }
		  
	  }
	  return p;
 
 }
 
 public void deletePet(int id)
 {
  petIdMap.remove(id);
 }

 public void deletePetType(String ptype)
 {
	 //delete all the pets with the given pet type
	  for (int i : petIdMap.keySet()) {
		  if((petIdMap.get(i).petType)==(ptype)) {
			  petIdMap.remove(i);
		  }
	  }
 }

 public static HashMap<Integer, Pet> getPetIdMap() {
  return petIdMap;
 }
}
 