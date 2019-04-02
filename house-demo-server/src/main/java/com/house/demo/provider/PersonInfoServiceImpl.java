package com.house.demo.provider;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.customer.PersonInfoService;
import com.house.entity.Customer;
import com.house.mapper.CustomerManagementMapper;
import com.house.mapper.PersonInfoManagementMapper;
import com.house.tool.AnalysisXML;
import com.house.tool.FileUtil;
import com.house.tool.PhoneAddressCreate;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
	@Autowired
	PersonInfoManagementMapper personInfoManagementMapper;
	@Autowired
	CustomerManagementMapper customerManagementMapper;
	@Autowired
	AnalysisXML ax;

	@Override
	public String modifyCustomerAge(Customer customer) {
		int result = personInfoManagementMapper.updateAge(customer);
		if (result == 1) {
			return "true";
		} else {
			return "false";
		}
	}

	@Override
	public String modifyCustomerMailbox(Customer customer) {
		int result = personInfoManagementMapper.updateMailbox(customer);
		if (result == 1) {
			return "true";
		} else {
			return "false";
		}
	}

	@Override
	public String modifyCustomerName(Customer customer) {
		int result = personInfoManagementMapper.updateName(customer);
		if (result == 1) {
			return "true";
		} else {
			return "false";
		}
	}

	@Override
	public String modifyCustomerPassword(Customer customer) {
		int result = personInfoManagementMapper.updatePassword(customer);
		if (result == 1) {
			return "true";
		} else {
			return "false";
		}
	}

	@Override
	public String modifyCustomerSex(Customer customer) {
		int result = personInfoManagementMapper.updateSex(customer);
		if (result == 1) {
			return "true";
		} else {
			return "false";
		}
	}

	@Override
	public Customer queryCustomerIdAndCustomerName(Customer customer) {
		return personInfoManagementMapper.selectCustomerIdAndCustomerName(customer);
	}

	@Override
	public Customer queryCustomerInfo(Customer customer) {
		Customer result = personInfoManagementMapper.selectCustomerAllInfoFromId(customer);
		String customerVisitAddress = ax.getName(AnalysisXML.CUSTOMERVISITADDRESS);
		StringBuffer sb = new StringBuffer(customerVisitAddress + result.getCustomerHeadImageAddress());
		result.setCustomerHeadImageAddress(sb.toString());
		return result;
	}

	// 文件上传服务
	@Override
	public String photoUploadService(byte[] arr, String suffix, String id) {
		String result = null;
		Customer customer = new Customer();
		String customerKeepAddress = ax.getName(AnalysisXML.CUSTOMERKEEPADDRESS);
		customer.setCustomerId(id);
		// 根据id去查询图片地址
		String photoAddress;
		// 新的路径
		StringBuffer path = new StringBuffer();
		path.append(customerKeepAddress);
		// 旧的路径
		StringBuffer oldPath = new StringBuffer();
		oldPath.append(customerKeepAddress);
		// 访问路径
		String customerVisitAddress = ax.getName(AnalysisXML.CUSTOMERVISITADDRESS);
		StringBuffer visitPath = new StringBuffer(customerVisitAddress);

		photoAddress = personInfoManagementMapper.selectPhotoAddressFromId(id);

		try {
			if (photoAddress != null) {
				oldPath.append(photoAddress.substring(0, photoAddress.lastIndexOf(".")) + suffix);
				FileUtil.deleteFile(oldPath.toString());
			}
			photoAddress = PhoneAddressCreate.createAddress(id) + suffix;
			path.append(photoAddress);

			visitPath.append(photoAddress);
			customer.setCustomerHeadImageAddress(photoAddress);
			int updateResult = 0;
			updateResult = personInfoManagementMapper.updatePhotoAddressFromId(customer);
			if (updateResult != 0) {
				FileUtil.fileupload(arr, path.toString());
				result = visitPath.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer ifExistAccountNumberReturnMail(Customer customer) {
		return personInfoManagementMapper.selectCustomerIdAndMail(customer);
	}

	@Override
	public boolean ifVip(String customerId) {
		String ifVip = customerManagementMapper.selectCustomerWhetherVipAccordingToId(customerId);
		if("0".equals(ifVip)) {
			return false;
		}else {
			return true;			
		}
	}
	
	

}
