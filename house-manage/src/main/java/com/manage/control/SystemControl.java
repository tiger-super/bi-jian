package com.manage.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.entity.Page;
import com.manage.tool.PageShow;

@Controller
@RequestMapping("/manage")
public class SystemControl {
	@RequestMapping("/get/show/page")
	@ResponseBody
	public List<String> getShowPage(Page page) {
		return PageShow.handlePage(page);
	}
}
