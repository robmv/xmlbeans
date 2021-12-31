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


import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import static org.junit.Assert.assertEquals;
import static org.w3c.domts.DOMTest.load;


/**
 * The "getAttributeNS(namespaceURI,localName)" method retrieves an
 * attribute value by local name and NamespaceURI.
 * Retrieve the first "emp:address" element.
 * The value returned by the "getAttributeNS()" method should be the
 * value "DISTRICT" since the attribute has a default value.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElGetAttrNS</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=238">http://www.w3.org/Bugs/Public/show_bug.cgi?id=238</a>
 */
public class getAttributeNS01 {
    @Test
    @Ignore
    public void testRun() throws Throwable {
        String namespaceURI = "http://www.nist.gov";
        String localName = "district";
        String qualifiedName = "emp:district";
        Document doc;
        NodeList elementList;
        Element testAddr;
        String attrValue;
        doc = load("staffNS", false);
        elementList = doc.getElementsByTagName("emp:address");
        testAddr = (Element) elementList.item(0);
        attrValue = testAddr.getAttributeNS(namespaceURI, localName);
        assertEquals("attrValue", "DISTRICT", attrValue);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/getAttributeNS01";
    }

}
