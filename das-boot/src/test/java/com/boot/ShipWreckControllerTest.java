package com.boot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.boot.controller.ShipWreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepository;

public class ShipWreckControllerTest {
	
	@InjectMocks
	private ShipWreckController sc;
	
	@Mock
	private ShipWreckRepository repo;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void get(){
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setId(1l);
		when(repo.findOne(1l)).thenReturn(shipwreck);
		Shipwreck shipwreck1 = sc.get(1l);
		verify(repo).findOne(1L);
		
		//assertEquals(1l,shipwreck1.getId().longValue());
		
		assertThat(shipwreck1.getId(), is(1l));
	}
}
