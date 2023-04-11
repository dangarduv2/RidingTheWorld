package com.catalogo.ServicesImpl;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidadorRating implements ConstraintValidator<Rating,String>{
	
	List<String> listaRatings = Arrays.asList("G","PG","PG-13","R","NC-17");
	

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value==null) {return true;}
		for(String r:listaRatings)
		{
			if(value.equals(r)) {
				return true;
			}
		}
		return false;
	}
}

