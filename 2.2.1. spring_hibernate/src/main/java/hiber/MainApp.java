package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car(1, "Volga");
      Car car2 = new Car(2, "BMW");
      Car car3 = new Car(3, "Lada");
      Car car4 = new Car(4, "Audi");

      User user1  = new User("Name1", "LastName1", "name1@email.com", car1);
      User user2  = new User("Name2", "LastName2", "name2@email.com", car2);
      User user3  = new User("Name3", "LastName3", "name3@email.com", car3);
      User user4  = new User("Name4", "LastName4", "name4@email.com", car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      userService.findUser(car3);
      userService.findUser(car1);
      userService.findUser(car4);
      userService.findUser(car2);

      context.close();
   }
}
