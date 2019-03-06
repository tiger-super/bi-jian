package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.house.tool.PinyinComparator;

import net.sourceforge.pinyin4j.PinyinHelper;
public class TestPinyin {
    @Test
    public void test() {
    	char c = '重';
    	String[] s = PinyinHelper.toHanyuPinyinStringArray(c);
    	for(int i = 0 ;i < s.length ; i++) {
    		System.out.println(s[i]);
    	}
    	System.out.println(s[0].substring(0, 1));
    }
    @Test
    public void testGetStringArray() {
    	List<String> list = new ArrayList<String>();
    	list.add("1");
    	list.add("2");
    	String[] s =  PinyinComparator.getStringArray(list);
    	for(int i = 0 ;i < s.length ; i++) {
    		System.out.println(s[i]);
    	}
    }

    @Test
    public void testSet() {
    	Set<String> set = new HashSet<String>();
    	set.add("g");
    	set.add("a");
    	set.add("f");
    	set.add("h");
    	System.out.println(set);
    }
    
    @Test
    public void testMap() {
    	 Map<String, String> map = new LinkedHashMap<String,String>();
    	 map.put("xx", "xxxx");
    	 System.out.println(map);
    	 map.put("xx", "xx");
    	 System.out.println(map);
    	 System.out.println(Math.ceil((double)22/4));
    }
    
}


