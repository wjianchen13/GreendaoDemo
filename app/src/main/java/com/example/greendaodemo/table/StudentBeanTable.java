package com.example.greendaodemo.table;

import com.example.greendaodemo.bean.StudentBean;
import com.example.greendaodemo.dao.StudentBeanDao;
import com.example.greendaodemo.manager.DaoManager;

import java.util.List;

public class StudentBeanTable {

    private static volatile StudentBeanTable table = null;

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

    private StudentBeanDao studentDao;

    public StudentBeanTable() {
        studentDao = DaoManager.getInstance().getDaoSession().getStudentBeanDao();
    }

    public void insert(StudentBean student) {
        studentDao.insert(student);
    }
    
    public void insertOrReplace(StudentBean student) {
        studentDao.insertOrReplace(student);
    }

    public List<StudentBean> loadAll() {
        return studentDao.loadAll();
    }

//    public StudentBean load(StudentBean student) {
//        StudentBean students2 = studentDao.load(Void);
//        return students2;
//    }
    
    public StudentBean query() {
        StudentBean students = studentDao.loadByRowId(0L);
        return students;
    }


    public void update(StudentBean student) {
           studentDao.update(student);
    }

    public void updateInTx(StudentBean student) {
        studentDao.updateInTx(student);
    }

    public void delete(StudentBean student) {
        studentDao.delete(student);
    }

    
    
}
