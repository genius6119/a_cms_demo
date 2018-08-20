package cn.qimu.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class Html2Text extends HTMLEditorKit.ParserCallback {

    private static Html2Text html2Text = new Html2Text();

    StringBuffer s;

    public Html2Text() {
    }

    public void parse(String str) throws IOException {

        InputStream iin = new ByteArrayInputStream(str.getBytes());
        Reader in = new InputStreamReader(iin);
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        // the third parameter is TRUE to ignore charset directive
        delegator.parse(in, this, Boolean.TRUE);
        iin.close();
        in.close();
    }

    public void handleText(char[] text, int pos) {
        s.append(text);
    }

    public String getText() {
        return s.toString();
    }

    public static String getContent(String str) {
        try {
            html2Text.parse(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return html2Text.getText();
    }

    public static void main(String[] args) {
        String text = Html2Text.getContent("<h1><span style=\"font-weight: bold;\"></span>代码是网上copy过来的，稍微修改为接受字符串，并在内部写了一个极其简陋的单例，</h1><h4 style=\"text-align: center;\">使用的是java的api，效果极其的好，比起网上使用正则表达式替换来得快，正确性也比较高，我试过用网上正则的，都是不太理想，情况复杂点的，都挂了。<span style=\"font-family: &quot;Source Sans Pro&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 14px;\">&nbsp;</span></h4>使用方式如下：");
        System.out.println(text.length());
        System.out.println(text.substring(0,40)+"...");

    }
}