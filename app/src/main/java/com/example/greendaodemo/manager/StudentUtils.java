package com.example.greendaodemo.manager;

import com.example.greendaodemo.bean.StudentBean;
import com.example.greendaodemo.table.StudentBeanTable;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class StudentUtils {

    /**
     * 查找全部数据
     * @return
     */
    public static List loadAll() {
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

    /**
     * save 类似于insertOrReplace，区别在于save会判断传入对象的key，有key的对象执行更新，无key的执行插入。当对象有key但并不在数据库时会执行失败.适用于保存本地列表。
     * @param bean
     */
    public static void save(StudentBean bean) {
        if(bean != null) {
            StudentBeanTable.getInstance().save(bean);
        }
    }

    /**
     * 删除一个数据
     * @param bean
     */
    public static void delete(StudentBean bean) {
        if(bean != null) {
            StudentBeanTable.getInstance().delete(bean);
        }
    }

    /**
     * 修改一个数据
     * @param bean
     */
    public static void update(StudentBean bean) {
        if(bean != null) {
            StudentBeanTable.getInstance().update(bean);
        }
    }

    /**
     * 查询数据
     * @param where
     * @param
     */
    public static List<StudentBean> queryRaw(String where, String... selectionArg) {
        return StudentBeanTable.getInstance().queryRaw(where, selectionArg);
    }

    /**
     * 查询数据
     */
    public static QueryBuilder queryBuilder() {
        return StudentBeanTable.getInstance().queryBuilder();
    }

    /**
     * 插入一组数据
     * @return
     */
    public static void insertOrReplaceInTx(List<StudentBean> students) {
        if(students != null) {
            StudentBeanTable.getInstance().insertOrReplaceInTx(students);
        }
    }


}
