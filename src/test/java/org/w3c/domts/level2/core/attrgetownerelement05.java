/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001-2003 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package org.w3c.domts.level2.core;


import org.junit.Test;
import org.w3c.dom.*;

import static org.junit.Assert.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The "getOwnerElement()" will return the Element node this attribute is attached to
 * or null if this attribute is not in use.
 * Retreive an element and its attributes.  Then remove the element and check the name of
 * the ownerElement of attribute of the attribute "street".
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement">http://www.w3.org/TR/DOM-Level-2-Core/core#Attr-ownerElement</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
 */
public class attrgetownerelement05 {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Node element;
        Element ownerElement;
        Element parentElement;
        NodeList elementList;
        String ownerElementName;
        Attr attr;
        Node removedChild;
        NamedNodeMap nodeMap;
        String nullNS = null;

        doc = load("staffNS", true);
        elementList = doc.getElementsByTagNameNS("*", "address");
        element = elementList.item(1);
        parentElement = (Element) element.getParentNode();
        nodeMap = element.getAttributes();
        removedChild = parentElement.removeChild(element);
        attr = (Attr) nodeMap.getNamedItemNS(nullNS, "street");
        ownerElement = attr.getOwnerElement();
        ownerElementName = ownerElement.getNodeName();
        assertEquals("attrgetownerelement05", "address", ownerElementName);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/attrgetownerelement05";
    }

}
