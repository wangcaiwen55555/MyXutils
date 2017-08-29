package com.bwie.myxutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {



    String url="http://v.juhe.cn/toutiao/index?key=c1885686ef47f19bcb45e39c4447e040";

    String postUrl="http://v.juhe.cn/toutiao/index";

        @ViewInject(R.id.tv_msg)
        TextView mMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        x.view().inject(this);

        //getRequest();
        postRequest();
    }

    /**
     * post请求
     */
    private void postRequest() {
    RequestParams params=new RequestParams(url);

       // params.addBodyParameter("key","c1885686ef47f19bcb45e39c4447e040");

        x.http().post(params, new Callback.CommonCallback<String>() {
           String result=null;
            @Override
            public void onSuccess(String result) {
                this.result=result;

                System.out.println("result===="+result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                System.out.println("======"+result);
            }
        });

    }

    /**
     * get请求
     */
    private void getRequest() {
        RequestParams params=new RequestParams(url);

        x.http().get(params, new Callback.CacheCallback<String>() {
            private  boolean HashError=false;
            private String result=null;
            @Override
            public void onSuccess(String result) {
               /* if(result!=null){
                   this.result=result;
                }*/

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                HashError=true;
                Toast.makeText(x.app(),ex.getMessage(), Toast.LENGTH_SHORT).show();




            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                Toast.makeText(x.app(), result, Toast.LENGTH_SHORT).show();
                System.out.println("======="+result);
            }

            @Override
            public boolean onCache(String result) {
               this.result=result;
                return true;
            }
        });









    }


}
