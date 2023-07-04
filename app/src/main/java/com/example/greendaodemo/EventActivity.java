package com.example.greendaodemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodemo.bean.EventBean;
import com.example.greendaodemo.manager.EventUtils;
import com.example.greendaodemo.table.EventBeanTable;
import com.example.greendaodemo.util.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }

    public void onInsert(View v) {
        EventUtils.isUploadEventExcludeDevice("111", "2222", "测试1");
    }

    public void onDelete(View v) {
        EventUtils.isUploadEventExcludeDevice("111", "2222", "测试1");
    }

    public void onUpdate(View v) {
        EventUtils.isUploadEventExcludeDevice("112", "2222", "测试1");
    }

    public void onQuery(View v) {
        EventUtils.isUploadEventExcludeDevice("111", "2223", "测试1");
    }

    public void onQueryAll(View v) {
        List<EventBean> events = EventBeanTable.getInstance().queryAll();
        Utils.log("events size: " + (events != null ? events.size() : 0));
        for(EventBean bean : events) {
            Utils.log("uid: " + bean.getUId() + "  eventId: " + bean.getEventId() + "  imei: " + bean.getImei() + "  eventDesc: " + bean.getEventDesc() + "  time: " + sdf.format(new Date(bean.getCtime())));
        }
    }
    
    /***********************************************************************************************
     * 测试 student
     ***********************************************************************************************/
//    public void onInsert(View v) {
//        StudentBean student = new StudentBean();
//        student.setId(1);
//        student.setAge(18);
//        student.setGender("3");
//        student.setName("test1");
//        StudentBeanTable.getInstance().insert(student);
//    }
//    
//    public void onDelete(View v) {
//
//    }
//
//    public void onUpdate(View v) {
//
//    }
//
//    public void onQuery(View v) {
//        List<StudentBean> students = StudentBeanTable.getInstance().queryAll();
//        Utils.log("students size: " + (students != null ? students.size() : 0));
//        for(StudentBean bean : students) {
//            Utils.log("id: " + bean.getId() + "  name: " + bean.getName() + "  age: " + bean.getAge() + "  gender: " + bean.getGender());  
//        }
//    }
//

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