package com.example.greendaodemo.test;

import com.google.gson.Gson;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotoSrcBeanConverter implements PropertyConverter<List<Long>, String> {
    /**
     * 转换成对象属性
     * @param databaseValue
     * @return
     */
    @Override
    public List<Long> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null){
            return null;
        }
        Long[] array = new Gson().fromJson(databaseValue, Long[].class);
        List<Long> list_str = Arrays.asList(array);
        List<Long> srcBeanList= new ArrayList<>();
        if (list_str.size() > 0) {
            srcBeanList.addAll(list_str);
        }
        return srcBeanList;

    }

    /**
     * 转换成数据库属性
     * @param arrays
     * @return
     */
    @Override
    public String convertToDatabaseValue(List<Long> arrays) {
        if (arrays == null) {
            return null;
        } else {
            return new Gson().toJson(arrays);//转换成String类型
        }
    }
}
