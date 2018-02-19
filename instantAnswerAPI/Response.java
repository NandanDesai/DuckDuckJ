/*
 * Author: Nandan Desai
 * Year: 2018
 */
package instantAnswerAPI;

import java.net.URL;

/**
 *
 * @author nandan
 */
public class Response {
    private final String type;
    /* Type: response category, i.e. A (article), D (disambiguation), C (category), N (name), E (exclusive), or nothing. */
    private final URL redirectUrl;
    private final Definition definition;
    private final Answer answer;
    private final Abstract _abstract;
    Response(String type,URL redirectUrl, Definition definition,Answer answer,Abstract _abstract){
        this.type=type;
        this.redirectUrl=redirectUrl;
        this.definition=definition;
        this.answer=answer;
        this._abstract=_abstract;
    }
    
    public String getType(){
        return type;
    }
    public URL getRedirectUrl(){
        return redirectUrl;
    }
    public Definition getDefinition(){
        return definition;
    }
    public Answer getAnswer(){
        return answer;
    }
    public Abstract getAbstract(){
        return _abstract;
    }
    
    
}
