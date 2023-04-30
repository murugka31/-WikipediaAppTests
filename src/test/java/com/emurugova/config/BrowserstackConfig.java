package com.emurugova.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface BrowserstackConfig extends Config {

    @Key("browserstackUser")
    String getBrowserstackUser();

    @Key("browserstackKey")
    String getBrowserstackKey();

    @Key("browserstackUrl")
    String getBrowserstackUrl();
}
