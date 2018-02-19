/*
 * Author: Nandan Desai
 * Year: 2018
 */
package instantAnswerAPI;

/**
 *
 * @author nandan
 */
public class Answer {
    private final String answerText;
    private final String answerType;
    public Answer(String answerText,String answerType){
        this.answerText=answerText;
        this.answerType=answerType;
    }
    public String getAnswerText(){
        return answerText;
    }
    public String getAnswerType(){
        return answerType;
    }
}
