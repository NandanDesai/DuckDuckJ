/*
 * Author: Nandan Desai
 * Year: 2018
 */
package instantAnswerAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author nandan
 */
public class DuckDuckGo {

    String q;
    private final String format = "json";
    private final int pretty;
    private int no_redirect;
    private int no_html;
    private int skip_disambig;
    private boolean errors = false;

    public DuckDuckGo() {
        this.pretty = 1;
        this.no_redirect = 0;
        /* if no_redirect=1, then using !bang command in DDG will return a blank JSON and no redirects will happen. If it is 0, then there will be HTTP redirects. */
        this.no_html = 0;
        /*0 means allow html*/
        this.skip_disambig = 0;
        /*0 means results may contain disambiguation */
    }

    public void setNoRedirect(boolean option) {
        if (option == true) {
            this.no_redirect = 1;
        } else if (option == false) {
            this.no_redirect = 0;
        }
    }

    public void setNoHTML(boolean option) {
        if (option == true) {
            this.no_html = 1;
        } else if (option == false) {
            this.no_html = 0;
        }
    }

    public void setSkipDisambiguation(boolean option) {
        if (option == true) {
            this.skip_disambig = 1;
        } else if (option == false) {
            this.skip_disambig = 0;
        }
    }

    public void showAllErrors(boolean option) {
        this.errors = option;
    }

    public Response query(String q) throws MalformedURLException, IOException, JSONException {
        this.q = q;
        q=q.replace(" ","%20");
        URL url = new URL("http://api.duckduckgo.com/?q=" + q + "&format=" + format + "&no_redirect=" + no_redirect + "&no_html=" + no_html + "&skip_disambig=" + skip_disambig + "&pretty=" + pretty + "&t=DuckDuckJ");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "duckduckgo-java");
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        StringBuffer json = new StringBuffer();
        while ((output = br.readLine()) != null) {
            json.append(output);
            //System.out.println(output);
        }
        JSONObject obj = new JSONObject(json.toString());

        String answerText = obj.getString("Answer");
        String answerType = obj.getString("AnswerType");
        Answer answer = new Answer(answerText, answerType);

        String definitionText = obj.getString("Definition");
        String definitionSourceName = obj.getString("DefinitionSource");
        String definitionUrl = obj.getString("DefinitionURL");
        Definition definition = new Definition(definitionText, definitionSourceName, definitionUrl);

        String type = obj.getString("Type");
        URL redirect;
        try {
            redirect = new URL(obj.getString("Redirect"));
        } catch (MalformedURLException | JSONException e) {
            redirect = null;
        }
        String abstractHtml = obj.getString("Abstract");
        String abstractText = obj.getString("AbstractText");
        String abstractSourceName = obj.getString("AbstractSource");
        URL imageUrl;
        URL abstractUrl;
        
        try {
            abstractUrl = new URL(obj.getString("AbstractURL"));
        } catch (MalformedURLException | JSONException e) {
            abstractUrl = null;
        }
        try {
            imageUrl = new URL(obj.getString("Image"));
        } catch (MalformedURLException | JSONException e) {
            imageUrl = null;
        }
        String topic = obj.getString("Heading");

        String htmlResult;
        URL firstUrl;
        Icon icon;
        String iconUrl;
        int iconHeight;
        int iconWidth;
        String firstUrlText;

        ArrayList<RelatedTopics> rel = new ArrayList<RelatedTopics>();
        RelatedTopics reltop;
        JSONArray arr = obj.getJSONArray("RelatedTopics");

        for (int i = 0; i < arr.length(); i++) {
            try {
                htmlResult = arr.getJSONObject(i).getString("Result");

                try {
                    iconUrl = arr.getJSONObject(i).getJSONObject("Icon").getString("URL");
                } catch (JSONException e) {
                    iconUrl = null;
                }
                try {
                    firstUrl = new URL(arr.getJSONObject(i).getString("FirstURL"));
                } catch (JSONException e) {
                    firstUrl = null;
                }
                try {
                    iconHeight = Integer.parseInt(arr.getJSONObject(i).getJSONObject("Icon").getString("Height"));
                } catch (NumberFormatException | JSONException e) {
                    iconHeight = 0;
                }
                try {
                    iconWidth = Integer.parseInt(arr.getJSONObject(i).getJSONObject("Icon").getString("Width"));
                } catch (NumberFormatException | JSONException e) {
                    iconWidth = 0;
                }
                icon = new Icon(iconUrl, iconHeight, iconWidth);
                firstUrlText = arr.getJSONObject(i).getString("Text");
                reltop = new RelatedTopics(htmlResult, firstUrl, icon, firstUrlText);
                rel.add(reltop);
            } catch (MalformedURLException | JSONException e) {
                if (errors) {
                    e.printStackTrace();
                }
            }
        }

        ArrayList<Results> res = new ArrayList<Results>();
        Results results;
        arr = obj.getJSONArray("Results");

        for (int i = 0; i < arr.length(); i++) {
            try {
                htmlResult = arr.getJSONObject(i).getString("Result");
                try {
                    iconUrl = arr.getJSONObject(i).getJSONObject("Icon").getString("URL");
                } catch (JSONException e) {
                    iconUrl = null;
                }
                try {
                    firstUrl = new URL(arr.getJSONObject(i).getString("FirstURL"));
                } catch (JSONException e) {
                    firstUrl = null;
                }
                try {
                    iconHeight = Integer.parseInt(arr.getJSONObject(i).getJSONObject("Icon").getString("Height"));
                } catch (NumberFormatException | JSONException e) {
                    iconHeight = 0;
                }
                try {
                    iconWidth = Integer.parseInt(arr.getJSONObject(i).getJSONObject("Icon").getString("Width"));
                } catch (NumberFormatException | JSONException e) {
                    iconWidth = 0;
                }
                icon = new Icon(iconUrl, iconHeight, iconWidth);
                firstUrlText = arr.getJSONObject(i).getString("Text");
                results = new Results(htmlResult, firstUrl, icon, firstUrlText);
                res.add(results);
            } catch (MalformedURLException | JSONException e) {
                if (errors) {
                    e.printStackTrace();
                }

            }
        }

        Abstract _abstract = new Abstract(abstractHtml, abstractText, abstractSourceName, abstractUrl, imageUrl, topic, rel, res);
        Response response = new Response(type, redirect, definition, answer, _abstract);
        conn.disconnect();
        return response;
    }

}
