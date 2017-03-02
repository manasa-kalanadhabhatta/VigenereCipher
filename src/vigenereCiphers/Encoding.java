package vigenereCiphers;

import java.util.Scanner;

public class Encoding {
	
	public static void main(String[] args){
		char[] plaintext, key;
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter plaintext:");
		plaintext = scan.nextLine().toUpperCase().toCharArray();
		
		System.out.println("\nEnter key:");
		key = scan.nextLine().toUpperCase().toCharArray();
		
		encode(plaintext, key);
	}
	
	public static void encode(char[] plaintext, char[] key){
		int keyLength = key.length;
		char[] ciphertext = new char[plaintext.length];
		for(int i=0; i<plaintext.length; i++){
			int index = (plaintext[i] + key[i%keyLength])%26;
			ciphertext[i] = Cryptosystem.englishAlphabet[index];
		}
		System.out.println("\nThe corresponding ciphertext is:");
		System.out.println(ciphertext);
	}
}
