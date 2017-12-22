package cn.codeforfun;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Repository
interface UserRepository extends JpaRepository<User, Integer> {

}

/**
 * Package cn.codeforfun
 * Project test
 * Email 253498229@qq.com
 *
 * @author WangBin
 * @version 1.0.0
 * @date Created on 2017/12/22 上午11:05
 */
@SpringBootApplication
public class App {
  public static void main(String[] args) {
    new SpringApplicationBuilder(App.class).run(args);
  }
}

@Entity
@Table
@Data
class User {
  @Id
  @GeneratedValue
  private Integer id;
  private String username;
  private String password;
}

@RestController
class UserController {
  @Resource
  private UserRepository userRepository;

  @GetMapping("/user/list")
  public List<User> userList() {
    return userRepository.findAll();
  }
}