package com.house.demo.provider;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.customer.PersonInfoService;
import com.house.entity.Customer;
import com.house.mapper.PersonInfoManagementMapper;
import com.house.tool.FileUtil;
import com.house.tool.PhoneAddressCreate;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
	@Autowired
	PersonInfoManagementMapper personInfoManagementMapper;

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

		return personInfoManagementMapper.selectCustomerAllInfoFromId(customer);
	}

	// 文件上传服务
	@Override
	public String photoUploadService(byte[] arr, String suffix,String id) {
		Customer customer = new Customer();
		customer.setCustomerId(id);
		// 根据id去查询图片地址
		String photoAddress;
		int result = 0;
        // 本地路径
		StringBuffer path = new StringBuffer(); 
        // 类路径
		StringBuffer classPath = new StringBuffer();
     
		photoAddress = personInfoManagementMapper.selectPhotoAddressFromId(id);
		try {
			path.append(new File("").getCanonicalPath()+"/src/main/resources/static/customerPhoto/");
			classPath.append(ClassUtils.getDefaultClassLoader().getResource("").getPath()+"/static/customerPhoto/");
			if (photoAddress != null) {
				 // 旧的本地路径
				StringBuffer oldPath = new StringBuffer(); 
		        // 旧的类路径
				StringBuffer oldClassPath = new StringBuffer();
				 oldPath.append(path.toString()).append(photoAddress.substring(0, photoAddress.lastIndexOf("."))+suffix);
				 oldClassPath.append(classPath.toString()).append(photoAddress.substring(0, photoAddress.lastIndexOf("."))+suffix);
				// 删除之前的文件
				FileUtil.deleteFile(oldPath.toString());
				FileUtil.deleteFile(oldClassPath.toString());
			} 
				photoAddress = PhoneAddressCreate.createAddress(id) + suffix;
				path.append(photoAddress);
				classPath.append(photoAddress);
				customer.setCustomerHeadImageAddress(photoAddress);
			
			FileUtil.fileupload(arr, path.toString());
			FileUtil.fileupload(arr, classPath.toString());
			result =  personInfoManagementMapper.updatePhotoAddressFromId(customer);
		} catch (IOException e) {
			e.printStackTrace();

		}
		if (result != 0) {
			return customer.getCustomerHeadImageAddress();
		} else {
			return "false";
		}
	}

	@Override
	public Customer ifExistAccountNumberReturnMail(Customer customer) {
		return personInfoManagementMapper.selectCustomerIdAndMail(customer);
	}

}
