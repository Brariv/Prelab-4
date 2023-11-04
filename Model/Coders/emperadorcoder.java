package Model.Coders;

public class emperadorcoder {
    
    public static String encodeEmperadorString(String Mensaje) {
        String ResultadoEnc = "";
        for (int i = 0; i < Mensaje.length(); i++){
            char a = Mensaje.charAt(i); 
            int nextascii = a +1;
            char nextchar = (char) nextascii; 
            ResultadoEnc += nextchar;
        }
        return ResultadoEnc;
    }

    


}
