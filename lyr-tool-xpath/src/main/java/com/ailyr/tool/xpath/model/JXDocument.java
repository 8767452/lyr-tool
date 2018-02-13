package com.ailyr.tool.xpath.model;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ailyr.tool.xpath.core.XpathEvaluator;
import com.ailyr.tool.xpath.exception.NoSuchAxisException;
import com.ailyr.tool.xpath.exception.NoSuchFunctionException;
import com.ailyr.tool.xpath.exception.XpathSyntaxErrorException;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 汪浩淼 [ et.tw@163.com ]
 */
public class JXDocument {
    private Elements elements;
    private XpathEvaluator xpathEva = new XpathEvaluator();
    public JXDocument(Document doc){
        elements = doc.children();
    }
    public JXDocument(String html){
        elements = Jsoup.parse(html).children();
    }
    public JXDocument(Elements els){
        elements = els;
    }
    
    public List<Object> sel(String xpath) throws XpathSyntaxErrorException {
        List<Object> res = new LinkedList<Object>();
        try {
             List<JXNode> jns = xpathEva.xpathParser(xpath,elements);
             for (JXNode j:jns){
                 if (j.isText()){
                     res.add(j.getTextVal());
                 }else {
                     res.add(j.getElement());
                 }
             }
        } catch (Exception e){
            String msg = "please check the xpath syntax";
            if (e instanceof NoSuchAxisException||e instanceof NoSuchFunctionException){
                msg = e.getMessage();
            }
            throw new XpathSyntaxErrorException(msg);
        }
        return res;
    }

    public List<JXNode> selN(String xpath) throws XpathSyntaxErrorException{
        try {
            return xpathEva.xpathParser(xpath,elements);
        }catch (Exception e){
            String msg = "please check the xpath syntax";
            if (e instanceof NoSuchAxisException||e instanceof NoSuchFunctionException){
                msg = e.getMessage();
            }
            throw new XpathSyntaxErrorException(msg);
        }
    }
}
