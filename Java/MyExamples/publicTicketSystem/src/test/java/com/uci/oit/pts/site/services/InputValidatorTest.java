package com.uci.oit.pts.site.services;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.uci.oit.pts.site.domain.ProblemForm;

import groovy.transform.builder.InitializerStrategy.SET;

@RunWith(MockitoJUnitRunner.class)
public class InputValidatorTest {

	@Mock
	Validator validator;
	@Mock
	Set<ConstraintViolation<ProblemForm>> mockViolations;
	InputValidator sut;
	
	@Before
	public void setup(){
		sut = new InputValidator(validator);
	}
	
	
	@Test
	public void testValidateProblemForm() {
		ProblemForm input = new ProblemForm();
		when(validator.validate(input)).thenReturn(mockViolations);
		sut.validateProblemForm(input);
		verify(validator).validate(input);
	}

}
