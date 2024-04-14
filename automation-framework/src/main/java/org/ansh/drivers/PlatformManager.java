package org.ansh.drivers;

public class PlatformManager {
    public static final ThreadLocal<String> threadLocalPlatform = new ThreadLocal<>();

    public static String getPlatformName(){
        return threadLocalPlatform.get();
    }

    public static void setPlatformName(String platformName){
        threadLocalPlatform.set(platformName);
    }

    public static void unload(){
        threadLocalPlatform.remove();
    }
}
