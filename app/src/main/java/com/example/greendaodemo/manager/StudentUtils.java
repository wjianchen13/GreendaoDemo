package com.example.greendaodemo.manager;

import com.example.greendaodemo.bean.StudentBean;
import com.example.greendaodemo.table.StudentBeanTable;

import java.util.List;

public class StudentUtils {

    /**
     * 查找全部数据
     * @return
     */
    public static List queryAll() {
        List<StudentBean> students = StudentBeanTable.getInstance().loadAll();
        return students;
    }

    /**
     * 删除全部数据
     * @return
     */
    public static void deleteAll() {
        StudentBeanTable.getInstance().deleteAll();
    }


    /**
     * 插入一条数据
     * @return
     */
    public static void insert(StudentBean bean) {
        if(bean != null) {
            StudentBeanTable.getInstance().insert(bean);
        }
    }

    /**
     * insertOrReplace 数据存在则替换，数据不存在则插入
     * @param bean
     */
    public static void insertOrReplace(StudentBean bean) {
        if(bean != null) {
            StudentBeanTable.getInstance().insertOrReplace(bean);
        }
    }

}
