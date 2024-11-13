package com.shopnbuy.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	@Autowired
	private RoleRepository repo;
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin","manage everything");
		Role savedRole = repo.save(roleAdmin);
		
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	
	@Test
	public void testCreateRestRole() {
		Role roleSales = new Role("Salesperson","manage product price" + 
	"customers, shipping & orders");
		
		Role roleEditor = new Role("Editor","manage categories, brands" + 
				"products, orders & menus");
		
		Role roleShipper = new Role("Shipper","views products, order" + 
				"and update order status");
		
		Role roleAssistent = new Role("Assistent","manages questions & reviews");
		repo.saveAll(List.of(roleSales,roleEditor, roleShipper,roleAssistent ));
		
	/*	Role savedRole = repo.save(roleSales);
		
		assertThat(savedRole.getId()).isGreaterThan(0);*/
	}
}
