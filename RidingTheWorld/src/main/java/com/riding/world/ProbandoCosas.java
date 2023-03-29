package com.riding.world;

import org.hibernate.id.insert.Binder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import com.riding.world.domain.Bike;
import com.riding.world.domain.Lisencia;
import com.riding.world.domain.Marca;

import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Configuration
public class ProbandoCosas implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Bike bs = new Bike();
		bs.setId(1);
		bs.setCc(800);
		bs.setLisencia(new Lisencia(1,"A2"));
		bs.setMarca(new Marca(1,"Kawasaki"));
		bs.setNombreModelo("MT-07");
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		var err = validator.validate(bs);
		System.out.println(err.size());
		

		
		
	}
}


