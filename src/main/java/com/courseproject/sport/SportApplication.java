package com.courseproject.sport;

import com.courseproject.sport.dao.UserRepository;
import com.courseproject.sport.entity.User;
import com.courseproject.sport.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SportApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportApplication.class, args);
    }

    /**
     * 测试数据自动装配
     * @param userRepo
     * @return
     */
    @Bean
    public CommandLineRunner demo(UserRepository userRepo){
        return args -> {
            UserService userService = new UserService();
            userRepo.save(userService.createUser("oB4nYjnoHhuWrPVi2pYLuPjnCaU0","aaa",
                    "test_user 1","ping_pong",5.0));
            userRepo.save(userService.createUser("oB4nYjvY13SVtaWC-AFztM2f3TlU","bbb",
                    "test_user 2","football",5.0));
            userRepo.save(userService.createUser("oB4nYjhJHQVaD0PL7qs0W1kL-_ls","ccc",
                    "test_user 3","table_tennis",5.0));
        };
    }
}
