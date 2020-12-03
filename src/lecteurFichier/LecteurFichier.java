package lecteurFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LecteurFichier extends LecteurFichierAbstract implements LecteurFichierInterface {
	
	public LecteurFichier() {
		super.file = file;
	}
	

	public void lireFichierPalindrome(String file) {
		// TODO Auto-generated method stub
		FileInputStream in = null;
	
		try {
			in = new FileInputStream(file);
			int content=0;
			String result = "";
			do {
				try {
					content = in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (content != -1) {
					result += (char)content;
				}
			}
			while (content != -1);
			StringBuffer palindromeResult = (new StringBuffer(result)).reverse();
			int position = file.indexOf("/");
			String nameFile = file.substring(position+1,file.length());
			System.out.println("Voici le contenu du fichier "+nameFile+" en lecture Palindromique : \n");
			System.out.println(palindromeResult);
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void lireFichierReverse(String file)  {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			int content=0;
			String result ="";
			do {
				try {
					content= in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (content != -1) { 
					// Convert the int into a character and put it in a String
					result += (char)content;
					
				}
			} while (content != -1);
			
			//truncate the file URL to find it name
			int position = file.indexOf("/");
			String nameFile = file.substring(position+1,file.length());
			System.out.println("Voici le contenu du fichier en Inversé "+nameFile+" : \n");
			
			//We split the file, insert each word in the array
			final String SEPARATOR = "\n";
			String mots[] = result.split(SEPARATOR);
			//Display each word from the end to the beginning
			for (int i = mots.length-1; i>=0; i--) {
				System.out.println(mots[i]);}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void lireFichierSixVoyelles(String file)  {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			int content=0;
			String result ="";
			do {
				try {
					content= in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (content != -1) { 
					// Convert the int into a character and put it in a String
					result += (char)content;
					
				}
			} while (content != -1);
			
			//truncate the file URL to find it name
			int position = file.indexOf("/");
			String nameFile = file.substring(position+1,file.length());
			System.out.println("Voici la traduction du CodeSecret contenu dans le fichier "+nameFile+" : \n");
			
			//We split the file, insert each word in the array
			final String SEPARATOR = "\n";
			String mots[] = result.split(SEPARATOR);
			//Display each word from the end to the beginning
			//change number into letter
			for (int i =0; i<mots.length; i++) {
				System.out.println(mots[i].replace("1","a").replace("2","e").replace("3","i")
						.replace("4","o").replace("5","u").replace("6","y"));}
	
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}


	
}
