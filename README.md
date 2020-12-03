# LecteurFichier
#### KISSITA Nathivel 
## Compte Rendu Lecteur de Fichier Java (Projet LPPWM)

### LecteurFichierInterface.java

Conformément à la consigne, j'ai dans un premier temps implémenter une interface. LecteurFichierInterface.
On y défini les méthodes par défauts :

        package lecteurFichier;

        import java.io.IOException;
        public interface LecteurFichierInterface {
	        public void lireAfficherFichier(String file);
	        public void lireFichierReverse(String file);
	        public void lireFichierPalindrome(String file);
	        public void lireFichierSixVoyelles(String file);
         }
         
### LecteurFichierAbstract.java

On crée ensuite la classe abstraite LecteurFichierAbstract, elle implémente de l'Interface 

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

### LecteurFichier.java

La derniere classe que l'on crée est une sous-classe qui hérite de LecteurFichierAbstract

        package lecteurFichier;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.util.*;

        /**
         *Cette classe herite de la classe LecteurFichierAbstract. On y utilise 
         *les méthodes restantes de l'interface LecteurFichierInterface :
         * lireFichierPalindrome(), lireFichierReverse(),
         * lireFichierSixVoyelles(). 
         *
         */


        public class LecteurFichier extends LecteurFichierAbstract  {

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
                  //transforme le int en char, puis on le met dans une String result
                  result += (char)content;
                }
              }
              while (content != -1);
              //On inverse le contenu grâce au Buffer
              StringBuffer palindromeResult = (new StringBuffer(result)).reverse();
              //tronque l'URL du fichier afin de prendre uniquement le nom
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
                  result += (char)content;

                }
              } while (content != -1);

              int position = file.indexOf("/");
              String nameFile = file.substring(position+1,file.length());
              System.out.println("Voici le contenu du fichier en Inversé "+nameFile+" : \n");
              //on sépare le fichier , on insère chaque ligne dans un tableau
              final String SEPARATOR = "\n";
              String mots[] = result.split(SEPARATOR);
              //Affiche chaque ligne de la fin jusqu'au début
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
                  result += (char)content;

                }
              } while (content != -1);

              int position = file.indexOf("/");
              String nameFile = file.substring(position+1,file.length());
              System.out.println("Voici la traduction du CodeSecret contenu dans le fichier "+nameFile+" : \n");

              final String SEPARATOR = "\n";
              String mots[] = result.split(SEPARATOR);
              //Affiche les lignes du début à la fin
              //remplace les chiffres par des voyelles
              for (int i =0; i<mots.length; i++) {
                System.out.println(mots[i].replace("1","a").replace("2","e").replace("3","i")
                    .replace("4","o").replace("5","u").replace("6","y"));}


            } catch (FileNotFoundException e) {

              e.printStackTrace();
            }

          }


        }

### Main.java

On termine par notre Main.java, dans laquelle on teste deux fichiers, un fichier simple permettant de montrer assez efficacement
que les methodes lireAfficherFichier, lireFichierReverse et lireFichierPalindrome fonctionnent.
Le second est un code secret qui est déchiffré par la methode lireFichierSixVoyelles.

	package lecteurFichier;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	public class Main {
		  public static void main(String[] args) {
			  //
			  LecteurFichierInterface test = new LecteurFichier();
			  String file="C:\\Users\\Dell\\lecteurFichier\\src\\lecteurFichier/test.txt";
			  test.lireAfficherFichier(file);
			  test.lireFichierPalindrome(file);
			  test.lireFichierReverse(file);
			  test.lireFichierSixVoyelles("C:\\Users\\Dell\\lecteurFichier\\src\\lecteurFichier/sixvoyelles.txt");
	}
		  }
