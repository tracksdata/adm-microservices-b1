package com.cts.flight;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Receiver {

	@RabbitListener(queues = "TestQ1")
	//@RequestMapping("/getData")
	public void getData(String msg) {
		System.out.println(">>>>>>>>>>> Getting data from TestQ1 <<<<<<<<<<");
		System.out.println("Message: " + msg);
	}

}
