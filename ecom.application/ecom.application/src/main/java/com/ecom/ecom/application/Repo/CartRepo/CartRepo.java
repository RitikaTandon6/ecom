package com.ecom.ecom.application.Repo.CartRepo;

import com.ecom.ecom.application.Model.CArt.Cart;
import com.ecom.ecom.application.Model.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

    @Query("SELECT c FROM Cart c WHERE c.user.name = :name")
    List<Cart> findAllByUserUsername(@Param("name") String username);
}
