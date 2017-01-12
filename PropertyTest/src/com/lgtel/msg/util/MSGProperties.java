package com.lgtel.msg.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MSGProperties extends Properties
{
	public static String[] MmsHubIP = null;
	public static int MmsHubPort = 0;
	public static int MmsHubSendSecCount = 0;
	public static int arrSecSendCnt[] = new int[60];
	public static int MmsHubSendCurrCount = 0;
	
	public static MSGProperties instance = null;
	
	private MSGProperties(String cfgPath)
	{
		String fileName = null;
		
		if (cfgPath != null && !cfgPath.equals(""))
		{
			fileName = cfgPath;
		}
		else
		{
			System.out.println("filePath is null");
			return;
		}
		
		try
		{
			FileInputStream in = new FileInputStream(fileName);
			this.load(in);
			
			MmsHubIP = this.getProperty("MmsHubIP").split(",");
			MmsHubPort = Integer.parseInt(this.getProperty("MmsHubPort"));
			MmsHubSendSecCount = Integer.parseInt(this.getProperty("MmsHubSendSecCount"));
			
			for (int i = 0; i < 60; i++)
			{
				arrSecSendCnt[i] = 0;
			}
			in.close();
		}
		catch(FileNotFoundException fnfx)
		{
			fnfx.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public synchronized static MSGProperties getInstance(String cfgPath)
	{
		if (instance == null)
		{
			instance = new MSGProperties(cfgPath);
		}
		
		return instance;
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		MSGProperties msgPro = new MSGProperties(System.getProperty("user.dir")+"/config/mmsConfig.properties");
		
		System.out.println(msgPro.getProperty("MmsHubIP"));
	}
}
