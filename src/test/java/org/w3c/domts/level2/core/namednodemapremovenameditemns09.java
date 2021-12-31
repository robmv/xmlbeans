/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001 World Wide Web Consortium,
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

import static org.junit.Assert.assertNull;
import static org.w3c.domts.DOMTest.load;


/**
 * The method removeNamedItemNS removes a node using its namespaceURI and localName and
 * raises a NOT_FOUND_ERR if there is no node with the specified namespaceURI and
 * localName in this map
 * Retreive an attribute node.  Remove the attribute node from the node map.
 * Check the element object to ensure that the attribute node has been removed from it.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-D58B193</a>
 */
public class namednodemapremovenameditemns09 {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        NamedNodeMap attributes;
        NamedNodeMap newAttributes;
        Element element;
        Attr attribute;
        NodeList elementList;
        doc = load("staffNS", true);
        elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
        element = (Element) elementList.item(1);
        attributes = element.getAttributes();
        attribute = (Attr) attributes.removeNamedItemNS("http://www.nist.gov", "domestic");
        newAttributes = element.getAttributes();
        attribute = (Attr) newAttributes.getNamedItemNS("http://www.nist.gov", "domestic");
        assertNull("namednodemapremovenameditemns09", attribute);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapremovenameditemns09";
    }

}
