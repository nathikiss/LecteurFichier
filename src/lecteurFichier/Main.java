package lecteurFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	//ESSAI => créer un File, vérifier l'existence, ouvrir, lire et afficher)
	//POUR LE VRAI MINI PROJET CREER DES LECTEURS POUR DIFFERENT TYPE DE FICHIER, HTML/TXT
	  public static void main(String[] args) {
		 
		  LecteurFichierInterface test = new LecteurFichier();
		  String file="C:\\Users\\Dell\\lecteurFichier\\src\\lecteurFichier/test.txt";
		  //test.lireAfficherFichier(file);
		  //test.lireFichierPalindrome(file);
		  //test.lireFichierReverse(file);
		  test.lireFichierSixVoyelles("C:\\Users\\Dell\\lecteurFichier\\src\\lecteurFichier/sixvoyelles.txt");
}
	  }
