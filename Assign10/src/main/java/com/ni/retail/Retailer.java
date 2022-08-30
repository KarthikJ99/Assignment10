package com.ni.retail;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
@Entity
@Table(name="Retailer")
public class Retailer {

    @Column(name="Retailer_ID")
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    int retailerId;

     @NotNull (message = "Retailer name cannot be empty")
     @Size(min=8,max = 12, message = "Retailer name should be atleast 8 chars and atmost 12 chars")
     //@Column(name="NAME")
     String name;

     
     @Min(1)
     @Max(value=99, message="Max age cannot be more than 99")
     int age;

     @NotBlank
     @Pattern(regexp = "^(.+)@(\\S+)$")
     String email;

    
         
    @Column(name="YEARS_OF_EXPERIENCE")
    //  float experience;   
    float yearsOfExperience;
     
     public Retailer() {
    }

    public Retailer(String name, int age, String email, float yearsOfExperience) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void incrementYearsOfExperience(int increaseBy){
         this.yearsOfExperience=this.yearsOfExperience + increaseBy;
     }

    public  int getRetailerId() {
        return retailerId;
    }   


}
