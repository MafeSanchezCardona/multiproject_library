package co.com.exam.multiproject_library.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class ResponseBuilder
{
	public Response success()
	{
		return Response.builder().data(HttpStatus.OK).status(HttpStatus.OK.value()).build();
	}

	public Response success(Object data)
	{
		return Response.builder().data(data).status(HttpStatus.OK.value()).build();
	}

	public Response failed(Object data)
	{
		return Response.builder().data(data).status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
	}

	public Response notFound()
	{
		return Response.builder().data(HttpStatus.NOT_FOUND).status(HttpStatus.NOT_FOUND.value()).build();
	}

	public Response noContent()
	{
		return Response.builder().data(HttpStatus.NO_CONTENT).status(HttpStatus.NO_CONTENT.value()).build();
	}
}