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
public class Results extends AdditionalAbstractInfo{
        public Results(String htmlResult,URL url, Icon icon, String firstUrlText){
        super.htmlResult=htmlResult;
        super.firstUrl=url;
        super.firstUrlText=firstUrlText;
        super.icon=icon;
    }
    @Override
    public String getHtmlResult() {
        return super.htmlResult;
    }

    @Override
    public URL getFirstUrl() {
        return super.firstUrl;
    }

    @Override
    public Icon getIcon() {
        return super.icon;
    }

    @Override
    public String firstUrlText() {
        return super.firstUrlText;
    }
}
