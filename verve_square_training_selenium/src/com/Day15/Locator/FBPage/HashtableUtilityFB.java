package com.Day15.Locator.FBPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

public class HashtableUtilityFB 
{
	
		//Random class
		Random objRandom = new Random();
			
			public String getRandomFirstName(int intLength)
			{
				String name = "abcdefghijklmnopqrstuvwxyz";
				String randomChar ="abc_";
				for (int i = 0; i < intLength; i++) 
				{
					int randomindex = (int) (Math.random()*name.length());
					randomChar = randomChar + name.substring(randomindex, randomindex+1);
					
				}
				return randomChar;
			}
			public String getRandomLirstName(int intLength)
			{
				String name = "abcdefghijklmnopqrstuvwxyz";
				String randomChar ="xyz_";
				for (int i = 0; i < intLength; i++) 
				{
					int randomindex = (int) (Math.random()*name.length());
					randomChar = randomChar + name.substring(randomindex, randomindex+1);
					
				}
				return randomChar;
			}
			
			public String getRandomEmail()
			{
				String name = "abcdefghijklmnopqrstuvwxyz";
				String randomMail ="";
				for (int i = 0; i < 10; i++) 
				{
					int randomindex = (int) (Math.random()*name.length());
					randomMail = randomMail + name.substring(randomindex, randomindex+1);
					
				}
				return randomMail;
			
			}
			public String getRandomPassword(int intLength)
			{
				String strPassword ="abcdefghijklmnopqrstuvwxyz@#%$&^*123456789";
				String randomPassword ="";
				for (int i = 0; i < intLength ; i++) 
				{
					int randomindex = (int) (Math.random()*strPassword.length());
					randomPassword =  randomPassword + strPassword.substring(randomindex, randomindex+1);
					
				}
				return randomPassword;
				
			}
			public String getRandomDate()
			{
				
				int randDay = objRandom.nextInt(30);
				 ;
				if(randDay == 0)
				{
					randDay = objRandom.nextInt(30);
				}
				
				String strDay = String.valueOf(randDay);
				
				return strDay ;
			}
			public String getRandomMonth()
			{
				ArrayList<String> strMonth = new ArrayList<String>(Arrays.asList("January","February","March","April","May","june","July","August","Sep","October","November","Dec"));
				String randomMonth = " ";
				for (int i = 0; i < strMonth.size(); i++) {
					int randomIndex = objRandom.nextInt(strMonth.size());
					randomMonth = strMonth.get(randomIndex);
				}
			   return randomMonth;
			}
			public String getRandomYear() 
			{
				String strYear = "1234567890";
				String randomYear = "";
				for (int i = 0; i < 4; i++) 
				{
					int randomindex = (int) (Math.random()*strYear.length());
					randomYear =  randomYear + strYear.substring(randomindex, randomindex+1);
					
				}
				 
				return randomYear;
			}
			
			public String getRandomGender()
			{
				ArrayList<String> strGender = new ArrayList<String>(Arrays.asList("Male","Female","Custom"));
				String randomGender = " ";
				for (int i = 0; i < strGender.size(); i++) {
					int randomIndex = objRandom.nextInt(strGender.size());
					randomGender = strGender.get(randomIndex);
				}
				return randomGender;
			}
		
			//Creating reference of hashtable class through which we fetch values
			public Hashtable<String, String> objHashTable;

			//Creating constructor and creating object of class in constructor as const. gets invoked initially.
			public HashtableUtilityFB()
			{
				
				objHashTable = new Hashtable<String,String>();
			
			}
			
			
			//Creating test data 
			public Hashtable<String,String> createAccountTestData()
			{
				objHashTable.put("FirstName","ABC_");
				objHashTable.put("LastName","XyZ_" );
				objHashTable.put("EmailAddress","abc_");
				objHashTable.put("Password", "xyz_");
				objHashTable.put("Date","");
				objHashTable.put("Month","");
				objHashTable.put("Year", "");
				objHashTable.put("Gender","" );
				objHashTable.put("Sign-Up","Sign-Up");
				objHashTable.put("Logout Text Visible","Logout");
				return objHashTable;
			}

	

}
