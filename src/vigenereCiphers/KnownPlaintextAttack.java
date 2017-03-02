package vigenereCiphers;

import java.util.Random;

/*
 * A known plaintext attack is an attack 
 * where a cryptanalyst has access to 
 * a plaintext and the corresponding ciphertext 
 * and seeks to discover a correlation between the two.
 */
public class KnownPlaintextAttack {

	static char[] plaintext, ciphertext, key;
	public static final Random rand = new Random();
		
	public static void main(String[] args) {
		//generate a cryptosystem
		Cryptosystem c = new Cryptosystem();
		
		//generate random plaintext
		int textLength = rand.nextInt(100)+1;
		plaintext = new char[textLength];
		for(int i=0;i<textLength;i++){
			int index = rand.nextInt(26);
			plaintext[i] = Cryptosystem.englishAlphabet[index];
		}
		System.out.println("\nGiven Plaintext:");
		System.out.println(plaintext);
		
		//get corresponding ciphertext
		ciphertext = c.encode(plaintext);
		System.out.println("\nGiven (corresponding) Ciphertext:");
		System.out.println(ciphertext);
		
		//begin attack to get the key
		char keyRepeated[] = new char[textLength];
		for(int i=0; i<textLength; i++){
			int diff = ciphertext[i] - plaintext[i];
			int index;
			if(diff<0){
				diff+=26;
			}
			index = Math.abs((diff))%26;
			keyRepeated[i] = c.englishAlphabet[index];
		}
		
		//get smallest repeating unit of the key
		int i, j, k, begin = 0;
		for(i=0;i<keyRepeated.length;i++){
			if(keyRepeated[i]==keyRepeated[begin]){
				for(j=begin+1, k=i+1; j<i; j++,k++){
					if(keyRepeated[j]!=keyRepeated[k])
						break;
				}
				if(j==i){
					key = new char[i];
					for(k=0;k<i;k++){
						key[k]=keyRepeated[k];
					}
					break;
				}
			}
		}
		System.out.println("\nThe key used is:");
		System.out.println(key);
	}

}
