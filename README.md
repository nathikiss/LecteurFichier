# LecteurFichier
#### KISSITA Nathivel 
## Compte Rendu Lecteur de Fichier Java (Projet LPPWM)

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
