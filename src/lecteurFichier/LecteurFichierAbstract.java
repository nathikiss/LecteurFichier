package lecteurFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Cette classe implémente l'interface LecteurFichierInterface.java. On y utilise 
 * une des méthodes définit dans l'interface. lireAfficherFichier() 
 * qui permet comme son nom l'indique de lire et d'afficher directement 
 * le contenu du fichier. De ce fait notre class se construit grâce à deux attributs.
 * file String et content String
 *
 */
public abstract class LecteurFichierAbstract implements LecteurFichierInterface {
	
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
			
			//Affichage du contenu du fichier ainsi que son nom
			int position = file.indexOf("/");
			String nameFile = file.substring(position+1,file.length());
			System.out.println("Voici le contenu du fichier "+nameFile+" : \n");
			System.out.println(result);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	

}
