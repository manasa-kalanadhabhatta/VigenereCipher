package vigenereCiphers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * A ciphertext-only attack 
 * is an attack where a cryptanalyst 
 * has access to a ciphertext 
 * but does not have access 
 * to corresponding plaintext.
 */
public class CiphertextOnlyAttack {
	static char[] plaintext, ciphertext, key;
	
	public static void main(String[] args) {
		//generate a cryptosystem
		Cryptosystem c = new Cryptosystem();
		
		//get random ciphertext
		ciphertext = c.encode();
		System.out.println(ciphertext);
		
		//attempt to find repeating blocks of characters in ciphertext
		String cipher = ciphertext.toString();
		
		cipher = "VHVSSPQUCEMRVBVBBBVHVSURQGIBDUGRNICJQUCERVUAXSSR";
		
		HashMap<String,Integer> newMap = new HashMap<String,Integer>();
		for(int i=cipher.length(); i>0; i--){
			newMap.clear();
			newMap=findOccurences(cipher,i);
			if(!newMap.isEmpty())
				break;
		}
		
		for(Entry<String,Integer> e:newMap.entrySet()){
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
	
	public static HashMap<String,Integer> findOccurences(String cipher, int length){
		String sub;
		HashMap<String,Integer> newMap = new HashMap<String,Integer>();
		for(int i=0; i<cipher.length()-length; i++){
			sub=cipher.substring(i, i+length);
			int nextIndex = cipher.indexOf(sub, i+1);
			if(nextIndex!=-1){
				newMap.put(sub, nextIndex-i);
			}
		}
		return newMap;
	}

}
