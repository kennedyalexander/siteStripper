package com.slotMachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.slotMachine.Application;
import com.slotMachine.ApplicationIT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationIT {

	@Test
	public void applicationContext() {
		// intentionally left blank
	}
	
	public void sampleTest(){
//	    SomeService service = mock(SomeService.class);
//	    MyComponent component = new MyComponent(service);
	}
}
