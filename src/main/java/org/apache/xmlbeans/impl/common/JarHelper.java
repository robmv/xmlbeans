/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.xmlbeans.impl.common;

import java.io.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

/**
 * Provides utility services for jarring and unjarring files and directories.
 * Note that a given instance of JarHelper is not threadsafe with respect to
 * multiple jar operations.
 */
public class JarHelper {
    // ========================================================================
    // Constants

    private static final int BUFFER_SIZE = 2156;

    // ========================================================================
    // Variables

    private final byte[] mBuffer = new byte[BUFFER_SIZE];
    private boolean mVerbose = false;
    private String mDestJarName = "";

    // ========================================================================
    // Constructor

    /**
     * Instantiates a new JarHelper.
     */
    public JarHelper() {
    }

    // ========================================================================
    // Public methods

    /**
     * Jars a given directory or single file into a JarOutputStream.
     */
    public void jarDir(File dirOrFile2Jar, File destJar)
        throws IOException {

        if (dirOrFile2Jar == null || destJar == null) {
            throw new IllegalArgumentException();
        }

        mDestJarName = destJar.getCanonicalPath();
        try (FileOutputStream fout = new FileOutputStream(destJar);
             JarOutputStream jout = new JarOutputStream(fout)) {
            //jout.setLevel(0);
            jarDir(dirOrFile2Jar, jout, null);
        }
    }

    /**
     * Unjars a given jar file into a given directory.
     */
    public void unjarDir(File jarFile, File destDir) throws IOException {
        try (FileInputStream fis = new FileInputStream(jarFile)) {
            unjar(fis, destDir);
        }
    }

    /**
     * Given an InputStream on a jar file, unjars the contents into the given
     * directory.
     */
    public void unjar(InputStream in, File destDir) throws IOException {
        try (JarInputStream jis = new JarInputStream(in)) {
            JarEntry entry;
            while ((entry = jis.getNextJarEntry()) != null) {
                if (entry.isDirectory()) {
                    File dir = new File(destDir, entry.getName());
                    String canonicalDestinationPath = dir.getCanonicalPath();
                    if (!canonicalDestinationPath.startsWith(destDir.getCanonicalPath())) {
                        throw new IOException("Entry is outside of the target directory " + entry.getName());
                    }
                    dir.mkdir();
                    if (entry.getTime() != -1) {
                        dir.setLastModified(entry.getTime());
                    }
                    continue;
                }
                int count;
                byte[] data = new byte[BUFFER_SIZE];
                File destFile = new File(destDir, entry.getName());
                String canonicalDestinationPath = destFile.getCanonicalPath();
                if (!canonicalDestinationPath.startsWith(destDir.getCanonicalPath())) {
                    throw new IOException("Entry is outside of the target directory: " + entry.getName());
                }
                if (mVerbose) {
                    System.out.println("unjarring " + destFile +
                                       " from " + entry.getName());
                }

                try (
                        FileOutputStream fos = new FileOutputStream(destFile);
                        BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER_SIZE)
                ) {
                    while ((count = jis.read(data, 0, BUFFER_SIZE)) != -1) {
                        dest.write(data, 0, count);
                    }
                    dest.flush();
                }
                if (entry.getTime() != -1) {
                    destFile.setLastModified(entry.getTime());
                }
            }
        }
    }

    public void setVerbose(boolean b) {
        mVerbose = b;
    }

    // ========================================================================
    // Private methods

    private static final char SEP = '/';

    /**
     * Recursively jars up the given path under the given directory.
     */
    private void jarDir(File dirOrFile2jar, JarOutputStream jos, String path)
        throws IOException {
        if (mVerbose) {
            System.out.println("checking " + dirOrFile2jar);
        }
        if (dirOrFile2jar.isDirectory()) {
            String[] dirList = dirOrFile2jar.list();
            String subPath = (path == null) ? "" : (path + dirOrFile2jar.getName() + SEP);
            if (path != null) {
                JarEntry je = new JarEntry(subPath);
                je.setTime(dirOrFile2jar.lastModified());
                jos.putNextEntry(je);
                jos.flush();
                jos.closeEntry();
            }
            if (dirList != null) {
                for (String s : dirList) {
                    File f = new File(dirOrFile2jar, s);
                    jarDir(f, jos, subPath);
                }
            }
        } else {
            if (dirOrFile2jar.getCanonicalPath().equals(mDestJarName)) {
                if (mVerbose) {
                    System.out.println("skipping " + dirOrFile2jar.getPath());
                }
                return;
            }

            if (mVerbose) {
                System.out.println("adding " + dirOrFile2jar.getPath());
            }
            try (FileInputStream fis = new FileInputStream(dirOrFile2jar)) {
                JarEntry entry = new JarEntry(path + dirOrFile2jar.getName());
                entry.setTime(dirOrFile2jar.lastModified());
                jos.putNextEntry(entry);
                int mByteCount;
                while ((mByteCount = fis.read(mBuffer)) != -1) {
                    jos.write(mBuffer, 0, mByteCount);
                    if (mVerbose) {
                        System.out.println("wrote " + mByteCount + " bytes");
                    }
                }
                jos.flush();
                jos.closeEntry();
            }
        }
    }

    // for debugging
    public static void main(String[] args)
        throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: JarHelper jarname.jar directory");
            return;
        }

        JarHelper jarHelper = new JarHelper();
        jarHelper.mVerbose = true;

        File destJar = new File(args[0]);
        File dirOrFile2Jar = new File(args[1]);

        jarHelper.jarDir(dirOrFile2Jar, destJar);
    }
}
