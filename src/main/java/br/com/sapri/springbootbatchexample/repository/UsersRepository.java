package br.com.sapri.springbootbatchexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sapri.springbootbatchexample.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
}
