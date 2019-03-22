package com.house.control;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.collection.CollectionService;
import com.house.entity.Collection;
import com.house.entity.Customer;
import com.house.entity.Page;

@Controller
@RequestMapping("/house")
public class CollectionController {
	@Reference
	CollectionService collectionService;
	@RequestMapping("/judge/collection/state")
	@ResponseBody
	public boolean judgeHouseCollectionState(Collection collection,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		if(customer == null) {
			return false;
		}else {
			collection.setCollectorsId(customer.getCustomerId());
		}
	return collectionService.judgeHouseAleardyCollection(collection);
	}
	
	@RequestMapping("/modify/collection/state")
	@ResponseBody
	public Map<String,String> modifyCollectionState(Collection collection, String modify,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		Map<String,String> map = new HashMap<String,String>();
		String result = null;
		if(customer == null) {
			result =  "login";
		}else {
		collection.setCollectorsId(customer.getCustomerId());
		if("0".equals(modify)) {
			result = collectionService.addHouseCollectionInformation(collection);
		}else {
			result = collectionService.cancelHouseCollectionInformation(collection);
		}
		map.put("result", result);
		
	}
		return map;
	}
	@RequestMapping("/load/collection")
	@ResponseBody
	public Map<String,Object> loadCollectionHouseInfo(HttpSession session,@RequestParam(required = false) Integer pageCurrent) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		Map<String,Object> map = new HashMap<String,Object>();
		Page page = new Page();
		if (pageCurrent != null) {
			page.setPageCurrent(pageCurrent);
		}
		if(customer == null) {
			map.put("result",false);
			return map;
		}else {
	     map = collectionService.loadCollectionInformation(customer.getCustomerId(),page);
	     map.put("result",true);
			return map;
		}
	};
	
	
}
