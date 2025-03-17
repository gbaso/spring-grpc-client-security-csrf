package com.github.gbaso.grpc.csrf;

import com.github.gbaso.grpc.hello.SimpleGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration(proxyBeanMethods = false)
class GrpcClientConfiguration {

	@Bean
	SimpleGrpc.SimpleBlockingStub simpleStub(GrpcChannelFactory channelFactory) {
		return SimpleGrpc.newBlockingStub(channelFactory.createChannel("simple"));
	}

}
