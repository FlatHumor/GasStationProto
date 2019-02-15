package by.flathumor.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class StartBean
{
    @PostConstruct
    public void onInit() {
        System.out.println("__StartBean.onInit()");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("__StartBean.onDestroy()");
    }
}
