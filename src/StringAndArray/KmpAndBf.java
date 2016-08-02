package StringAndArray;

import StringAndArray.BF.BF;
import StringAndArray.KMP.KMP;

import java.io.*;

/**
 * Created by jackstrom on 2016/4/27.
 */
public class KmpAndBf {
    public static void main(String[] args){
        String template = "";
        {
            template = "================================================================================\n" +
                    "  Licensed to the Apache Software Foundation (ASF) under one or more\n" +
                    "  contributor license agreements.  See the NOTICE file distributed with\n" +
                    "  this work for additional information regarding copyright ownership.\n" +
                    "  The ASF licenses this file to You under the Apache License, Version 2.0\n" +
                    "  (the \"License\"); you may not use this file except in compliance with\n" +
                    "  the License.  You may obtain a copy of the License at\n" +
                    "\n" +
                    "      http://www.apache.org/licenses/LICENSE-2.0\n" +
                    "\n" +
                    "  Unless required by applicable law or agreed to in writing, software\n" +
                    "  distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                    "  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                    "  See the License for the specific language governing permissions and\n" +
                    "  limitations under the License.\n" +
                    "================================================================================\n" +
                    "\n" +
                    "\n" +
                    "                     Apache Tomcat Version 8.0.32\n" +
                    "                            Release Notes\n" +
                    "\n" +
                    "\n" +
                    "=========\n" +
                    "CONTENTS:\n" +
                    "=========\n" +
                    "\n" +
                    "* Dependency Changes\n" +
                    "* API Stability\n" +
                    "* Bundled APIs\n" +
                    "* Web application reloading and static fields in shared libraries\n" +
                    "* Security manager URLs\n" +
                    "* Symlinking static resources\n" +
                    "* Viewing the Tomcat Change Log\n" +
                    "* Cryptographic software notice\n" +
                    "* When all else fails\n" +
                    "\n" +
                    "\n" +
                    "===================\n" +
                    "Dependency Changes:\n" +
                    "===================\n" +
                    "Tomcat 8.0 is designed to run on Java SE 7 and later.\n" +
                    "\n" +
                    "\n" +
                    "==============\n" +
                    "API Stability:\n" +
                    "==============\n" +
                    "\n" +
                    "The public interfaces for the following classes are fixed and will not be\n" +
                    "changed at all during the remaining lifetime of the 8.x series:\n" +
                    "- All classes in the javax namespace\n" +
                    "\n" +
                    "The public interfaces for the following classes may be added to in order to\n" +
                    "resolve bugs and/or add new features. No existing interface method will be\n" +
                    "removed or changed although it may be deprecated.\n" +
                    "- org.apache.catalina.* (excluding sub-packages)\n" +
                    "\n" +
                    "Note: As Tomcat 8 matures, the above list will be added to. The list is not\n" +
                    "      considered complete at this time.\n" +
                    "\n" +
                    "The remaining classes are considered part of the Tomcat internals and may change\n" +
                    "without notice between point releases.\n" +
                    "\n" +
                    "\n" +
                    "=============\n" +
                    "Bundled APIs:\n" +
                    "=============\n" +
                    "A standard installation of Tomcat 8.0 makes all of the following APIs available\n" +
                    "for use by web applications (by placing them in \"lib\"):\n" +
                    "* annotations-api.jar (Annotations package)\n" +
                    "* catalina.jar (Tomcat Catalina implementation)\n" +
                    "* catalina-ant.jar (Tomcat Catalina Ant tasks)\n" +
                    "* catalina-ha.jar (High availability package)\n" +
                    "* catalina-storeconfig.jar (Generation of XML configuration from current state)\n" +
                    "* catalina-tribes.jar (Group communication)\n" +
                    "* ecj-4.4.2.jar (Eclipse JDT Java compiler)\n" +
                    "* el-api.jar (EL 3.0 API)\n" +
                    "* jasper.jar (Jasper 2 Compiler and Runtime)\n" +
                    "* jasper-el.jar (Jasper 2 EL implementation)\n" +
                    "* jsp-api.jar (JSP 2.3 API)\n" +
                    "* servlet-api.jar (Servlet 3.1 API)\n" +
                    "* tomcat-api.jar (Interfaces shared by Catalina and Jasper)\n" +
                    "* tomcat-coyote.jar (Tomcat connectors and utility classes)\n" +
                    "* tomcat-dbcp.jar (package renamed database connection pool based on Commons DBCP)\n" +
                    "* tomcat-jdbc.jar (Tomcat's database connection pooling solution)\n" +
                    "* tomcat-jni.jar (Interface to the native component of the APR/native connector)\n" +
                    "* tomcat-util.jar (Various utilities)\n" +
                    "* tomcat-websocket.jar (WebSocket 1.1 implementation)\n" +
                    "* websocket-api.jar (WebSocket 1.1 API)\n" +
                    "\n" +
                    "You can make additional APIs available to all of your web applications by\n" +
                    "putting unpacked classes into a \"classes\" directory (not created by default),\n" +
                    "or by placing them in JAR files in the \"lib\" directory.\n" +
                    "\n" +
                    "To override the XML parser implementation or interfaces, use the endorsed\n" +
                    "mechanism of the JVM. The default configuration defines JARs located in\n" +
                    "\"endorsed\" as endorsed.\n" +
                    "\n" +
                    "\n" +
                    "================================================================\n" +
                    "Web application reloading and static fields in shared libraries:\n" +
                    "================================================================\n" +
                    "Some shared libraries (many are part of the JDK) keep references to objects\n" +
                    "instantiated by the web application. To avoid class loading related problems\n" +
                    "(ClassCastExceptions, messages indicating that the classloader\n" +
                    "is stopped, etc.), the shared libraries state should be reinitialized.\n" +
                    "\n" +
                    "Something which might help is to avoid putting classes which would be\n" +
                    "referenced by a shared static field in the web application classloader,\n" +
                    "and putting them in the shared classloader instead (JARs should be put in the\n" +
                    "\"lib\" folder, and classes should be put in the \"classes\" folder).\n" +
                    "\n" +
                    "\n" +
                    "======================\n" +
                    "Security manager URLs:\n" +
                    "======================\n" +
                    "In order to grant security permissions to JARs located inside the\n" +
                    "web application repository, use URLs of of the following format\n" +
                    "in your policy file:\n" +
                    "\n" +
                    "file:${catalina.base}/webapps/examples/WEB-INF/lib/driver.jar\n" +
                    "\n" +
                    "\n" +
                    "============================\n" +
                    "Symlinking static resources:\n" +
                    "============================\n" +
                    "By default, Unix symlinks will not work when used in a web application to link\n" +
                    "resources located outside the web application root directory.\n" +
                    "\n" +
                    "This behavior is optional, and the \"allowLinking\" flag may be used to disable\n" +
                    "the check.\n" +
                    "\n" +
                    "\n" +
                    "==============================\n" +
                    "Viewing the Tomcat Change Log:\n" +
                    "==============================\n" +
                    "The full change log is available from http://tomcat.apache.org and is also\n" +
                    "included in the documentation web application.\n" +
                    "\n" +
                    "\n" +
                    "=============================\n" +
                    "Cryptographic software notice\n" +
                    "=============================\n" +
                    "This distribution includes cryptographic software.  The country in\n" +
                    "which you currently reside may have restrictions on the import,\n" +
                    "possession, use, and/or re-export to another country, of\n" +
                    "encryption software.  BEFORE using any encryption software, please\n" +
                    "check your country's laws, regulations and policies concerning the\n" +
                    "import, possession, or use, and re-export of encryption software, to\n" +
                    "see if this is permitted.  See <http://www.wassenaar.org/> for more\n" +
                    "information.\n" +
                    "\n" +
                    "The U.S. Government Department of Commerce, Bureau of Industry and\n" +
                    "Security (BIS), has classified this software as Export Commodity\n" +
                    "Control Number (ECCN) 5D002.C.1, which includes information security\n" +
                    "software using or performing cryptographic functions with asymmetric\n" +
                    "algorithms.  The form and manner of this Apache Software Foundation\n" +
                    "distribution makes it eligible for export under the License Exception\n" +
                    "ENC Technology Software Unrestricted (TSU) exception (see the BIS\n" +
                    "Export Administration Regulations, Section 740.13) for both object\n" +
                    "code and source code.\n" +
                    "\n" +
                    "The following provides more details on the included cryptographic\n" +
                    "software:\n" +
                    "  - Tomcat includes code designed to work with JSSE\n" +
                    "  - Tomcat includes code designed to work with OpenSSL\n" +
                    "\n" +
                    "\n" +
                    "====================\n" +
                    "When all else fails:\n" +
                    "====================\n" +
                    "See the FAQ\n" +
                    "http://tomcat.apache.org/faq/\n";
        }
        String pattern = "Regulations";

        BF bf = new BF();
        KMP kmp = new KMP();

        //BF
        bf.setPattern(pattern);
        bf.setMainString(template);
        long start = System.currentTimeMillis();
        int index = bf.matches();
        System.out.println(System.currentTimeMillis()-start);
        System.out.println("index:"+index+" "+template.substring(index,index+pattern.length()));
        System.out.println();

        //KMP
        start = System.currentTimeMillis();
        index = kmp.matches(template,kmp.getNextArray(pattern),pattern);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("index:"+index+" "+template.substring(index,index+pattern.length()));
    }
}
