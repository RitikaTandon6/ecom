package com.ecom.ecom.application.Service.UserService;

import com.ecom.ecom.application.Model.UserModel.User;
import com.ecom.ecom.application.Repo.UserRepo.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceCls {

    private final UserRepository userRepository;

    public User saveUser(User user)
    {
       return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser)
    {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        existing.setName(updatedUser.getName());

        existing.setEmail(updatedUser.getEmail());
        existing.setPhoneNumber(updatedUser.getPhoneNumber());
        return userRepository.save(existing);

    }

    public List<User>getAllUser()
    {
        return userRepository.findAll();
    }

    public User getUserById(Long id)
    {
        Optional<User> user1 =  userRepository.findById(id);
        return user1.orElse(null);
    }
    public User partialUpdate(Long id, Map<String,Object> fields) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            for (Map.Entry<String, Object> mp : fields.entrySet()) {
                if (mp.getKey().equals("name"))
                    user.setName((mp.getValue().toString()));
                else if (mp.getKey().equalsIgnoreCase("city"))
                    user.setPhoneNumber(mp.getValue().toString());
                else if (mp.getKey().equalsIgnoreCase("pincode"))
                    user.setEmail(mp.getValue().toString());

            }

        }
return  userRepository.save(user);
    }
}
