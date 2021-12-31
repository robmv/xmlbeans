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


import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.junit.Assert.assertNull;
import static org.w3c.domts.DOMTest.load;


/**
 * The "getPrefix()" method for a node
 * returns the namespace prefix of this node, or null if it is unspecified.
 * <p>
 * Retrieve the first employee node and invoke the getPrefix() method."
 * The method should return "null".
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
 */
public class prefix04 {
    @Test
    @Ignore
    public void testRun() throws Throwable {
        Document doc;
        NodeList elementList;
        Node testEmployee;
        String prefix;
        doc = load("staffNS", false);
        elementList = doc.getElementsByTagName("employee");
        testEmployee = elementList.item(0);
        prefix = testEmployee.getPrefix();
        assertNull("throw_Null", prefix);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/prefix04";
    }

}
