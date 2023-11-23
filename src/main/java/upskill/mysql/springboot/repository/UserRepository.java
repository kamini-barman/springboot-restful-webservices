package upskill.mysql.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.mysql.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

