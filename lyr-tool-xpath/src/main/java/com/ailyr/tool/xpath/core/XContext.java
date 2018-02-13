package com.ailyr.tool.xpath.core;
import java.util.LinkedList;

import com.ailyr.tool.xpath.model.Node;

/**
 * @author 汪浩淼 [ et.tw@163.com ]
 * @since 14-3-10
 */
public class XContext {
    public LinkedList<Node> xpathTr;
    public XContext(){
        if (xpathTr==null){
            xpathTr = new LinkedList<Node>();
        }
    }
}
