package com.example.longlongano.thinkinjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Collections;

import generict.Apple;
import generict.Fruit;
import generict.GenericArray;
import generict.GenericArray2;
import generict.GerericArrayWithTypeToken;
import generict.Holder;

public class GenericActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple apple = appleHolder.getValue();
        appleHolder.setValue(apple);

//        Holder<Fruit> fruitHolder = appleHolder;
                Holder<? extends Fruit> f = appleHolder;

        Fruit value = f.getValue();
        apple = (Apple) f.getValue();

        //f.setValue();




    }

    public void click(View view) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        gai.put(0, 1);
        //Integer[] rep = gai.rep(); //运行时类型是object
        Object[] objects = gai.rep();
//        Log.i("ll--", ""+rep[0]);
        Log.i("GenericArray", ""+objects[0]);

        GenericArray2<Integer> gai2 = new GenericArray2<>(10);
        gai2.put(0, 1);
//        Integer[] rep = gai2.rep();
        Log.i("GenericArray2", ""+gai2.get(0));

//传class的目的是，以便在擦除中恢复，使得我们可以创建需要的实际类型。
        GerericArrayWithTypeToken<Integer> withTypeToken = new GerericArrayWithTypeToken<Integer>(Integer.class, 10);
        withTypeToken.put(0, 1);
        Integer[] repo = withTypeToken.repo();
        Log.i("GerericArrayWith", ""+repo[0]);

    }
}
