package lecteurFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LecteurFichierAbstract {
	protected String file;
	protected String content = "";
	
	public void lireAfficherFichier(String file) {
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
			
			//Displaying the file and it name
			int position = file.indexOf("/");
			String nameFile = file.substring(position+1,file.length());
			System.out.println("Voici le contenu du fichier "+nameFile+" : \n");
			System.out.println(result);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	

}
