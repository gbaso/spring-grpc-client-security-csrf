package com.github.gbaso.grpc.csrf;

import com.github.gbaso.grpc.hello.HelloReply;
import com.github.gbaso.grpc.hello.HelloRequest;
import com.github.gbaso.grpc.hello.SimpleGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

	private final SimpleGrpc.SimpleBlockingStub simpleStub;

	GreetingController(SimpleGrpc.SimpleBlockingStub simpleStub) {
		this.simpleStub = simpleStub;
	}

	@GetMapping
	GreetingResponse getGreeting(@RequestParam String name) {
		var helloRequest = HelloRequest.newBuilder()
				.setName(name)
				.build();
		var helloReply = simpleStub.sayHello(helloRequest);
		return new GreetingResponse(helloReply.getMessage());
	}

	@PostMapping
	GreetingResponse postGreeting(@RequestBody GreetingRequest request) {
		var helloRequest = HelloRequest.newBuilder()
				.setName(request.name())
				.build();
		var helloReply = simpleStub.sayHello(helloRequest);
		return new GreetingResponse(helloReply.getMessage());
	}

	record GreetingRequest(String name) {}
	record GreetingResponse(String message) {}
}
