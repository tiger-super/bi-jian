package test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.util.ClassUtils;
import com.house.tool.PhoneAddressCreate;

public class TestPath {
    @Test
    public void test() {
    
    	String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"/static/customerPhoto/" ;
    
    	/*File file = new File(path);*/
    	File file = new File("src/static/customerPhoto");
    	System.out.println(path);	
        System.out.println(file.exists());
       /* if(!file.exists()) {
			file.mkdirs();
		}
        */
    }
    
    @Test
    
    public void test1() {
    	File directory = new File("");//设定为当前文件夹
    	try{
    	    System.out.println(directory.getCanonicalPath());//获取标准的路径
    	    System.out.println(directory.getAbsolutePath());//获取绝对路径
    	}catch(Exception e){
    		
    	}
    }
    @Test
    public void test2() throws IOException {
    	File f = new File(new File("").getCanonicalPath()+"/src/static/customerPhoto/");
    	System.out.println(f.exists());
    }
    @Test
    public void test3() {
    	System.out.println(PhoneAddressCreate.createAddress("1"));
    }
}
