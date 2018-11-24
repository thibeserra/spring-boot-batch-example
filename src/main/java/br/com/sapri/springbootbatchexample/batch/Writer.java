package br.com.sapri.springbootbatchexample.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.sapri.springbootbatchexample.entity.Users;
import br.com.sapri.springbootbatchexample.repository.UsersRepository;

@Component
public class Writer implements ItemWriter<Users> {

	@Autowired
	private UsersRepository repo;

	@Override
	@Transactional
	public void write(List<? extends Users> users) throws Exception {
		System.out.println("Writer..");
		List<Users> result = (List<Users>) repo.saveAll(users);
		System.out.println("save..");
		System.out.println(result.size());
	}

}