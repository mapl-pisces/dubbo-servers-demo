package com.ai.saas.comment.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpUploadUtil {
		
	private static ChannelSftp sftp =null;
	static {
		try {
			Properties properties = ReadPropertiesUtil.getProperties("/context/sftp.properties");
			String host=properties.getProperty("host");
			int port=Integer.parseInt(properties.getProperty("port"));
			String username=properties.getProperty("username");
			String pwd=properties.getProperty("pwd");
			
			JSch jsch = new JSch();
			Session sshSession = jsch.getSession(username, host,port);
			System.out.println("Session created.");
			sshSession.setPassword(pwd);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			System.out.println("Session connected.");
			System.out.println("Opening Channel.");
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * sftp上传str
	 * @param src
	 * @param toPath
	 * @throws SftpException
	 * @throws IOException
	 */
	public static void sftpUploadStr(String src,String toPath) throws SftpException, IOException{
		ByteArrayInputStream bis = new ByteArrayInputStream(src.getBytes("utf-8")); 
		sftp.put(bis, toPath);
		bis.close();
		sftp.disconnect();
		sftp.quit();
	}
	/**
	 * sftp上传图片
	 * @param src
	 * @param toPath
	 * @throws SftpException
	 * @throws IOException
	 */
	public static void sftpUpload(InputStream src,String toPath) throws SftpException, IOException{
		sftp.put(src, toPath);
		src.close();
		sftp.disconnect();
		sftp.quit();
	}
	

	public static void main(String[] args) throws SftpException, IOException, JSchException {
		sftpUploadStr("你好a","/usr/wsddevusr1/target/a.properties");
		System.exit(0);
	}
	
	
	
}
