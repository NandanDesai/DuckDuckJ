/*
 * Author: Nandan Desai
 * Year: 2018
 */
package instantAnswerAPI;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author nandan
 */
public class Definition {
    private final String definitionText;
    private final String definitionSourceName;
    private URL definitionURL;
    public Definition(String definitionText,String definitionSourceName,String definitionURL){
        this.definitionText=definitionText;
        this.definitionSourceName=definitionSourceName;
        try {
            this.definitionURL=new URL(definitionURL);
        } catch (MalformedURLException ex) {
            this.definitionURL=null;
        }
       
    }
    
    public String getDefinitionText(){
        return definitionText;
    }
    public String getDefinitionSourceName(){
        return definitionSourceName;
    }
    public URL getDefinitionURL(){
        return definitionURL;
    }
}
