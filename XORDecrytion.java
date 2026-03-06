import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] cipher = new int[n];
        for (int i = 0; i < n; i++) {
            cipher[i] = sc.nextInt();
        }

        String bestKey = "";
        int maxSpaces = -1;

        // Brute force all 3-letter lowercase keys: 'aaa' to 'zzz'
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    char[] key = {i, j, k};
                    int spaceCount = getSpaceCountIfValid(cipher, key);
                    
                    // The correct English text will have the highest frequency of spaces
                    if (spaceCount > maxSpaces) {
                        maxSpaces = spaceCount;
                        bestKey = "" + i + j + k;
                    }
                }
            }
        }
        
        System.out.println(bestKey);
    }

    /**
     * Decrypts the cipher with the given key and counts spaces.
     * Returns -1 if the decryption contains non-printable characters.
     */
    private static int getSpaceCountIfValid(int[] cipher, char[] key) {
        int spaces = 0;
        for (int i = 0; i < cipher.length; i++) {
            int decrypted = cipher[i] ^ key[i % 3];
            
            // Basic English text validation (ASCII 32 to 126)
            // If we hit a control character, this key is definitely wrong.
            if (decrypted < 32 || decrypted > 126) {
                return -1;
            }
            
            if (decrypted == 32) {
                spaces++;
            }
        }
        return spaces;
    }
}
