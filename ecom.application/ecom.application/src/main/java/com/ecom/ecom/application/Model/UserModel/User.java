package com.ecom.ecom.application.Model.UserModel;

import com.ecom.ecom.application.Model.AddressModel.Address;
import com.ecom.ecom.application.UserRole.UserRoleEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String name;
    private String phoneNumber;
    private UserRoleEnum userRoleEnum=UserRoleEnum.BasicUser;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

}
