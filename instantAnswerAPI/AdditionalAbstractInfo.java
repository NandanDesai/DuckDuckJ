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
public abstract class AdditionalAbstractInfo {
    String htmlResult;
    URL firstUrl;
    Icon icon;
    String firstUrlText;
    
    public abstract String getHtmlResult();
    public abstract URL getFirstUrl();
    public abstract Icon getIcon();
    public abstract String firstUrlText();
}
