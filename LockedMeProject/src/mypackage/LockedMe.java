package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {

	static final String projectFilesPath = "C:\\Users\\HP\\eclipse-workspace\\LockMeFiles";
	static final String errorMessage = "Please Contact Mr Bandar IT Department Bandar@it.com";
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int pk;
		try {
			
		do
		{
			ShowAllFiles();
			System.out.println("Enter Your Choice:");
			pk=Integer.parseInt(scan.nextLine());
			
			switch(pk)
			{
			case 1:DisplayFiles();
			break;
			case 2:AddFiles();
			break;
			case 3:DeleteFiles();
			break;
			case 4:SearchFile();
			break;
			case 5:System.exit(0);
	        break;
	        default:System.out.println("Invalid Choice");
			}
		}
		while(pk>0);
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
	
		scan.close();
	}
	
	public static void ShowAllFiles()
	{
		System.out.println("\t\t*************************");
		System.out.println("\t\tWelcome to Lockedme.com");
		System.out.println("\t\t*************************");
		System.out.println("\t\tCreated By Bandar Abbad");
		System.out.println("\t\t*************************");
		System.out.println("\t\t1- Display All Files");
		System.out.println("\t\t2- Add Files");
		System.out.println("\t\t3- Delete Files");
		System.out.println("\t\t4- Search Files");
		System.out.println("\t\t5- Exit");
	}
	
	
	
	/**
	 * This Function Will Display All The Files Name in the Folder
	 */
	public static void DisplayFiles()
	{
		try {
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
		
			if(listOfFiles.length==0)
				{
			System.out.println("No Files Exist");
				}
			else
				{
			for(var l:listOfFiles)
				{
				System.out.println(l.getName());
				}
				}
			}
		
		catch(Exception Ex)
				{
			System.out.println(errorMessage);
				}
	}
	
	/**
	 * This Function Will Add File To The Folder
	 */
	public static void AddFiles()
	{
		try
		{
			Scanner scan = new Scanner(System.in);
			
			String filename;
			System.out.println("Enter The File Name You Want To Add");
			filename = scan.nextLine();
			
			int linesCount;
			System.out.println("Enter how many lines in the file");
			linesCount = Integer.parseInt(scan.nextLine());			
			FileWriter myWriter=new FileWriter(projectFilesPath+ "\\" + filename);
			
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter The File Line:");
				myWriter.write(scan.nextLine()+"\n");
				
			}
			System.out.println("File Added Successfully");
			
			
			scan.close();
			myWriter.close();
			
		}
		
		catch(Exception Ex)
			{
				System.out.println(errorMessage);
			}	
	}
	

	/**
	 * This Function Will Delete The File From The Folder
	 */
	public static void DeleteFiles()
	{
		Scanner scan = new Scanner(System.in);
		
		try
		{
			String fileName;
			System.out.println("Please Enter The Name Of The File You Want To Delete");
			fileName=scan.nextLine();
			File file = new File(projectFilesPath+ "\\"+ fileName);
		
			if(file.exists())
			{
				file.delete();
				System.out.println("File Deleted Successfully = " + "" + fileName);
			}
			else
				System.out.println("Failed To Delete The File");
				
		}
		
		catch(Exception Ex)
				{
			System.out.println(errorMessage);
				}
		
		finally 
		{
			scan.close();
		}
		
	}
	
	
	
	/**
	 * This Function Will Search For The File If Exist in Folder
	 */
	public static void SearchFile()
	{
Scanner scan = new Scanner(System.in);
		
		try
		{
			String fileName;
			System.out.println("Please Enter The Name Of The File You Want To Search");
			fileName=scan.nextLine();
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			
			LinkedList<String> filenames = new LinkedList<String>();
			
			for(var l:listOfFiles)
				filenames.add(l.getName());
			if(filenames.contains(fileName))
			{
				System.out.println("File Is Available");
			}
			else
				System.out.println("File Not Availbale");
			
			
		}
		catch(Exception Ex)
				{
			System.out.println(errorMessage);
				}
		
		finally 
		{
			scan.close();
		}
		
}
}
