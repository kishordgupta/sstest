package com.codahale.shamir;
import com.codahale.shamir.Scheme;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;
import java.util.Random;

class Example {
	  public static void main(String[] args) {
		  simulation();
  } 
	 void checkcoolison()
	 {
		 try {
			FileReader fr=new FileReader("out.txt");
			
			checkcoolison(fr);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	  static void simulation()
	  {
		  int i = 0;
		  FileWriter fw;
		try {
			fw = new FileWriter("out.txt");
		
		  
			
		
		 while(true)
		 {fw.write(ks(i)+"\n");
			 ;
			 i++;
			 if(i>1000000)break;
		 }
		
			fw.close();} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	  }
	  static String ks(int i)
	  {
		  String pass = i+sd();
		    final Scheme scheme = new Scheme(new SecureRandom(), 254, 230);
		    final byte[] secret = pass.getBytes(StandardCharsets.UTF_8);
		    final Map<Integer, byte[]> parts = scheme.split(secret);
		    int p=0;
		    String or= "";
		    for (byte[] key : parts.values()) {
		    	if(p>220)break;
		    	p++;
		    	or=or+Base64.getEncoder().encodeToString(key);
		    }
		    return or;
		  //  System.out.println(or);
	  }
	  public static String sd() {
		    byte[] array = new byte[7]; // length is bounded by 7
		    new Random().nextBytes(array);
		    String generatedString = new String(array, Charset.forName("UTF-8"));
		  return generatedString;
		    
		}
}
