package Model.Coders;

import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hashcoder {

        
        public static String encodeMD5String(String input) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(input.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : messageDigest) {
                    sb.append(String.format("%02x", b));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MD5 algorithm not found", e);
            }
        }

        public static ArrayList<String> encodeMD5Array(ArrayList<String> input) {
            
            ArrayList<String> listMD5 = new ArrayList<String>();
            for (String s : input) {
                listMD5.add(hashcoder.encodeMD5String(s));
            }
            return(listMD5);
        }


    }

