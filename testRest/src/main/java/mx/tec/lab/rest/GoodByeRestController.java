package mx.tec.lab.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.lab.dto.GoodBye;


@RestController
public class GoodByeRestController {
	private static final String template = "Good bye, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/goodbye")
	public GoodBye goodbye(@RequestParam(value = "name", defaultValue = "World :(")String name)
	{
		return new GoodBye(counter.incrementAndGet(), String.format(template, name));
	}
	

}
