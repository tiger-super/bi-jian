package com.house.control;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/house")
public class HelloWorldServlet {
	@ResponseBody
	@RequestMapping("/test/one")
	public String testOne() {
		return "测试一号";
	}
	@RequestMapping("/test/two")
	public String testTwo() {
		return "test-two";
	}
	@RequestMapping("/test/three")
	public String testThree() {
		return "test-three";
	}
	@RequestMapping("/test/four")
	public String testFour() {
		return "test-four";
	}
	@RequestMapping("/test/five")
	public String testFive() {
		return "test-five";
	}
}
