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
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.w3c.domts.DOMTest.load;


/**
 * The "createAttributeNS(namespaceURI,qualifiedName)" method for a
 * Document should raise NAMESPACE_ERR DOMException
 * if qualifiedName has a prefix and namespaceURI is null.
 * <p>
 * Invoke method createAttributeNS(namespaceURI,qualifiedName) on this document
 * with namespaceURI being null and qualifiedName contains the prefix "person".
 * Method should raise NAMESPACE_ERR DOMException.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='NAMESPACE_ERR'])</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS</a>
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-DocCrAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-DocCrAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='NAMESPACE_ERR'])</a>
 */
public class createAttributeNS02 {
    @Test
    public void testRun() throws Throwable {
        String namespaceURI = null;

        String qualifiedName = "prefix:local";
        Document doc;
        Attr newAttr;
        doc = load("staffNS", false);

        {
            boolean success = false;
            try {
                newAttr = doc.createAttributeNS(namespaceURI, qualifiedName);
                fail("throw_NAMESPACE_ERR,qualifiedName has a prefix and namespaceURI is null");
            } catch (DOMException ex) {
                assertTrue(ex.code == DOMException.NAMESPACE_ERR);
            }
            //assertTrue("throw_NAMESPACE_ERR", success);
        }

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/createAttributeNS02";
    }

}
