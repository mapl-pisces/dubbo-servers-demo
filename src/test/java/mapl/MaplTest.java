package mapl;


import java.io.IOException;
import java.net.URISyntaxException;

import com.ai.saas.comment.utils.HttpClientUtil;



public class MaplTest {


	
	
	
	public static void main(String[] args) throws Exception{
		getDemoTableTest();
		getDemoTableExtraTest();
	
		
	}
	
	public static void getDemoTableTest() throws IOException, URISyntaxException{
		String service = "http://127.0.0.1:20166/comment";
		String url = "/demoApi/getDemoTable";
		String result = HttpClientUtil.sendPostRequest(service + url, "1");
		System.out.println("MAIN return :" + result);
	}
	
	public static void getDemoTableExtraTest() throws IOException, URISyntaxException{
		String service = "http://127.0.0.1:20166/comment";
		String url = "/demoApi/getDemoTableExtra";
		String result = HttpClientUtil.sendPostRequest(service + url, "2");
		System.out.println("MAIN return :" + result);
	}
	
}
