package com.example.petstore;

public class PetTypeUpdation {

	 String oldType; 
	 String newType;
	 
	 public PetTypeUpdation() {
	 super();
	 }
	 public PetTypeUpdation( String oldType, String newType) {
	 super();

	 this.oldType = oldType;
	 this.newType = newType;
	 }

	 public String getOldType() {
	 return oldType;
	 }
	 public void setoldType(String oldType) {
	 this.oldType = oldType;
	 }

	 public String getnewType() {
	 return newType;
	 }
	 public void setnewType(String newType) {
	 this.newType = newType;
	 } 
}
