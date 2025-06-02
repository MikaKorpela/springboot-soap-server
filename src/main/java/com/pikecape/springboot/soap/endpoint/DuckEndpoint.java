package com.pikecape.springboot.soap.endpoint;

import com.pikecape.springboot.soap.GetDuckListResponse;
import com.pikecape.springboot.soap.GetDuckRequest;
import com.pikecape.springboot.soap.GetDuckResponse;
import com.pikecape.springboot.soap.repository.DuckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class DuckEndpoint {
	private final DuckRepository duckRepository;

	private static final String NAMESPACE_URI = "http://pikecape.com/springboot/soap";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDuckRequest")
	@ResponsePayload
	public GetDuckResponse findById(@RequestPayload GetDuckRequest request) {
		GetDuckResponse response = new GetDuckResponse();
		response.setDuck(duckRepository.findById(request.getId()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDuckListRequest")
	@ResponsePayload
	public GetDuckListResponse findAll() {
		GetDuckListResponse response = new GetDuckListResponse();
		response.getDucks().addAll(duckRepository.findAll());

		return response;
	}
}
