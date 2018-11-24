package br.com.sapri.springbootbatchexample.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sapri.springbootbatchexample.entity.Users;
import br.com.sapri.springbootbatchexample.repository.UsersRepository;

@Component
public class Processor implements ItemProcessor<Users, Users> {

	@Autowired
	private UsersRepository userRepo;

	@Override
	public Users process(Users user) throws Exception {
		Optional<Users> userFromDb = userRepo.findById(user.getUserId());
		if (userFromDb.isPresent()) {
			user.setAccount(user.getAccount().add(userFromDb.get().getAccount()));
		}

		return user;
	}

}
