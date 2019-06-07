package com.courseproject.sport;

import com.courseproject.sport.dao.AcceptRepository;
import com.courseproject.sport.dao.InviteRepository;
import com.courseproject.sport.dao.UserRepository;
import com.courseproject.sport.service.AcceptTableService;
import com.courseproject.sport.service.InviteTableService;
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
    public CommandLineRunner demo(UserRepository userRepo,
                                  InviteRepository inviteRepo,
                                  AcceptRepository acceptRepo){
        return args -> {
            UserService userService = new UserService();
            userRepo.save(userService.CreateUser("oB4nYjnoHhuWrPVi2pYLuPjnCaU0","aaa",
                    "ping_pong","test_user 1",5.0));
            userRepo.save(userService.CreateUser("oB4nYjvY13SVtaWC-AFztM2f3TlU","bbb",
                    "football","test_user 2",5.0));
            userRepo.save(userService.CreateUser("oB4nYjhJHQVaD0PL7qs0W1kL-_ls","ccc",
                    "table_tennis","test_user 3",5.0));

            InviteTableService inviteTableService = new InviteTableService();
            inviteRepo.save(inviteTableService.CreateInviteTable("oB4nYjnoHhuWrPVi2pYLuPjnCaU0",
                    "ping-pong","local","play ping-pong","20190601",
                    "20190602",1));
            inviteRepo.save(inviteTableService.CreateInviteTable("oB4nYjvY13SVtaWC-AFztM2f3TlU",
                    "football","local","play football","20190602",
                    "20190602",12));
            inviteRepo.save(inviteTableService.CreateInviteTable("oB4nYjhJHQVaD0PL7qs0W1kL-_ls",
                    "table_tennis","local","play table_tennis","20190602",
                    "20190603",2));

            AcceptTableService acceptTableService = new AcceptTableService();
            acceptRepo.save(acceptTableService.CreateAcceptInfo(1,"oB4nYjvY13SVtaWC-AFztM2f3TlU"));
            acceptRepo.save(acceptTableService.CreateAcceptInfo(2,"oB4nYjnoHhuWrPVi2pYLuPjnCaU0"));
            acceptRepo.save(acceptTableService.CreateAcceptInfo(2,"oB4nYjhJHQVaD0PL7qs0W1kL-_ls"));
            acceptRepo.save(acceptTableService.CreateAcceptInfo(3,"oB4nYjnoHhuWrPVi2pYLuPjnCaU0"));
        };
    }
}
