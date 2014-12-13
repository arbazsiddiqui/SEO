
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.io.*;

public class StopWords 
{
	
	//Stores all the Stop words from a text file into an Arraylist
	public static ArrayList loadStopWords()
	{
		List<String> StopWords = new ArrayList<String>();
		int count=0;
		BufferedReader in = null;
		try {   
		    in = new BufferedReader(new FileReader("C:\\Users\\siddiqui\\workspace\\SEO\\Files\\MYSTWORD.txt"));
		    String str;
		    while ((str = in.readLine()) != null) {
		        StopWords.add(str);
		        count++; }
		    //System.out.println(count);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		finally
		{
		    try
		    {
		        if ( in != null)
		        in.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
		return (ArrayList) StopWords;
		
	}
	
	
	//Stores all the words from a text file into an Arraylist
	public static ArrayList loadFile()
	{
		BufferedReader in = null;
		String line = new String();
		int count=0,i;
		String[] words = new String[1000];
		List<String> fileword = new ArrayList<String>();
		//String fileword = new String("");
		try {
			 in = new BufferedReader(new FileReader("C:\\Users\\siddiqui\\workspace\\SEO\\Files\\sportsnews.txt"));
			 while ((line = in.readLine()) != null) {
	                words = line.split(" ");
	                for(i=0; i<words.length; i++ )
	                {
	                	//fileword += (words[i] + " ");
	                	fileword.add(words[i]);
	                	count++;
	                }
			 }
			// System.out.println(count);
		}
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		finally
		{
		    try
		    {
		        if ( in != null)
		        in.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
		return (ArrayList) fileword;
		
	}
	
	
	
	
	//Remove all the Stop Words from the File.
	public static String removeStopWords()
	{
		int i,j,count=0;
		List<String> StopWords = new ArrayList<String>();
		List<String> fileword = new ArrayList<String>();
		List<String> FinalList = new ArrayList<String>();
		StopWords=loadStopWords();
		fileword=loadFile();
		String Output="";
		/*
		for(i=0; i<fileword.size(); i++ )
		{
			for(j=0; j<StopWords.size();j++)
			{
				if(StopWords.get(j).equals(fileword.get(i)))
				{
					FinalList.add(fileword.get(i)) ;
					count++;
				}
			}
		}
		*/
		fileword.removeAll( StopWords );
		for (String s : fileword)
		{
		    Output += s + " ";
		}
		//System.out.println(Output);
		//System.out.println(a);
		//System.out.println(count);
		return Output;
		
	}
	
	
	
	//Generate an output text file.
	public static void genarateFile()
	{
		String Output=removeStopWords();
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter("C:\\Users\\siddiqui\\workspace\\SEO\\Output\\nsportsnews.txt"));
		    writer.write(Output);

		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
	}
	
	
	
	
	public static void main(String[] args)
	{
		//System.out.println(LoadStopWords());
		//System.out.println(LoadFile());
		genarateFile();
	}
}
	

