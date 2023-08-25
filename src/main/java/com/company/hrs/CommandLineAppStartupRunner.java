package com.company.hrs;

import com.company.hrs.enums.Gender;
import com.company.hrs.service.abstracts.AccountService;
import com.company.hrs.service.abstracts.RoleService;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final AccountService accountService;
    private final RoleService roleService;
    @Override
    public void run(String... args) throws Exception {
        try {
            accountService.register(new RegisterRequest("Asim", "Babayev", "admin123@gmail.com", "0705439873", LocalDate.of(2000, 11, 26), Gender.Man, null, 1L, "Elmler akademiyasi", "admin123", "admin"));
        }catch(Exception e){

        }
    }
}
