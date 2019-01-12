package test;

import org.junit.Test;

import com.house.demo.provider.AnalysisAreaXmlServiceImpl;

public class TestAnalysisAreaXmlServiceImpl {
	@Test
	public void testAnalysisAreaXmlGainProvince() {
		System.out.println(new AnalysisAreaXmlServiceImpl().analysisAreaXmlGainProvince());
	}

	@Test
	public void testAnalysisAreaXmlGainArea() {
		System.out.println(new AnalysisAreaXmlServiceImpl().analysisAreaXmlGainArea("广东省", "梅州市"));

	}

	@Test
	public void testanalysisAreaXmlGainCity() {
		System.out.println(new AnalysisAreaXmlServiceImpl().analysisAreaXmlGainCity("广东省"));
	}
	@Test
	public void testAnalysisAreaXml() {
		System.out.println(new AnalysisAreaXmlServiceImpl().analysisAreaXml());
	}
	@Test
	public void testSortPinyin() {
		System.out.println(new AnalysisAreaXmlServiceImpl().sortPinyin());
	}
}
