package Pages;

import org.ansh.actions.Actions;

public class PageHelper {

    public Actions actions;

    public PageHelper(){
        actions = new Actions();
    }

    public String getPageUrl(){
        return actions.browserAction().getCurrentUrl();
    }
}
