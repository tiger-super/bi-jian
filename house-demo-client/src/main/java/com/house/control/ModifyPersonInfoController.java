	package com.house.control;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.customer.PersonInfoService;
import com.house.entity.Customer;

@Controller
@RequestMapping("/house/session")
public class ModifyPersonInfoController {
	@Reference
	private PersonInfoService personInfoService;
	// 获得session对象
	@RequestMapping("/gain/object")
	@ResponseBody
	public Customer gainSessionObject(HttpSession session) {
		return  (Customer) session.getAttribute("customerSession");
	}
	
	
	// 修改用户名
	@RequestMapping("/modify/customerName")
	@ResponseBody
	public String modifyCustomerName(Customer customer,HttpSession session) {
		Customer customerSession = (Customer) session.getAttribute("customerSession");
		customer.setCustomerId(customerSession.getCustomerId());
		String result =  personInfoService.modifyCustomerName(customer);
		if("true".equals(result)) {
			customerSession.setCustomerName(customer.getCustomerName());
			session.setAttribute("customerSession",customerSession);
		}
		return result;
	}

	// 修改用户年龄
	@RequestMapping("/modify/customerAge")
	@ResponseBody
	public String modifyCustomerAge(Customer customer,HttpSession session) {
		Customer customerSession = (Customer) session.getAttribute("customerSession");
		customer.setCustomerId(customerSession.getCustomerId());
		return  personInfoService.modifyCustomerAge(customer);
	}

	// 修改用户性别
	@RequestMapping("/modify/customerSex")
	@ResponseBody
	public String modifyCustomerSex(Customer customer,HttpSession session) {
		Customer customerSession = (Customer) session.getAttribute("customerSession");
		customer.setCustomerId(customerSession.getCustomerId());
		return  personInfoService.modifyCustomerSex(customer);
	}

	// 修改用户邮箱
	@RequestMapping("/modify/customerMailbox")
	@ResponseBody
	public String modifyCustomerMailbox(Customer customer,HttpSession session) {
		Customer customerSession = (Customer) session.getAttribute("customerSession");
		customer.setCustomerId(customerSession.getCustomerId());
		return  personInfoService.modifyCustomerMailbox(customer);
	}
	
	// 照片上传
	@RequestMapping("/photo/upload")
	@ResponseBody
	public String photoUpload(@RequestParam("photoFile") MultipartFile photoFile,HttpSession session) throws IOException {
		// 获取文件名称,包含后缀
		String fileName = photoFile.getOriginalFilename();
		// 获得后缀
		String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		Customer customer = (Customer) session.getAttribute("customerSession");
		return personInfoService.photoUploadService(photoFile.getBytes(), suffix, customer.getCustomerId());
	}

}
