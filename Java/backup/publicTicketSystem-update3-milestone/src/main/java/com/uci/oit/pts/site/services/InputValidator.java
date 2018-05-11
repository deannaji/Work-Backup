package com.uci.oit.pts.site.services;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.stereotype.Service;
import com.uci.oit.pts.site.domain.ProblemForm;

@Service
public class InputValidator implements InputValidationServiceInterface{

	@Inject
	Validator validator;//Injecting the validator as opposed to declair it below.
	
	@Override
	public Set<ConstraintViolation<ProblemForm>> validateProblemForm(ProblemForm input) {
		//Hibernate validation:
		//ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		//Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<ProblemForm>> violations = validator.validate(input);
		return violations;
	}

}
