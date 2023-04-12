package com.catalogo.exceptions;

public class ProbandoExcepciones {

	public void PruebaNotFoundException(int prueba) throws NotFoundException {
		switch (prueba) {
		case 1: throw new NotFoundException(); 
		case 2: throw new NotFoundException("Excepcion Con Mensaje");
		}
	}

	public void PruebaInvalidDataException(int prueba) throws InvalidDataException {
			switch (prueba) {
			case 1: throw new InvalidDataException(); 
			case 2: throw new InvalidDataException("Excepcion Con Mensaje");
			}
		}

	public void PruebaDuplicateKeyException(int prueba) throws DuplicateKeyException {
		switch (prueba) {
		case 1:
			throw new DuplicateKeyException();
		case 2:
			throw new DuplicateKeyException("Excepcion Con Mensaje");
		}
		}

	public void PruebaBadRequestException(int prueba) throws BadRequestException {
		switch (prueba) {
		case 1:
			throw new BadRequestException();
		case 2:
			throw new BadRequestException("Excepcion Con Mensaje");
		}
	}
}
