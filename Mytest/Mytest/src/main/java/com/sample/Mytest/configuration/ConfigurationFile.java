package com.sample.Mytest.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties("scanevent")
public class ConfigurationFile {

    public String getDelivered_DLVD() {
        return Delivered_DLVD;
    }

    public String getLoaded_Loaded() {
        return Loaded_Loaded;
    }

    public void setDelivered_DLVD(String delivered_DLVD) {
        Delivered_DLVD = delivered_DLVD;
    }

    public void setLoaded_Loaded(String loaded_Loaded) {
        Loaded_Loaded = loaded_Loaded;
    }

    private String Delivered_DLVD;
    private String Loaded_Loaded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getCarrierscan() {
        return carrierscan;
    }

    public String getServicescan() {
        return servicescan;
    }

    private String carrierscan;

    public void setCarrierscan(String carrierscan) {
        this.carrierscan = carrierscan;
    }

    public void setServicescan(String servicescan) {
        this.servicescan = servicescan;
    }

    private String servicescan;
}
