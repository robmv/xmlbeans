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
import org.w3c.dom.*;

import static org.junit.Assert.assertTrue;
import static org.w3c.domts.DOMTest.load;


/**
 * The method setNamedItemNS adds a node using its namespaceURI and localName and
 * raises a HIERARCHY_REQUEST_ERR if an attempt is made to add a node doesn't belong
 * in this NamedNodeMap.
 * Attempt to add an entity to a NamedNodeMap of attribute nodes,
 * Since nodes of this type cannot be added to the attribute node map a HIERARCHY_REQUEST_ERR
 * should be raised.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-setNamedItemNS</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
 */
public class namednodemapsetnameditemns10 {
    @Test
    @Ignore
    public void testRun() throws Throwable {
        Document doc;
        DocumentType docType;
        NamedNodeMap entities;
        NamedNodeMap attributes;
        Entity entity;
        Notation notation;
        Element element;
        NodeList elementList;
        Node newNode;
        doc = load("staffNS", true);

        docType = doc.getDoctype();
        entities = docType.getEntities();
        entity = (Entity) entities.getNamedItem("ent1");

        elementList = doc.getElementsByTagNameNS("http://www.nist.gov", "address");
        element = (Element) elementList.item(0);
        attributes = element.getAttributes();

        {
            boolean success = false;
            try {
                newNode = attributes.setNamedItemNS(entity);
            } catch (DOMException ex) {
                success = (ex.code == DOMException.HIERARCHY_REQUEST_ERR);
            }
            assertTrue("namednodemapsetnameditemns10_entity", success);
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/namednodemapsetnameditemns10";
    }

}
