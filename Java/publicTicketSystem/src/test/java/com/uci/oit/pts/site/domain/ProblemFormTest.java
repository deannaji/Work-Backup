package com.uci.oit.pts.site.domain;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProblemFormTest {
	
	private static Validator validator;
	
	@BeforeClass
	public static void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testValueSetting() {
		ProblemForm sut = new ProblemForm();
		sut.setEmpName("");
		sut.setProbTitle("");
		//This field is not required, so no violations will be recorded for it.
		sut.setProbDisc("");
		Set<ConstraintViolation<ProblemForm>> constraintViolations = validator.validate(sut);
		//number of expected violations:
		assertEquals( 2, constraintViolations.size() );
        assertEquals( "must not be empty", constraintViolations.iterator().next().getMessage());
	}

}
