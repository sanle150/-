package com.example.andriod_solar_term.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.andriod_solar_term.beans.Solar;

import java.util.List;


public interface SolarService extends IService<Solar> {
    List<Solar> searchAll();

    void addSolar(Solar solar);

    Solar searchByName();
}
