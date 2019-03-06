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
	
	@Reference(version="1.0.0")
	DemoService demoService ;
	
	@Test
	 public void say() {
	    	System.out.println(demoService.sayHello("tiger"));
	    }
    @Test
    public void test1() {
    	String s = "s5df435sdf4.jpg";
    	System.out.println(s.substring(0,s.lastIndexOf(".")));
    }
}
