package mods.Cyphereion.RealisticDeaths;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Network {
	
	/**
	 * Used to download a file.
	 * @param URL
	 * @param FileName
	 */
	public static void downloadFile(String URL, String FileName){
		try{
			URL url = new URL(URL);
			ReadableByteChannel rbc = Channels.newChannel(url.openStream());
			FileOutputStream fos = new FileOutputStream(FileName);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to check a single line of the file for something.
	 * @param fileName
	 * @param checkfor
	 * @return
	 */
	public static boolean checkSingleFile(String fileName, String checkfor){
		String s = "";
		try{
			s = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
		}catch(Exception e){
			e.printStackTrace();
		}
		List<String> list = Arrays.asList(s.split(","));
		for(int i = 0; i<=list.size(); i++){
			if(list.contains(checkfor)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Used to gather the users external IP Address.
	 * @return
	 * @throws Exception
	 */
	public String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	/**
	 * Used to check if the users IP is equal to the one provided.
	 * @param IP
	 * @return
	 */
	public boolean checkIp(String IP){
    	boolean t = false;
    	try{
            if(getIp().equals(IP)){
            	t = true;
            }else{
            	t = false;
            }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return t;
    }
	
	/**
	 * Opens a website with the given url in the default web browser.
	 * @param url
	 */
	public static void openWebsiteInDefaultBrowser(String url){
		if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	}

}
