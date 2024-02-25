package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity,String> {

	void save(LoginDTO obj);

}
