package com.catalogo.domain.DTO;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Value;

import java.sql.Timestamp;
import java.util.List;

import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
import com.fasterxml.jackson.annotation.JsonProperty;


@Value
public class CategoryDTO {
	
	@JsonProperty("id")
	private int categoryId;

	@JsonProperty("nombre")
	private String name;
	
	  public static CategoryDTO from(Category target) {
		return new CategoryDTO(target.getCategoryId(),target.getName());
	}

	public static Category from(CategoryDTO target) {
		return new Category(target.getCategoryId(), target.getName());
	}
	

}