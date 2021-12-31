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
import org.w3c.dom.DocumentType;

import static org.junit.Assert.assertNull;
import static org.w3c.domts.DOMTest.load;


/**
 * The "getInternalSubset()" method returns
 * the internal subset as a string or null if there is none.
 * This does not contain the delimiting brackets.
 * Retrieve the documenttype.
 * Apply the "getInternalSubset()" method.  Null is returned since there
 * is not an internal subset.
 *
 * @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-internalSubset">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-Core-DocType-internalSubset</a>
 */
    public class internalSubset01 {
    @Test
    @Ignore
    public void testRun() throws Throwable {
        Document doc;
        DocumentType docType;
        String internal;
        doc = load("staff2", false);
        docType = doc.getDoctype();
        internal = docType.getInternalSubset();
        assertNull("throw_Null", internal);

    }

    /**
     * Gets URI that identifies the test
     *
     * @return uri identifier of test
     */
    public String getTargetURI() {
        return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/internalSubset01";
    }

}
