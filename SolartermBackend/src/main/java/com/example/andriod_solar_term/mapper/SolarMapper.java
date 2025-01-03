package com.example.andriod_solar_term.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.andriod_solar_term.beans.Solar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SolarMapper extends BaseMapper<Solar> {

    List<Solar> searchAll();

    void addSolar(Solar solar);

}




