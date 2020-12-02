package lecteurFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
			String nomFichier = file.substring(position+1,file.length());
			System.out.println("Voici le contenu du fichier "+nomFichier+" en lecture Palindromique : \n");
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
					result += (char)content;
				
				}
			} while (content != -1);
			int position = file.indexOf("/");
			String nomFichier = file.substring(position+1,file.length());
			System.out.println("Voici le contenu du fichier en Inversé "+nomFichier+" : \n");
			System.out.println(result);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}


	
}
