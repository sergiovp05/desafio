package cl.ms.admin.user.be.repository;

import cl.ms.admin.user.be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


    Optional<User> findByEmail(String email);

}
