# DuckDuckJ
A Java library for DuckDuckGo's Instant Answer API


## How to use this library?
```java
//get answers to questions
Response r=ddg.query("what is my ip?");
Answer ans=r.getAnswer();
System.out.println(ans.getAnswerText());

//Or you can get an abstract text on a topic
Response r=ddg.query("youtube");
Abstract abs=r.getAbstract();
System.out.println(abs.getAbstractText());

```
## How to install this library?
Just import the JAR file into your project. You can find the JAR file in the repository itself (in root folder).

For more information and documentation, visit the DuckDuckGo official API reference website [here](https://duckduckgo.com/api)
