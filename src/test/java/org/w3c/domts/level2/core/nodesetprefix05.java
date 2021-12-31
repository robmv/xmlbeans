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
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import static org.junit.Assert.assertTrue;
import static org.w3c.domts.DOMTest.load;


/**
 * The method setPrefix raises a NAMESPACE_ERR if the specified prefix is malformed.
 * Create a new namespace aware element node and call the setPrefix method on it with several malformed
 * prefix values.  Check if a NAMESPACE_ERR is thrown.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
 */
public class nodesetprefix05 {
    @Test
    public void testRun() throws Throwable {
        Document doc;
        Element element;
        String prefixValue;
        java.util.List prefixValues = new java.util.ArrayList();
        prefixValues.add("_:");
        prefixValues.add(":0");
        prefixValues.add(":");
        prefixValues.add("_::");
        prefixValues.add("a:0:c");

        doc = load("staffNS", true);
        element = doc.createElementNS("http://www.w3.org/DOM/Test/L2", "dom:elem");
        for (int indexd523e55 = 0; indexd523e55 < prefixValues.size(); indexd523e55++) {
            prefixValue = (String) prefixValues.get(indexd523e55);

            {
                boolean success = false;
                try {
                    element.setPrefix(prefixValue);
                } catch (DOMException ex) {
                    success = (ex.code == DOMException.NAMESPACE_ERR);
                }
                assertTrue("nodesetprefix05", success);
            }
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/nodesetprefix05";
    }

}
