package com.osvaldo.cursomvc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.osvaldo.cursomvc.domain.Cliente;
import com.osvaldo.cursomvc.dto.ClienteDTO;
import com.osvaldo.cursomvc.repositories.ClienteRepository;
import com.osvaldo.cursomvc.resourses.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer urlId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<FieldMessage>();
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(urlId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		//pegando objeto field message criado aneriormente e jogando na resposta
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

