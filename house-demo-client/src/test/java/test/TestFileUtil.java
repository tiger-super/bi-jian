package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import com.house.entity.Page;
import com.house.tool.FileUtil;

public class TestFileUtil {
@Test
public void testReadCacheImg() {
	List<byte[]> list = new ArrayList<byte[]>();
	try {
		FileUtil.readCacheImg("1548838613182",list);
	} catch (IOException e) {
		e.printStackTrace();
	}
	byte[] b = list.get(0);
	for(int i = 0; i < b.length ; i++) {
		System.out.print(b[i]); 
	}
}
@Test
public void testList() throws IOException {
	List<String> list = new ArrayList<String>();
	File file = new File(new File("").getCanonicalPath()+"/src/main/resources/static/uploadcache/1549682220209");
	String[] s = file.list();
	for(int i = 0 ; i < s.length; i++) {
		System.out.println(s[i]);
	}
}
@Test
public void testPageShow() {
	for(int j = 1; j <=20;j++) {
	int max = j;
	Page page = new Page();
	page.setPageMax(max);
	for(int i = 1 ; i <= max ; i ++) {
		page.setPageCurrent(i);
		List<String> list = com.house.tool.PageShow.handlePage(page);
		System.out.println("点弟"+i+"页"+list);
	}
	System.out.println("=========================================");
	}  
}
}