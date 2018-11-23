package com.winnie.utils.utils;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.winnie.utils.utils.model.TestBean;
import com.winnie.utils.utils.model.TestBeanResponse;
import com.winnie.utils.utils.model.TestJsonModel;

import java.util.List;

/**
 * @author : winnie
 * @date : 2018/11/23
 * @desc
 */
public class JsonUitls {
    /**
     * json解析对象
     */
    public static TestJsonModel convertJson(){
        TestJsonModel testJsonModel = JSONObject.parseObject(TestJsonModel.jsonStr, TestJsonModel.class);
        Log.d("TAG", testJsonModel.getCapturedImageUri());
        return testJsonModel;
    }

    /**
     * json解析列表
     */
    public static List<TestBean> convertJsonList(){
        List<TestBean> testBeans = JSONObject.parseArray(TestBean.jsonStr, TestBean.class);
        for (TestBean x: testBeans) {
            List<TestBean.DataBean> dataBean = x.getData();
            for(TestBean.DataBean y:dataBean){
                Log.d("TAG", y.toString());
            }
            TestBean.PagingBean pagingBean = x.getPaging();
            Log.d("TAG", x.toString());
        }
        return testBeans;
    }

    /**
     *  json解析列表
     */
    public static<T> List<T> convertJsonListWithStirng(String json){
        List<T> testBeans = JSONObject.parseObject(json, new TypeReference<List<T>>(){});
        return testBeans;
    }

    /**
     *  Gson解析列表
     */
    public static <T> List<T> convertGsonList(String json){
        List<T> testBeans = new Gson().fromJson(json, new TypeToken<List<T>>(){}.getType());
        return testBeans;
    }

    /**
     * json解析对象能够自己处理 my_name到myName的转换
     */
    public static TestBeanResponse convertJsonTest(){
        TestBeanResponse testBeanResponse = JSONObject.parseObject(TestBeanResponse.jsonStr, TestBeanResponse.class);
        Log.d("TAG", testBeanResponse.toString());
        return testBeanResponse;
    }

    /**
     * gson使用 @SerializedName("my_name") public String name; 将my_name对应的值映射到name字段
     */
    public static TestBeanResponse convertGsonTest(){
        TestBeanResponse testBeanResponse = new Gson().fromJson(TestBeanResponse.jsonStr, TestBeanResponse.class);
        Log.d("TAG", testBeanResponse.toString());
        return testBeanResponse;
    }
}