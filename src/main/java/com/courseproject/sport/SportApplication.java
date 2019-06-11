package com.courseproject.sport;

import com.courseproject.sport.dao.AcceptRepository;
import com.courseproject.sport.dao.InviteRepository;
import com.courseproject.sport.dao.UserRepository;
import com.courseproject.sport.entity.AcceptTable;
import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.entity.User;
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
            User user1 = userService.CreateUser("oB4nYjnoHhuWrPVi2pYLuPjnCaU0","aaa",
                    "ping_pong","test_user 1",5.0),
                    user2 = userService.CreateUser("oB4nYjvY13SVtaWC-AFztM2f3TlU","bbb",
                    "football","test_user 2",5.0),
                    user3 = userService.CreateUser("oB4nYjhJHQVaD0PL7qs0W1kL-_ls","ccc",
                    "table_tennis","test_user 3",5.0);
            userRepo.save(user1);
            userRepo.save(user2);
            userRepo.save(user3);

            InviteTableService inviteTableService = new InviteTableService();
            InviteTable inviteTable1 = inviteTableService.CreateInviteTable(user1, "ping-pong",
                    "local","play ping-pong","20190601",
                    "20190602",1),
                    inviteTable2 = inviteTableService.CreateInviteTable(user2, "football",
                            "local","play football","20190602",
                            "20190602",12),
                    inviteTable3 = inviteTableService.CreateInviteTable(user3, "table_tennis",
                            "local","play table_tennis","20190602",
                            "20190603",2);
            inviteRepo.save(inviteTable1);
            inviteRepo.save(inviteTable2);
            inviteRepo.save(inviteTable3);

            AcceptTableService acceptTableService = new AcceptTableService();
            AcceptTable acceptTable1 = acceptTableService.CreateAcceptInfo(inviteTable1,user2),
                    acceptTable2 = acceptTableService.CreateAcceptInfo(inviteTable2,user1),
                    acceptTable3 = acceptTableService.CreateAcceptInfo(inviteTable2,user3),
                    acceptTable4 = acceptTableService.CreateAcceptInfo(inviteTable3,user1);
            acceptRepo.save(acceptTable1);
            acceptRepo.save(acceptTable2);
            acceptRepo.save(acceptTable3);
            acceptRepo.save(acceptTable4);

        };
    }
}
