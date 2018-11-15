package kata5p2.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReader {
    
    public static List<Mail> read (String fileName) throws FileNotFoundException, IOException{
        List <Mail> lista = new ArrayList();
        BufferedReader reader = new BufferedReader (new FileReader(new File (fileName)));
        String linea;
        while ((linea = reader.readLine()) != null){
            if (linea.contains("@")){
                lista.add(new Mail(linea));
            }
        }
    reader.close();
    return lista;
    }
    
    
}
