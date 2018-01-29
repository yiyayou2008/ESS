package cn.wilmar.ess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //定义dbHelper对象
    private MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //定义数据库名称为ESS，版本为1
        dbHelper = new MyDBHelper(this, "ESS.db", null, 1);
        //以只读方式创建数据库
        dbHelper.getReadableDatabase();
        dbHelper.close();

        //查询备件按钮
        Button btnSeek = (Button) findViewById(R.id.btnSeek);
        //设备编号EditText
        final EditText edtEQID = (EditText) findViewById(R.id.edtEQID);
        btnSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //若设备编号为空，提示用户
                if (edtEQID.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "设备编号不能为空，请重新输入！", Toast.LENGTH_SHORT).show();
                    return;
                }
                //查询数据库，若未得查数据，提示用户
                if (1>1){
                    //dbHelper.rawquery
                    Toast.makeText(MainActivity.this, "设备编号并不存在，请重新输入！", Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });
    }
}

