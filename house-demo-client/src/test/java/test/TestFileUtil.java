package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
}
