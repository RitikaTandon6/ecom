package com.ecom.ecom.application.Controller.UserController;

import com.ecom.ecom.application.Model.UserModel.User;
import com.ecom.ecom.application.Service.UserService.UserServiceCls;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserControllerCls {

    private final UserServiceCls userServiceCls;
//    private static Logger logger=LoggerFactory.getLogger(UserServiceCls.class);

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id)
    {
     //  logger.info("USer request called "+id);
       //logger.trace("Trace for user");
       //logger.debug("Debug");
        //logger.warn("Something wennt faile");
        //log.debug();
        //log.trace();
        return userServiceCls.getUserById(id);
    }
    @GetMapping("/getAllUsers")
    public List<User> getUser()
    {
        return userServiceCls.getAllUser();
    }
    @PostMapping("/saveUser")
    public User saveUser( @RequestBody User user)
    {
        return userServiceCls.saveUser(user);
    }
    @PutMapping("/updateUser/{id}")
    public User updateUser( @RequestBody User user, @PathVariable Long id)
    {
        return userServiceCls.updateUser(id,user);
    }
    @PatchMapping ("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody Map<String, Object> fieldsUpdate)
    {
        User user=userServiceCls.getUserById(id);
        return userServiceCls.updateUser(id,user);
    }


}
