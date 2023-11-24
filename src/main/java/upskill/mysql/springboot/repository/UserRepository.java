package upskill.mysql.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.mysql.springboot.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

