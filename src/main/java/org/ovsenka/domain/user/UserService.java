package org.ovsenka.domain.user;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public String create(NewUser user) {
        return userRepository.create(user);
    }

}
