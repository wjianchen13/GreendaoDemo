package com.example.greendaodemo.table;

import com.example.greendaodemo.bean.StudentBean;
import com.example.greendaodemo.dao.StudentBeanDao;
import com.example.greendaodemo.manager.DaoManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * insert 插入一条数据  实体对象为参数
 * insertInTx 批量插入数据  List<>型参数
 * insertOrReplace 插入数据，传入的对象主键如果存在于数据库中，有则更新，否则插入  实体对象为参数
 * insertOrReplaceInTx 批量插入数据 List<>型参数
 * save 插入数据，判断对象是否有Key值，有则更新，否则插入  实体对象为参数
 */
public class StudentBeanTable {

    private static volatile StudentBeanTable table = null;
    private StudentBeanDao studentDao;

    public static StudentBeanTable getInstance() {
        if(table == null) {
            synchronized (StudentBeanTable.class) {
                if (table == null) {
                    table = new StudentBeanTable();
                }
            }
        }
        return table;
    }

    public StudentBeanTable() {
        studentDao = DaoManager.getInstance().getDaoSession().getStudentBeanDao();
    }

    public List<StudentBean> loadAll() {
        return studentDao.loadAll();
    }

    public void deleteAll() {
        studentDao.deleteAll();
    }

    public void insert(StudentBean student) {
        studentDao.insert(student);
    }

    public void insertOrReplace(StudentBean student) {
        studentDao.insertOrReplace(student);
    }

    public void save(StudentBean student) {
        studentDao.save(student);
    }

    public void delete(StudentBean student) {
        studentDao.delete(student);
    }

    public void update(StudentBean student) {
        studentDao.update(student);
    }

    public List<StudentBean> queryRaw(String where, String... selectionArg) {
        return studentDao.queryRaw(where, selectionArg);
    }

    public QueryBuilder queryBuilder() {
        return studentDao.queryBuilder();
    }

    public void insertOrReplaceInTx(List<StudentBean> students) {
        studentDao.insertOrReplaceInTx(students);
    }
    
    public StudentBean query() {
        StudentBean students = studentDao.loadByRowId(0L);
        return students;
    }

}
