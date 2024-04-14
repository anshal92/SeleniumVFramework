package org.ansh.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlSuite;
import org.tinylog.Logger;

public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        Logger.debug("---XXX On Suite Start XXX---");
//        suite.getXmlSuite().setThreadCount(10);
//        suite.getXmlSuite().setParallel(XmlSuite.ParallelMode.METHODS);
    }

    @Override
    public void onFinish(ISuite suite) {
        Logger.debug("---XXX on Suite Finish XXX---");
        ISuiteListener.super.onFinish(suite);
    }



}
