package com.example.greendaodemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodemo.bean.EventBean;
import com.example.greendaodemo.bean.StudentBean;
import com.example.greendaodemo.dao.StudentBeanDao;
import com.example.greendaodemo.manager.DaoManager;
import com.example.greendaodemo.manager.EventUtils;
import com.example.greendaodemo.manager.StudentUtils;
import com.example.greendaodemo.table.EventBeanTable;
import com.example.greendaodemo.util.Utils;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    /**
     * 查询所有数据
     * @param v
     */
    public void onTest1(View v){
        List list = StudentUtils.loadAll();
        if(list != null) {
            if(list.size() == 0)
                Utils.log("数据为空");
            for (int i = 0; i < list.size(); i ++) {
                Utils.log("index " + i + ": " + list.get(i).toString());
            }
        }
    }

    /**
     * 删除全部数据
     * @param v
     */
    public void onTest2(View v) {
        StudentUtils.deleteAll();
    }

    /**
     * 插入一条数据
     * @param v
     */
    public void onTest3(View v) {
        StudentBean bean = new StudentBean((long) 1, 1, "test1", 11, "男");
        StudentUtils.insert(bean);
    }

    /**
     * 插入一条数据，使用DaoSession
     * @param v
     */
    public void onTest4(View v) {
        StudentBean bean = new StudentBean((long) 2, 1, "test1", 11, "男");
        DaoManager.getInstance().getDaoSession().insert(bean);
    }

    /**
     * insertOrReplace
     * @param v
     */
    public void onTest5(View v) {
        StudentBean bean = new StudentBean((long) 3, 2, "test1", 11, "男");
        StudentUtils.insertOrReplace(bean);
    }

    /**
     * save 类似于insertOrReplace，区别在于save会判断传入对象的key，有key的对象执行更新，无key的执行插入。当对象有key但并不在数据库时会执行失败.适用于保存本地列表。
     * @param v
     */
    public void onTest6(View v) {
        StudentBean bean = new StudentBean((long) 3, 1, "test11111111", 11, "男");
        StudentUtils.save(bean);
    }

    /**
     * 根据主键删除某个数据
     * @param v
     */
    public void onTest7(View v) {
        StudentBean bean = new StudentBean((long) 3, 12, "test11111111", 113, "女");
        StudentUtils.delete(bean);
    }

    /**
     * 根据主键修改某个数据
     * @param v
     */
    public void onTest8(View v) {
        StudentBean bean = new StudentBean((long) 3, 12, "test11111111", 113, "女");
        StudentUtils.update(bean);
    }

    /**
     * 查询数据
     * @param v
     */
    public void onTest9(View v) {
        List<StudentBean> beans = StudentUtils.queryRaw("where uid = ?", "1");
        for (int i = 0; i < beans.size(); i ++) {
            Utils.log("index " + i + ": " + beans.get(i).toString());
        }
    }

    /**
     * queryBuilder查询数据
     * @param v
     */
    public void onTest10(View v) {
        QueryBuilder qb = StudentUtils.queryBuilder();
        List<StudentBean> beans = qb.list();
        for (int i = 0; i < beans.size(); i ++) {
            Utils.log("index " + i + ": " + beans.get(i).toString());
        }
    }

    /**
     * 批量插入数据
     * @param v
     */
    public void onTest11(View v) {
        List<StudentBean> beans = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            StudentBean bean = new StudentBean((long) i, i, "test" + (i % 3), 20 + i, i % 2 == 0 ? "男" : "女");
            beans.add(bean);
        }
        StudentUtils.insertOrReplaceInTx(beans);
    }

    /**
     * 查询Name为 test1 的所有Student,按照_id降序排序
     * @param v
     */
    public void onTest12(View v) {
        QueryBuilder qb = StudentUtils.queryBuilder();
        QueryBuilder<StudentBean> studentQueryBuilder = qb.where(StudentBeanDao.Properties.Name.eq("test1")).orderDesc(StudentBeanDao.Properties._id);
        List<StudentBean> beans = studentQueryBuilder.list(); //查出当前对应的数据
        for (int i = 0; i < beans.size(); i ++) {
            Utils.log("index " + i + ": " + beans.get(i).toString());
        }
    }

    /**
     * 查询uid大于5的学生
     * @param v
     */
    public void onTest13(View v) {
        QueryBuilder qb = StudentUtils.queryBuilder();
        Query<StudentBean> query = qb.where(new WhereCondition.StringCondition("UID IN " +
                        "(SELECT UID FROM STUDENT_BEAN WHERE UID > 5)")
        ).build();
        List<StudentBean> beans = query.list();
        for (int i = 0; i < beans.size(); i ++) {
            Utils.log("index " + i + ": " + beans.get(i).toString());
        }
    }


    /**
     * uid大于5小于10，Name值为test0的数据
     * @param v
     */
    public void onTest14(View v) {
        QueryBuilder qb = StudentUtils.queryBuilder();
        List<StudentBean> beans = qb.where(StudentBeanDao.Properties.Name.eq("test0"),
                qb.and(StudentBeanDao.Properties.Uid.gt(5),
                        StudentBeanDao.Properties.Uid.le(50))).list();
        for (int i = 0; i < beans.size(); i ++) {
            Utils.log("index " + i + ": " + beans.get(i).toString());
        }
    }

    /**
     * 取5条Uid大于2的数据，且偏移2条
     * @param v
     */
    public void onTest15(View v) {
        QueryBuilder qb = StudentUtils.queryBuilder();
        List<StudentBean> beans = qb.where(StudentBeanDao.Properties.Uid.gt(2)).limit(5).offset(2).list();
        for (int i = 0; i < beans.size(); i ++) {
            Utils.log("index " + i + ": " + beans.get(i).toString());
        }
    }

    /**
     * 多次执行查找
     * @param v
     */
    public void onTest16(View v) {
        QueryBuilder qb = StudentUtils.queryBuilder();
        //搜索条件为Uid值大于1，即结果为[1,2,3,4,5];
        // offset(2)表示往后偏移2个，结果为[3,4,5,6,7];
        Query<StudentBean> query = qb.where(StudentBeanDao.Properties.Uid.gt(0)).limit(5).offset(2).build();
        List<StudentBean> list = query.list();
        for (int i = 0; i < list.size(); i ++) {
            Utils.log("index " + i + ": " + list.get(i).toString());
        }
        //通过SetParameter来修改上面的查询条件，比如我们将上面条件修改取5条Id值大于2，往后偏移两位的数据，方法如下！
        // setParameter 第一个表示条件的索引，在上边的条件是uid大于0，现在改成2，这个索引不能设置超过本来的数值，
        // 例如设置成1会报错，IllegalArgumentException: Illegal parameter index: 1，因为条件只有一个
        query.setParameter(0,2);
        List<StudentBean> list1 = query.list();
        for (int i = 0; i < list1.size(); i ++) {
            Utils.log("index " + i + ": " + list1.get(i).toString());
        }
    }

    /**
     * 使用QueryBuilder进行批量删除操作
     * 删除数据库中Uid大于5的所有其他数据
     * @param v
     */
    public void onTest17(View v) {
        QueryBuilder qb = StudentUtils.queryBuilder();
        QueryBuilder<StudentBean> where = qb.where(StudentBeanDao.Properties.Uid.gt(5));
        DeleteQuery<StudentBean> deleteQuery = where.buildDelete();
        deleteQuery.executeDeleteWithoutDetachingEntities();
    }

    /***********************************************************************************************
     * 拷贝数据库到外置sd卡下
     ***********************************************************************************************/
    private final static String FROMPATH = "/data/data/com.example.greendaodemo/databases/";
    private final static String TOPATH = "/mnt/sdcard/test/";

    /**
     * 需要打开设置页面手动授权，读写SD卡权限3.
     * 
     * @param v
     */
    public void onCopy(View v) {
        if (copy(FROMPATH, TOPATH) == 0) {
            Toast.makeText(this, "文件拷贝成功！！！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "文件拷贝失败！！！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 文件拷贝
     *
     * @param
     * @return
     */
    public int copy(String fromFile, String toFile) {
        //要复制的文件目录
        File[] currentFiles;
        File root = new File(fromFile);
        //如同判断SD卡是否存在或者文件是否存在
        //如果不存在则 return出去
        if (!root.exists()) {
            return -1;
        }
        //如果存在则获取当前目录下的全部文件 填充数组
        currentFiles = root.listFiles();

        //目标目录
        File targetDir = new File(toFile);
        //创建目录
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        //遍历要复制该目录下的全部文件
        for (int i = 0; i < currentFiles.length; i++) {
            if (currentFiles[i].isDirectory()) { // 如果当前项为子目录 进行递归
                copy(currentFiles[i].getPath() + "/", toFile + currentFiles[i].getName() + "/");

            } else { // 如果当前项为文件则进行文件拷贝
                CopySdcardFile(currentFiles[i].getPath(), toFile + currentFiles[i].getName());
            }
        }
        return 0;
    }

    /**
     * 文件拷贝
     * 要复制的目录下的所有非子目录(文件夹)文件拷贝
     *
     * @param
     * @return
     */
    public int CopySdcardFile(String fromFile, String toFile) {
        if("/data/data/com.example.greendaodemo/databases/MyGreenDaoDb.db".equals(fromFile)) {
            try {
                InputStream fosfrom = new FileInputStream(fromFile);
                OutputStream fosto = new FileOutputStream(toFile);
                byte bt[] = new byte[1024];
                int c;
                while ((c = fosfrom.read(bt)) > 0) {
                    fosto.write(bt, 0, c);
                }
                fosfrom.close();
                fosto.close();
                return 0;
            } catch (Exception ex) {
                return -1;
            }
        }
        return -1;
    }


}