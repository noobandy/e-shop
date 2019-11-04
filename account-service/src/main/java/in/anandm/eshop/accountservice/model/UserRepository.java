package in.anandm.eshop.accountservice.model;

public interface UserRepository {

	User findByEmail(String email);
	
	User findById(long id);
	
	User save(User user);
	
	void deleteById(long userId);
	
	
}
