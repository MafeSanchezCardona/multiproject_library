package co.com.exam.multiproject_library.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageFormat
{
	public String formatMessage(BindingResult result)
	{
		List<Map<String, String>> errors = result.getFieldErrors().stream().map(fieldError -> {
			Map<String, String> error = new HashMap<>();
			error.put(fieldError.getField(), fieldError.getDefaultMessage());
			return error;
		}).collect(Collectors.toList());

		ErrorMessage errorMessage = ErrorMessage.builder().messages(errors).code("01").build();

		ObjectMapper mapper = new ObjectMapper();
		String json = "";

		try
		{
			json = mapper.writeValueAsString(errorMessage);
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}

		return json;
	}
}