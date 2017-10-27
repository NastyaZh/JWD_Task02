package by.tc.task02.dao.impl;

import by.tc.task02.entity.exceptions.DAOExceptions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class FileWorker {
    public static final String PATH = "task02.xml";
    private final static Pattern DECLARATION = Pattern.compile("^(<\\?xml \\w+)");
    
    public String readFromFile()throws DAOExceptions{
        String xmlFile = "",line; 
        try{
            InputStream in = FileWorker.class.getClassLoader().getResourceAsStream(PATH);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));                   
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if(DECLARATION.matcher(line).find()){
                    continue;                    
                }
                else{
                    xmlFile += line;
                }
            }
            return xmlFile;
        }
        
        catch(IOException ex){
            throw new DAOExceptions(ex);
        }
        
    }
}
