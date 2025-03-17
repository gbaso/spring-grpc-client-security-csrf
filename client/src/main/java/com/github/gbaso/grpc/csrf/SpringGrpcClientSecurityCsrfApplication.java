package com.github.gbaso.grpc.csrf;

import com.github.gbaso.grpc.hello.SimpleGrpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.grpc.client.GrpcChannelFactory;

@SpringBootApplication
public class SpringGrpcClientSecurityCsrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGrpcClientSecurityCsrfApplication.class, args);
	}

}
