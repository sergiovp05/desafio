package cl.ms.admin.user.be.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_test")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "user_id", nullable = false)
    private UUID id;
    @Column(name="user_name",length = 30 ,nullable = false)
    private String name;

    @Column(name="user_email",length = 30 ,unique = true)
    private String email;

    @Column(name="user_password",length = 100 ,nullable = false)
    private String password;

    @Column(name = "usr_created", nullable = false)
    private LocalDateTime created;

    @Column(name = "usr_modified", nullable = true)
    private LocalDateTime modified;

    @Column(name = "usr_last_login", nullable = false)
    private LocalDateTime lastLogin;

    @Column(name = "usr_token", length = 255, nullable = false)
    private String token;

    @Column(name = "usr_isactive", nullable = false)
    private boolean isactive;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private List<Phone> phones;


}
