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
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import static org.junit.Assert.assertTrue;
import static org.w3c.domts.DOMTest.load;


/**
 * The method setAttributeNS adds a new attribute and raises a NAMESPACE_ERR if the
 * qualifiedName has a prefix and the namespaceURI is null.
 * Invoke the setAttributeNS method on a new Element object with null namespaceURI and a
 * qualifiedName that has a namespace prefix.  Check if the NAMESPACE_ERR was thrown.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAttrNS</a>
 * @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
 */
public class elementsetattributens05 {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Element element;
        String nullNS = null;

        doc = load("staffNS", true);
        element = doc.createElementNS("http://www.w3.org/DOM/Test/L2", "dom:elem");

        {
            boolean success = false;
            try {
                element.setAttributeNS(nullNS, "dom:root", "test");
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NAMESPACE_ERR);
            }
            assertTrue("elementsetattributens05", success);
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/elementsetattributens05";
    }

}
