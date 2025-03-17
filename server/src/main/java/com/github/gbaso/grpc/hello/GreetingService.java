package com.github.gbaso.grpc.hello;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
class GreetingService extends SimpleGrpc.SimpleImplBase {

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		var reply = HelloReply.newBuilder()
				.setMessage("Hello " + request.getName())
				.build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

}
