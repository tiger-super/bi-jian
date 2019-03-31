package com.house.control;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.house.demo.pay.PayService;
import com.house.entity.Customer;
import com.house.entity.Pay;
import com.house.pay.config.AlipayConfig;
import com.house.tool.PhoneAddressCreate;

@Controller
@RequestMapping("/house")
public class PayController {
	@Reference
	PayService payService;
	@Autowired
	ViewJumpController vj;
	@RequestMapping("/session/show/pay/view")
     public ModelAndView showPayView(String money,String day,HttpSession session,HttpServletResponse response) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		Pay pay = new Pay();
		pay.setPayMoney(money);
        pay.setPayId(PhoneAddressCreate.createAddress()); 
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("pay/pay");
		mv.addObject("pay", pay);
		Cookie customerId = new Cookie("customerId",customer.getCustomerId());
		customerId.setPath("/");
		response.addCookie(customerId);
		return mv;
     }
	@RequestMapping("/show/notify")
    public String showNotify() {
   	 return "pay/notify-url";
    }
	@RequestMapping("/show/page/pay")
    public String showPagePay() {
   	 return "pay/page-pay";
    }
	@RequestMapping("/show/return")
    public String showReturn(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
		
			Pay pay = new Pay();
			pay.setPayMoney(total_amount);
	        pay.setPayId(out_trade_no); 
	        Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					switch (cookie.getName()) {
					case "customerId":
						 pay.setPayPeopleId(cookie.getValue()); 
						break;
					}
				}
			}
			payService.handlePay(pay);
		 } 
		 return vj.showIndex();
	}
	@RequestMapping("/session/show/vip/view")
    public String showVipView() {
   	 return "vip";
    }
}
