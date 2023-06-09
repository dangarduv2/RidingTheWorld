package com.catalogo.domain.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.sql.Timestamp;
import com.catalogo.domain.Category;



@Value
public class CategoryDTO {
	
	@NotNull
	private int categoryId;

	@NotBlank
	private String name;
	
	  public static CategoryDTO from(Category target) {
		return new CategoryDTO(target.getCategoryId(),target.getName());
	}

	public static Category from(CategoryDTO target) {
		return new Category(target.getCategoryId(), target.getName(), new Timestamp(System.currentTimeMillis()));
	}
	

}