package com.example.andriod_solar_term.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.andriod_solar_term.beans.Solar;
import com.example.andriod_solar_term.mapper.SolarMapper;
import com.example.andriod_solar_term.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SolarServiceImpl extends ServiceImpl<SolarMapper, Solar>
    implements SolarService {

    @Autowired
    private SolarMapper solarMapper;

    @Override
    public List<Solar> searchAll() {
        List<Solar> solarList = this.list();
        return solarList;
    }

    @Override
    public void addSolar(Solar solar) {
        this.save(solar);
    }

    @Override
    public Solar searchByName() {
        return null;
    }
}




