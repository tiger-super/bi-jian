package com.house.control;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/house")
public class TestController {
	@RequestMapping("/test")
	@ResponseBody
	public void judgeHouseCollectionState() {
		File file = new File("/usr/tomcat/tomcat8.5/webapps/publish-house-img/11549690311179");
        String[] s = file.list();
        for(int i= 0 ;i <s.length;i++) {
        	System.out.println(s[i]);
        }
	}

}
