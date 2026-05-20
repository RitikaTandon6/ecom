package com.ecom.ecom.application.Repo.UserRepo;

import com.ecom.ecom.application.Model.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
