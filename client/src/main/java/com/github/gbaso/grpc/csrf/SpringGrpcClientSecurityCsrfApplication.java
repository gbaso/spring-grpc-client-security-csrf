package com.github.gbaso.grpc.csrf;

import com.github.gbaso.grpc.hello.SimpleGrpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.grpc.client.GrpcChannelFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@SpringBootApplication
public class SpringGrpcClientSecurityCsrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGrpcClientSecurityCsrfApplication.class, args);
	}

	@Bean
	SimpleGrpc.SimpleBlockingStub simpleStub(GrpcChannelFactory channelFactory) {
		return SimpleGrpc.newBlockingStub(channelFactory.createChannel("simple"));
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.httpBasic(withDefaults())
				.csrf(CsrfConfigurer::disable)
				.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withDefaultPasswordEncoder()
						.username("user")
						.password("password")
						.build()
		);
	}
}
