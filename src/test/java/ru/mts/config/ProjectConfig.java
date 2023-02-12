package ru.mts.config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:remote.properties"})
public interface ProjectConfig extends Config {


    @Key("baseUrl")
    String baseUrl();



}
