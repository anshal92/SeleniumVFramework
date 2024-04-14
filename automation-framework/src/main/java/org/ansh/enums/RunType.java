package org.ansh.enums;

public enum RunType {
    SELENIUM("seleniumTest.config"),
    APPIUM_ANDROID("appium.config"),
    APPIUM_IOS("appium.config"),
    RESTAPI("restapi.config");


    final String resourceToPick;

    RunType(String resourceToPick) {
        this.resourceToPick = resourceToPick;
    }

    public String getResourceToPick() {
        return this.resourceToPick;
    }
}
