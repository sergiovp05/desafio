package cl.ms.admin.user.be.repository;

import cl.ms.admin.user.be.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PhoneRepository extends JpaRepository<Phone,Long> {

    @Query("select ph from Phone ph where ph.user=:userId")
    Optional<Phone> findByIdUser(@Param("userId")UUID idUser);
    @Query("select ph from Phone ph where ph.user =:userId and ph.id=:id")
    Optional<Phone>findByIdUserIdPhone(@Param("userId") UUID idUser, @Param("id")Long id);
}
