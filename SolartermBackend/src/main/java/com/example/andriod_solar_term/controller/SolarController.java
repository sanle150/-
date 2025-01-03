package com.example.andriod_solar_term.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.andriod_solar_term.beans.Solar;
import com.example.andriod_solar_term.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/solar")
public class SolarController {

    @Autowired
    private SolarService solarService;

    @RequestMapping(value = "/searchAllSolar",method = RequestMethod.GET)
    public List<String> searchAllSolar() {
        List<Solar> solars = solarService.searchAll();
        List<String> solarNames = new ArrayList<>();
        for (Solar solar : solars) {
            String solarName = solar.getSolarName();
            solarNames.add(solarName);
        }
        return solarNames;
    }

    @RequestMapping(value = "/addSolar",method = RequestMethod.POST)
    public void addSolar(@RequestBody Solar solar) {
        if(solar == null) {
            throw new RuntimeException("solar对象为空");
        }
        solarService.addSolar(solar);
    }

}
