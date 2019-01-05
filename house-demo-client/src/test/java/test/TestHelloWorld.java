package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.CoumterApplication;
import com.house.control.HelloWorldServlet;
import com.house.demo.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CoumterApplication.class)
public class TestHelloWorld {
	@Autowired
	HelloWorldServlet helloWorldServlet;
    // 测试HelloWorld
	@Test
	public void test() {
		System.out.println(helloWorldServlet.say());
	}
	
	@Reference(version="1.0.0")
	DemoService demoService ;
	
	@Test
	 public void say() {
	    	System.out.println(demoService.sayHello("tiger"));
	    }

}
