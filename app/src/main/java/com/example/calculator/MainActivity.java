package com.example.calculator;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity {
    //声明组件变量
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    private Button bt_5;
    private Button bt_6;
    private Button bt_7;
    private Button bt_8;
    private Button bt_9;
    private Button bt_0;
    private Button bt_add;
    private Button bt_sub;
    private Button bt_multi;
    private Button bt_div;
    private Button bt_ce;
    private Button bt_clear;
    private Button bt_negetive;
    private Button bt_point;
    private Button bt_equal;
    private Button bt_del;
    private Button bt_mod;
    private Button bt_genhao;
    private Button bt_squ;
    private Button bt_qudao;
    private Button bt_change;
    private EditText editText;
    private String opt = "";
    String s = "";
    private double n1 = 0, n2 = 0;
    //按钮点击事件
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText = (EditText)findViewById(R.id.edit_text);
            String temp = editText.getText().toString();

            Button bt = (Button)v;
            switch(bt.getId()) {
                case R.id.num_one: {    //点击"1"
                    if(s.length() == 1 && s.charAt(0) == '0')
                        s = "1";
                    else
                        s += "1";
                    editText.setText(s);
                    break;
                }
                case R.id.num_two: {    //点击"2"
                    if(s.length() == 1 && s.charAt(0) == '0')
                        s = "2";
                    else
                        s += "2";
                    editText.setText(s);
                    break;
                }
                case R.id.num_three: {  //点击"3"
                    if(s.length() == 1 && s.charAt(0) == '0')
                        s = "3";
                    else
                        s += "3";
                    editText.setText(s);
                    break;
                }
                case R.id.num_four: {   ////点击"4"
                    if(s.length() == 1 && s.charAt(0) == '0')
                        s = "4";
                    else
                        s += "4";
                    editText.setText(s);
                    break;
                }
                case R.id.num_five: {   //点击"5"
                    if(s.length() == 1 && s.charAt(0) == '0')
                        s = "5";
                    else
                        s += "5";
                    editText.setText(s);
                    break;
                }
                case R.id.num_six: {    //点击"6"
                    if(s.length() == 1 && s.charAt(0) == '0')
                        s = "6";
                    else
                        s += "6";
                    editText.setText(s);
                    break;
                }
                case R.id.num_seven: {  //点击"7"
                    if(s.length() == 1 && s.charAt(0) == '0')
                        s = "7";
                    else
                        s += "7";
                    editText.setText(s);
                    break;
                }
                case R.id.num_eight: {  //点击"8"
                    if(s.length() == 1 && s.charAt(0) == '0')
                        s = "8";
                    else
                        s += "8";
                    editText.setText(s);
                    break;
                }
                case R.id.num_nine: {   //点击"9"
                    if (s.length() == 1 && s.charAt(0) == '0')
                        s = "9";
                    else
                        s += "9";
                    editText.setText(s);
                    break;
                }
                case R.id.num_zero: {   //点击"0"
                    if(!(s.length() == 1 && s.charAt(0) == '0'))
                        s += "0";
                    editText.setText(s);
                    break;
                }
                case R.id.delete: {     //回退
                    if(!s.isEmpty())
                        s = s.substring(0, s.length() - 1);
                    editText.setText(s);
                    break;
                }
                case R.id.ce: {     //清除输入
                    s = "";
                    editText.setText("");
                    break;
                }
                case R.id.clear: {  //清零
                    n1 = 0;
                    n2 = 0;
                    editText.setText("");
                    s = "";
                    opt = "";
                    break;
                }
                case R.id.qufu: {   //取负
                    if(s.isEmpty())
                        s = "-" ;
                    else if(s.charAt(0) == '-')
                        s = s.substring(1,s.length());
                    else
                        s = "-" + s;
                    editText.setText(s);
                    break;
                }
                case R.id.point: {  //添加小数点
                    if(s.indexOf('.')==-1){
                        if(s.equals("") || s.length() == 1 && s.charAt(0) == '0')
                            s = "0.";
                        else
                            s += ".";
                    }
                    editText.setText(s);
                    break;
                }
                case R.id.add: {    //点击"+"
                    if(opt == "") {
                        if(!s.isEmpty())
                            n1 = Double.parseDouble(s);
                        s = "";
                    }
                    else
                        clickEqual();
                    opt = "+";
                    break;
                }
                case R.id.sub: {    //点击"-"
                    if(opt == "") {
                        if (!s.isEmpty())
                            n1 = Double.parseDouble(s);
                        s = "";
                    }
                    else
                        clickEqual();
                    opt = "-";
                    break;
                }
                case  R.id.multi: { //点击"*"
                    if(opt == "") {
                        if(!s.isEmpty())
                            n1 = Double.parseDouble(s);
                        s = "";
                    }
                    else
                        clickEqual();
                    opt = "*";
                    break;
                }
                case R.id.div: {    //点击"/"
                    if(opt == "") {
                        if(!s.isEmpty())
                            n1 = Double.parseDouble(s);
                        s = "";
                    }
                    else
                        clickEqual();
                    opt = "/";
                    break;
                }
                case R.id.equal: {  //点击"="
                    clickEqual();
                    break;
                }
                case R.id.genhao: { //点击根号
                    n1 = Double.parseDouble(s);
                    if(n1 < 0)
                        s = "负数没有平方根";
                    else {
                        n1 = Math.sqrt(n1);
                        s = "" + n1;
                    }
                    editText.setText(s);
                    s = "";
                    break;
                }
                case R.id.squ: {    //计算平方
                    n1 = Double.parseDouble(s);
                    n1 = Math.pow(n1,2);
                    s = "" + n1;
                    editText.setText(s);
                    s = "";
                    break;
                }
                case R.id.qudao: {  //点击1/x
                    n1 = Double.parseDouble(s);
                    n1 = 1/n1;
                    s = "" + n1;
                    editText.setText(s);
                    s = "";
                    break;
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册组件
        bt_1 = (Button)findViewById(R.id.num_one);
        bt_2 = (Button)findViewById(R.id.num_two);
        bt_3 = (Button)findViewById(R.id.num_three);
        bt_4 = (Button)findViewById(R.id.num_four);
        bt_5 = (Button)findViewById(R.id.num_five);
        bt_6 = (Button)findViewById(R.id.num_six);
        bt_7 = (Button)findViewById(R.id.num_seven);
        bt_8 = (Button)findViewById(R.id.num_eight);
        bt_9 = (Button)findViewById(R.id.num_nine);
        bt_0 = (Button)findViewById(R.id.num_zero);
        bt_add = (Button)findViewById(R.id.add);
        bt_sub = (Button)findViewById(R.id.sub);
        bt_multi = (Button)findViewById(R.id.multi);
        bt_div = (Button)findViewById(R.id.div);
        bt_equal = (Button)findViewById(R.id.equal);
        bt_qudao = (Button)findViewById(R.id.qudao);
        bt_negetive = (Button)findViewById(R.id.qufu);
        bt_point = (Button)findViewById(R.id.point);
        bt_ce = (Button)findViewById(R.id.ce);
        bt_clear = (Button)findViewById(R.id.clear);
        bt_del = (Button)findViewById(R.id.delete);
        bt_mod = (Button)findViewById(R.id.mod);
        bt_genhao = (Button)findViewById(R.id.genhao);
        bt_squ = (Button)findViewById(R.id.squ);
        bt_change = (Button)findViewById(R.id.change);
        //添加按钮监听器事件
        bt_1.setOnClickListener(listener);
        bt_2.setOnClickListener(listener);
        bt_3.setOnClickListener(listener);
        bt_4.setOnClickListener(listener);
        bt_5.setOnClickListener(listener);
        bt_6.setOnClickListener(listener);
        bt_7.setOnClickListener(listener);
        bt_8.setOnClickListener(listener);
        bt_9.setOnClickListener(listener);
        bt_0.setOnClickListener(listener);
        bt_add.setOnClickListener(listener);
        bt_sub.setOnClickListener(listener);
        bt_multi.setOnClickListener(listener);
        bt_div.setOnClickListener(listener);
        bt_ce.setOnClickListener(listener);
        bt_clear.setOnClickListener(listener);
        bt_negetive.setOnClickListener(listener);
        bt_point.setOnClickListener(listener);
        bt_equal.setOnClickListener(listener);
        bt_del.setOnClickListener(listener);
        bt_mod.setOnClickListener(listener);
        bt_genhao.setOnClickListener(listener);
        bt_squ.setOnClickListener(listener);
        bt_qudao.setOnClickListener(listener);
        bt_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calcu_sci.class);
                startActivity(intent);
            }
        });
    }

    //计算结果
    private void clickEqual() {
        boolean fl = true;
        if(s != "")
            n2 = Double.parseDouble(s);
        if(opt == "+")
            n1 += n2;
        else if(opt == "-")
            n1 -= n2;
        else if(opt == "*")
            n1 *= n2;
        else if(opt == "/") {
            if(n2 != 0.0) {
                n1 /= n2;
            }
            else {
                fl = false;
            }
        }
        opt = "";
        if(fl == true)
            s = ""+n1;
        else
            s = "除数不能为0";
        editText.setText(s);
        s = "";
    }


}
