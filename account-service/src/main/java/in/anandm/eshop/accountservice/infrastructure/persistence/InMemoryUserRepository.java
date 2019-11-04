package in.anandm.eshop.accountservice.infrastructure.persistence;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import in.anandm.eshop.accountservice.model.Address;
import in.anandm.eshop.accountservice.model.User;
import in.anandm.eshop.accountservice.model.UserRepository;

public class InMemoryUserRepository implements UserRepository {

	private AtomicLong nextUserId = new AtomicLong(0);
	private AtomicLong nextAddressId = new AtomicLong(0);

	private Map<String, User> emailMap = new ConcurrentHashMap<>();
	private Map<Long, User> idMap = new ConcurrentHashMap<>();

	@Override
	public User findByEmail(String email) {

		return copy(emailMap.get(email));
	}

	@Override
	public User findById(long id) {

		return copy(idMap.get(id));
	}

	@Override
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(nextUserId.incrementAndGet());
		}

		user.setAddress(user.getAddress().stream().filter(a -> (a.getId() == null || a.getUserId() == null)).map(aa -> {
			aa.setId(nextAddressId.incrementAndGet());
			aa.setUserId(user.getId());
			return aa;
		}).collect(Collectors.toList()));

		User userCopy = copy(user);

		idMap.put(user.getId(), userCopy);
		emailMap.put(user.getEmail(), userCopy);

		return user;
	}

	@Override
	public void deleteById(long userId) {
		User found = idMap.get(userId);
		if (found != null) {
			idMap.remove(found.getId());
			emailMap.remove(found.getEmail());
		}
	}

	private User copy(User user) {
		if (user == null) {
			return null;
		}

		User copy = new User();

		copy.setId(user.getId());
		copy.setEmail(user.getEmail());
		copy.setPassword(user.getPassword());
		copy.setDisplayName(user.getDisplayName());

		copy.setAddress(copy.getAddress().stream().map(this::copy).collect(Collectors.toList()));

		return copy;
	}

	private Address copy(Address address) {
		if (address == null) {
			return null;
		}

		Address copy = new Address();

		copy.setAddressLine1(address.getAddressLine1());
		copy.setAddressLine2(address.getAddressLine2());
		copy.setAddressLine3(address.getAddressLine3());
		copy.setCity(address.getCity());
		copy.setContactNumber(address.getContactNumber());
		copy.setCountry(address.getCountry());
		copy.setHomeAddress(address.isHomeAddress());
		copy.setId(address.getId());
		copy.setState(address.getState());
		copy.setUserId(address.getUserId());
		copy.setZip(address.getZip());

		return copy;
	}
}
