package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calcu_sci extends Activity {
    //声明组件
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
    private Button bt_mi, bt_sin, bt_cos, bt_tan, bt_log, bt_lifang, bt_kaifang;
    private Button bt_sinf, bt_cosf, bt_tanf, bt_em, bt_ln, bt_pie, bt_jiecheng;
    private Button bt_kuohaol, bt_kuohaor;
    private EditText editText;
    private TextView textView;
    private String opt = "";    //保存选择的操作符
    String s = "";      //记录输入的算式
    String str = "";    //记录输入的算式
    private boolean kh = false;     //记录是否出现括号
    private double n1 = 0, n2 = 0;  //运算数
    //按钮点击事件
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        editText = (EditText)findViewById(R.id.edit_text);
        String temp = editText.getText().toString();
        textView = (TextView)findViewById(R.id.text_view);
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
            case R.id.num_three: {   //点击"3"
                if(s.length() == 1 && s.charAt(0) == '0')
                    s = "3";
                else
                    s += "3";
                editText.setText(s);
                break;
            }
            case R.id.num_four: {   //点击"4"
                if(s.length() == 1 && s.charAt(0) == '0')
                    s = "4";
                else
                    s += "4";
                editText.setText(s);
                break;
            }
            case R.id.num_five: {    //点击"5"
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
            case R.id.num_seven: {   //点击"7"
                if(s.length() == 1 && s.charAt(0) == '0')
                    s = "7";
                else
                    s += "7";
                editText.setText(s);
                break;
            }
            case R.id.num_eight: {   //点击"8"
                if(s.length() == 1 && s.charAt(0) == '0')
                    s = "8";
                else
                    s += "8";
                editText.setText(s);
                break;
            }
            case R.id.num_nine: {    //点击"9"
                if (s.length() == 1 && s.charAt(0) == '0')
                    s = "9";
                else
                    s += "9";
                editText.setText(s);
                break;
            }
            case R.id.num_zero: {    //点击"0"
                if(!(s.length() == 1 && s.charAt(0) == '0'))
                    s += "0";
                editText.setText(s);
                break;
            }
            case R.id.delete: {      //点击回退
                if(!s.isEmpty())
                    s = s.substring(0, s.length() - 1);
                editText.setText(s);
                break;
            }
            case R.id.ce: {     //清空输入数
                s = "";
                editText.setText("");
                break;
            }
            case R.id.clear: {      //清零
                n1 = 0;
                n2 = 0;
                editText.setText("");
                s = "";
                str = "";
                textView.setText("");
                opt = "";
                break;
            }
            case R.id.qufu: {       //取负
                if(s.isEmpty())
                    s = "-" ;
                else if(s.charAt(0) == '-')
                    s = s.substring(1,s.length());
                else
                    s = "-" + s;
                editText.setText(s);
                break;
            }
            case R.id.point: {      //加小数点
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
                if(!kh) {
                    if (opt == "") {
                        if (!s.isEmpty()) {
                            n1 = Double.parseDouble(s);
                            str += s;
                            str += " + ";
                        }
                        s = "";
                        textView.setText(str);
                    } else
                        clickEqual();
                    opt = "+";
                }
                else {
                    str += s;
                    str += " + ";
                    s = "";
                    textView.setText(str);
                }
                break;
            }
            case R.id.sub: {    //点击"-"
                if(!kh) {
                    if (opt == "") {
                        if (!s.isEmpty()) {
                            n1 = Double.parseDouble(s);
                            str += s;
                            str += " - ";
                        }
                        s = "";
                        textView.setText(str);
                    } else
                        clickEqual();
                    opt = "-";
                }
                else {
                    str += s;
                    str += " - ";
                    s = "";
                    textView.setText(str);
                }
                break;
            }
            case  R.id.multi: { //点击"*"
                if(!kh) {
                    if (opt == "") {
                        if (!s.isEmpty()) {
                            n1 = Double.parseDouble(s);
                            str += s;
                            str += " * ";
                        }
                        s = "";
                        textView.setText(str);
                    } else
                        clickEqual();
                    opt = "*";
                }
                else {
                    str += s;
                    str += " * ";
                    s = "";
                    textView.setText(str);
                }
                break;
            }
            case R.id.div: {    //点击"/"
                if(!kh) {
                    if (opt == "") {
                        if (!s.isEmpty()) {
                            n1 = Double.parseDouble(s);
                            str += s;
                            str += " / ";
                        }
                        s = "";
                        textView.setText(str);
                    } else
                        clickEqual();
                    opt = "/";
                }
                else {
                    str += s;
                    str += " / ";
                    s = "";
                    textView.setText(str);
                }
                break;
            }
            case R.id.equal: {  //点击"="
                if(!kh)
                    clickEqual();
                else {
                    str += editText.getText().toString();
                    textView.setText(str);
                    double res = stringToArithmetic(str);
                    editText.setText("" + res);
                    str = "";
                    s = "";
                }
                break;
            }
            case R.id.genhao: {     //点击根号
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
            case R.id.squ: {    //点击平方
                n1 = Double.parseDouble(s);
                n1 = Math.pow(n1,2);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.qudao: {  //点击"1/x"
                n1 = Double.parseDouble(s);
                n1 = 1/n1;
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.mihanshu: {   //点击幂函数
                n1 = Double.parseDouble(s);
                s = "";
                opt = "^";
                break;
            }
            case R.id.sin: {    //sin函数
                n1 = Double.parseDouble(s);
                n1 = Math.sin(n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.cos: {    //cos函数
                n1 = Double.parseDouble(s);
                n1 = Math.cos(n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.tan: {    //tan函数
                n1 = Double.parseDouble(s);
                n1 = Math.tan(n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.sinf: {   //sin反函数
                n1 = Double.parseDouble(s);
                n1 = Math.asin(n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.cosf: {   //cos反函数
                n1 = Double.parseDouble(s);
                n1 = Math.acos(n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.tanf: {   //tan反函数
                n1 = Double.parseDouble(s);
                n1 = Math.atan(n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.log: {    //以10为底的log函数
                n1 = Double.parseDouble(s);
                n1 = Math.log10(n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.mod: {    //取余
                n1 = Double.parseDouble(s);
                s = "";
                opt = "%";
                break;
            }
            case R.id.lifang: {     //立方
                n1 = Double.parseDouble(s);
                n1 = Math.pow(n1, 3);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.kaifang: {    //开方
                n1 = Double.parseDouble(s);
                s = "";
                opt = "&";
                break;
            }
            case R.id.e: {      //点击自然对数e
                n1 = Double.parseDouble(s);
                n1 = Math.pow(Math.E, n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.ln: {     //ln函数
                n1 = Double.parseDouble(s);
                n1 = Math.log(n1);
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.pie: {    //pie
                s = ""+Math.PI;
                editText.setText(s);
                break;
            }
            case R.id.jiecheng: {   //计算阶乘
                n1 = Double.parseDouble(s);
                double sum = 1;
                for(int i = 1; i <= n1; i++)
                    sum *= i;
                n1 = sum;
                s = "" + n1;
                editText.setText(s);
                s = "";
                break;
            }
            case R.id.kuohao_l: {   //左括号
                str += "(";
                kh = true;
                textView.setText(str);
                editText.setText(s);
                break;
            }
            case R.id.kuohao_r: {   //右括号
                s += ")";
                editText.setText(s);
                break;
            }
        }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu_sci);

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
        bt_mi = (Button)findViewById(R.id.mihanshu);
        bt_sin = (Button)findViewById(R.id.sin);
        bt_cos = (Button)findViewById(R.id.cos);
        bt_tan = (Button)findViewById(R.id.tan);
        bt_log = (Button)findViewById(R.id.log);
        bt_lifang = (Button)findViewById(R.id.lifang);
        bt_kaifang = (Button)findViewById(R.id.kaifang);
        bt_sinf = (Button)findViewById(R.id.sinf);
        bt_cosf = (Button)findViewById(R.id.cosf);
        bt_tanf = (Button)findViewById(R.id.tanf);
        bt_em = (Button)findViewById(R.id.e);
        bt_ln = (Button)findViewById(R.id.ln);
        bt_pie = (Button)findViewById(R.id.pie);
        bt_jiecheng = (Button)findViewById(R.id.jiecheng);
        bt_kuohaol = (Button)findViewById(R.id.kuohao_l);
        bt_kuohaor = (Button)findViewById(R.id.kuohao_r);
        //按钮添加点击事件
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
                Intent intent = new Intent(Calcu_sci.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bt_mi.setOnClickListener(listener);
        bt_sin.setOnClickListener(listener);
        bt_cos.setOnClickListener(listener);
        bt_tan.setOnClickListener(listener);
        bt_log.setOnClickListener(listener);
        bt_lifang.setOnClickListener(listener);
        bt_kaifang.setOnClickListener(listener);
        bt_sinf.setOnClickListener(listener);
        bt_cosf.setOnClickListener(listener);
        bt_tanf.setOnClickListener(listener);
        bt_em.setOnClickListener(listener);
        bt_ln.setOnClickListener(listener);
        bt_pie.setOnClickListener(listener);
        bt_jiecheng.setOnClickListener(listener);
        bt_kuohaol.setOnClickListener(listener);
        bt_kuohaor.setOnClickListener(listener);
    }
    //计算结果
    private void clickEqual() {
            boolean fl = true;
            if(!s.isEmpty())
                n2 = Double.parseDouble(s);
            if(opt.equals("+"))
                n1 += n2;
            else if(opt.equals("-"))
                n1 -= n2;
            else if(opt.equals("*"))
                n1 *= n2;
            else if(opt.equals("/")) {
                if(n2 != 0.0) {
                    n1 /= n2;
                }
                else {
                    fl = false;
                }
            }
        else if(opt.equals("^")||opt.equals("&"))
            n1 = Math.pow(n1, n2);
        else if(opt.equals("%"))
            n1 = n1 % n2;
        opt = "";
        if(fl)
            s = ""+n1;
        else
            s = "除数不能为0";
        editText.setText(s);
        s = "";
        str = "";
        textView.setText("");
    }
    //计算中缀表达式
    public static double stringToArithmetic(String string) {
        return suffixToArithmetic(infixToSuffix(string));
    }
    //将中缀表达式转化为后缀表达式
    public static String infixToSuffix(String exp) {
        Stack<Character> s = new Stack<Character>();
        String suffix = "";
        int length = exp.length();
        for (int i = 0; i < length; i++) {
            char temp;
            char ch = exp.charAt(i);
            switch (ch) {
                case ' ':
                break;
                case '(':
                    s.push(ch);
                    break;
                case '+':
                case '-':
                    while (s.size() != 0) {
                        temp = s.pop();
                        if (temp == '(') {
                            s.push('(');
                            break;
                        }
                        suffix += temp;
                    }
                    s.push(ch);
                    break;
                case '*':
                case '/':
                    while (s.size() != 0) {
                        temp = s.pop();
                        if (temp == '+' || temp == '-' || temp == '(') {
                            s.push(temp);
                            break;
                        } else {
                            suffix += temp;
                        }
                    }
                    s.push(ch);
                    break;
                case ')':
                    while (!s.isEmpty()) {
                        temp = s.pop();
                        if (temp == '(') {
                            break;
                        } else {
                             suffix += temp;
                        }
                    }
                    break;
                default:
                    suffix += ch;
                    break;
            }
        }
        while (s.size() != 0) {
            suffix += s.pop();
        }
        return suffix;
    }
    //计算后缀表达式
    public static double suffixToArithmetic(String exp) {
        Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)");
        String[] strings = exp.split("");
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("")) {
                continue;
            }
            if (pattern.matcher(strings[i]).matches()) {
                stack.push(Double.parseDouble(strings[i]));
            }
            else {
                double y = stack.pop();
                double x = stack.pop();
                stack.push(calculate(x, y, strings[i]));
            }
        }
        return stack.pop();
    }
    private static Double calculate(double x, double y, String string) {
        if (string.trim().equals("+")) {
            return x + y;
        }
        if (string.trim().equals("-")) {
            return x - y;
        }
        if (string.trim().equals("*")) {
            return x * y;
        }
        if (string.trim().equals("/")) {
            return x / y;
        }
        return (double) 0;
    }
}
