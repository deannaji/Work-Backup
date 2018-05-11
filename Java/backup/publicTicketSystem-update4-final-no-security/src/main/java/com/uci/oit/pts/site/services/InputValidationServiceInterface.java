package com.uci.oit.pts.site.services;

import java.util.Set;
import javax.validation.ConstraintViolation;
import com.uci.oit.pts.site.domain.ProblemForm;

public interface InputValidationServiceInterface {
	
	public Set<ConstraintViolation<ProblemForm>> validateProblemForm(ProblemForm input);
}
