package org.lyr.tool.xpath.core;
import java.util.LinkedList;

import org.lyr.tool.xpath.model.Node;

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
