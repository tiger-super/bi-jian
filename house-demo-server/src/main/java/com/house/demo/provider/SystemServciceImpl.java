package com.house.demo.provider;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.system.SystemService;
import com.house.tool.AnalysisXML;
import com.house.tool.FileUtil;
@Service
public class SystemServciceImpl implements SystemService {
@Autowired
AnalysisXML ax;
	@Override
	public void deleteCache(String folder) {
		String address = ax.getName(AnalysisXML.HOUSECACHEKEEP);
		FileUtil.deleteFile(folder,address);
	}

}
