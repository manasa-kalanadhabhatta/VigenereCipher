package vigenereCiphers;

import java.util.Random;

public class Cryptosystem {
	public static final Random rand = new Random();
	public final static char[] englishAlphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private char[] key;
	private char[] plaintext, ciphertext;
	
	public Cryptosystem(){
		//generate random key
		int keyLength = rand.nextInt(5)+1;
		this.key = new char[keyLength];
		for(int i=0;i<keyLength;i++){
			int index = rand.nextInt(26);
			this.key[i] = Cryptosystem.englishAlphabet[index];
		}
	}
	
	//returns ciphertext corresponding to given plaintext
	public char[] encode(char[] pt){
		this.ciphertext = new char[pt.length];
		for(int i=0; i<pt.length; i++){
			int index = (pt[i] + this.key[i%(this.key.length)])%26;
			this.ciphertext[i] = englishAlphabet[index];
		}
		return this.ciphertext;
	}
	
	//returns ciphertext corresponding to random plaintext
	public char[] encode(){
		//generate random plaintext
		int textLength = rand.nextInt(100)+1;
		this.plaintext = new char[textLength];
		for(int i=0;i<textLength;i++){
			int index = rand.nextInt(26);
			this.plaintext[i] = englishAlphabet[index];
		}
		
		//generate corresponding ciphertext
		this.ciphertext = new char[textLength];
		for(int i=0; i<textLength; i++){
			int index = (this.plaintext[i] + this.key[i%(this.key.length)])%26;
			this.ciphertext[i] = englishAlphabet[index];
		}
		return this.ciphertext;
	}
}
