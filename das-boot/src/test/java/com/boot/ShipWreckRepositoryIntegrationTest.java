package com.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import com.boot.model.*;
import com.boot.repository.ShipWreckRepository;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ShipWreckRepositoryIntegrationTest {
	
	@Autowired
	ShipWreckRepository shipwreckRepository;
	
	@Test
	public void findAll(){
		
		
		List<Shipwreck> wrecks = shipwreckRepository.findAll();
		assertThat(wrecks.size(),is(greaterThanOrEqualTo(0)));
		
	}

}
