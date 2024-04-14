package org.ansh.listeners;


import org.ansh.enums.RunType;
import org.ansh.utils.BaseFileHelper;
import org.testng.IExecutionListener;
import org.tinylog.Logger;

import java.util.Properties;

public class ExecutionListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        Logger.debug("---XXX OnExecution Start XXX---");
        Properties properties = BaseFileHelper.getDataAsProperties(RunType.SELENIUM);
        BaseFileHelper.setSystemProperty(properties);
        IExecutionListener.super.onExecutionStart();
    }

    @Override
    public void onExecutionFinish() {
        Logger.debug("---XXX OnExecution Finish XXX---");
        IExecutionListener.super.onExecutionFinish();
    }
}
