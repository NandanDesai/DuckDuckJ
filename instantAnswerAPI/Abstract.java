/*
 * Author: Nandan Desai
 * Year: 2018
 */
package instantAnswerAPI;

import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author nandan
 */
public class Abstract {
    private final String abstractHtml;
    private final String abstractText;
    private final String abstractSourceName;
    private final URL abstractUrl;
    private final URL imageUrl;   //Image
    private final String topic; //Heading
    private ArrayList<RelatedTopics> relatedTopics;
    private ArrayList<Results> results;
    public Abstract(String abstractHtml,String abstractText, String abstractSourceName,URL abstractUrl, URL imageUrl, String topic, ArrayList<RelatedTopics> relatedTopics, ArrayList<Results> results){
        this.abstractHtml=abstractHtml;
        this.abstractText=abstractText;
        this.abstractSourceName=abstractSourceName;
        this.abstractUrl=abstractUrl;
        this.imageUrl=imageUrl;
        this.topic=topic;
        this.relatedTopics=relatedTopics;
        this.results=results;
    }
    
    public String getAbstractHtml(){
        return abstractHtml;
    }
    public String getAbstractText(){
        return abstractText;
    }
    public String getAbstractSourceName(){
        return abstractSourceName;
    }
    public URL getAbstractUrl(){
        return abstractUrl;
    }
    public URL getImageUrl(){
        return imageUrl;
    }
    public ArrayList<RelatedTopics> getRelatedTopics(){
        return relatedTopics;
    }
    public ArrayList<Results> getResults(){
        return results;
    }
}
