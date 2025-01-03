package com.example.andriod_solar_term.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.andriod_solar_term.beans.Solaritem;

import java.util.List;



public interface SolaritemService extends IService<Solaritem> {
    List<Solaritem> searchAllItems();

    void addSolaritem(Solaritem solaritem);

    void deleteSolaritem(String solarName);

    void updateSolaritem(Solaritem solaritem);
}
