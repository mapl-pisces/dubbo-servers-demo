package com.ai.saas.comment.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jcraft.jsch.SftpException;

/**
 * @author renfeng3
 * @create on 2016年4月26日 
 */
public class CreateHtmlFileUtil {
	
	
	@SuppressWarnings({ "null", "unused" })
	public static boolean createCaiPingHtml(List<?> list) throws IOException, SftpException{
		Properties properties = ReadPropertiesUtil.getProperties("/context/sftp.properties");
		String toPath = properties.getProperty("dishesdetailpath");
		
		InputStream in = CreateHtmlFileUtil.class.getResourceAsStream("/htmlmodel/dishesdetailmodel.html");  
		BufferedReader bf = new BufferedReader(new InputStreamReader(in,"utf-8"));
		StringBuilder sb = new StringBuilder();
		String line=null;
		while((line=bf.readLine())!=null){
			sb.append(line);
			sb.append("\r\n");
		}
		bf.close();
		in.close();
		System.out.println(sb.toString());
		for(Object str:list){
			line.replaceAll("原始值", "值");
		}
		
		SftpUploadUtil.sftpUploadStr(sb.toString(), toPath);
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException, SftpException {
		createCaiPingHtml(new ArrayList());
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
