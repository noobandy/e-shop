package in.anandm.eshop.accountservice.service;

import org.eshop.core.security.PasswordEncoder;

import in.anandm.eshop.accountservice.model.User;
import in.anandm.eshop.accountservice.model.UserRepository;

public class UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User registerUser(String email, String password, String displayName) {
		User existingUser = userRepository.findByEmail(email);

		if (existingUser != null) {
			throw new EmailAlreadyInUseException("Email id " + email + " is already in use.");
		}

		User user = new User();
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		user.setDisplayName(displayName);

		user = userRepository.save(user);
		return user;
	}

	public User validateLogin(String email, String password) {
		User foundUser = userRepository.findByEmail(email);

		if (foundUser != null && foundUser.getPassword().equals(passwordEncoder.encode(password))) {
			return foundUser;
		}

		return null;

	}

	public void changePassword(long userId, String currentPassword, String newPassword) {
		User foundUser = userRepository.findById(userId);

		if (foundUser == null) {
			throw new UserNotFoundException("user with userId " + userId + " not found.");
		}

		if (foundUser.getPassword().equals(passwordEncoder.encode(currentPassword))) {
			foundUser.setPassword(passwordEncoder.encode(newPassword));
		}
	}
}
