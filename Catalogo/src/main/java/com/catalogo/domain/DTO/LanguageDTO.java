package com.catalogo.domain.DTO;


import lombok.Value;

import java.sql.Timestamp;

import com.catalogo.domain.Language;

	
@Value
public class LanguageDTO {


	private Integer languageId;


	private String name;

	public static LanguageDTO from(Language target) {
		Integer lanid = null;
		String nombre=null;
		if(target !=null) {lanid=target.getLanguageId();
		nombre = target.getName();}
		return new LanguageDTO(
				lanid,
				nombre);
	}
	
	public static Language from(LanguageDTO target) {
		Integer lanid = null;
		String nombre=null;
		Timestamp time = null;
		if(target !=null) {lanid=target.getLanguageId();
		nombre = target.getName();
		time = new Timestamp(System.currentTimeMillis());
		}
		return new Language(
				lanid,
				nombre,time 
				);
	}

	

}