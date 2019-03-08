package TestTool;
import org.junit.Test;
import com.manage.tool.AnalysisXML;

public class TestAnalysisXML {
	AnalysisXML ax = new AnalysisXML();

	@Test
	public void testGetXMLContent(){
	double d = (double)10/3;
	int x = (int)Math.ceil(d);
	System.out.println(x);
	    
	}
}

