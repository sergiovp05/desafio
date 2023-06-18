package cl.ms.admin.user.be.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number", nullable = false, length = 9)
    private String number;
    @Column(name = "phone_city_code", nullable = false, length = 20)
    private String cityCode;
    @Column(name = "phone_contry_code", nullable = false, length = 20)
    private String contryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_user_id")
    private User user;

    public Phone(){

    }
    public Phone(String number,String cityCode,String contryCode,User user){
        this.number=number;
        this.cityCode=cityCode;
        this.contryCode=contryCode;
        this.user=user;
    }
}
