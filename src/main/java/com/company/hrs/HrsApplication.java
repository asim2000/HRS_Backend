package com.company.hrs;

import com.company.hrs.enums.Gender;
import com.company.hrs.service.abstracts.AccountService;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HrsApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrsApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
