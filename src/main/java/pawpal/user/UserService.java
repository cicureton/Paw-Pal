package pawpal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User updatedUser = user.get();
            updatedUser.setUsername(userDetails.getUsername());
            updatedUser.setEmail(userDetails.getEmail());
            updatedUser.setPassword(userDetails.getPassword());
            updatedUser.setFirstName(userDetails.getFirstName());
            updatedUser.setLastName(userDetails.getLastName());
            updatedUser.setRole(userDetails.getRole());
            updatedUser.setStatus(userDetails.getStatus());
            updatedUser.setUpdatedAt(userDetails.getUpdatedAt());
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

