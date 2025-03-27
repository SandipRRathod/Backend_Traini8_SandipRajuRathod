package com.trainingcenter.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Embeddable    //mark a class as an should be embedded object to the parent entity or table
@Data //getters and setter and etc  
public class CenterAddress {
	
	
	//@notblank : check if the field is blank then throws exception

    @NotBlank(message = "Detailed address is required") 
    private String detailedAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Pincode is required")
    @Pattern(regexp = "^[0-9]*$", message = "Pincode must Be Number/Digit") //particular condition  
    private String pincode;
}
