package com.example.petstore;

public class Pet {
	 int id;
	 String petName; 
	 int age;
	 String petType;
	 
	 public Pet() {
	 super();
	 }
	 public Pet(int id, String petName,int age, String petType) {
	 super();
	 this.id = id;
	 this.petName = petName;
	 this.age= age;
	 this.petType = petType;
	 }
	 public int getId() {
	 return id;
	 }
	 public void setId(int id) {
	 this.id = id;
	 }
	 public String getPetName() {
	 return petName;
	 }
	 public void setPetName(String petName) {
	 this.petName = petName;
	 }
	 public long getage() {
	 return age;
	 }
	 public void setAge(int age) {
	 this.age = age;
	 } 
	 public String getType() {
	 return petType;
	 }
	 public void setType(String petType) {
	 this.petType = petType;
	 } 
}
