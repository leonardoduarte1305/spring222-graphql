package dev.leoduarte.compras.graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class HelloWorldGraphQL implements GraphQLQueryResolver {

	public String hello() {
		return "Hello GraphQL";
	}

	public int soma(int a, int b) {
		return a + b;
	}

}
