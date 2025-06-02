package com.pikecape.springboot.soap.repository;

import com.pikecape.springboot.soap.Duck;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class DuckRepository {
	private static final Map<Integer, Duck> ducks = new HashMap<>();

	@PostConstruct
	public void initData() {
		Duck duey = new Duck();
		duey.setId(1);
		duey.setName("Duey");
		ducks.put(duey.getId(), duey);

		Duck huey = new Duck();
		huey.setId(2);
		huey.setName("Huey");
		ducks.put(huey.getId(), huey);

		Duck luey = new Duck();
		luey.setId(3);
		luey.setName("Luey");
		ducks.put(luey.getId(), luey);
	}

	public Duck findById(int id) {
		return ducks.get(id);
	}

	public List<Duck> findAll() {
		return ducks.values().stream().toList();
	}
}
