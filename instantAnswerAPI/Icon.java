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
public class Icon {
    URL url;
    int height;
    int width;
    public Icon(String url,int height,int width){
        try {
            this.url=new URL(url);
        } catch (MalformedURLException ex) {
            this.url=null;
        }
        this.height=height;
        this.width=width;
    }
    public URL getIconUrl(){
        return url;
    }
    public int getIconHeight(){
        return height;
    }
    public int getIconWidth(){
        return width;
    }
}
