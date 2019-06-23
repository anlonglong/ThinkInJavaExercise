package com.example.longlongano.thinkinjava;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Formatter;

import counter.LiteralPetCreator;
import counter.PerCount;
import counter.Pet;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intern();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().register(MainActivity.this);
            }
        }, 5000);
    }

    private void formatter() {
        // %[argument_index&][flags][width][.precision]conversion
        Formatter formatter = new Formatter();
        formatter.format("\n%s location is (%d, %d)\n", "point", 2, 4 );
        formatter.format("%-15s%5s\n", "Item", "QWE");
        formatter.format("%-15s %5s\n", "----", "---");
        formatter.format("%-3.4f%5d\n", 23.123456, 100);
        formatter.format("%b", true);
        Log.i(TAG, formatter.toString());

    }

    private void intern() {
        String s1 = "this is string ";
        String intern1 = s1.intern();
        String s2 = "this is string ";
        String intern2 = s2.intern();
        Log.i(TAG, "s1 hash code = " + s1.hashCode() + " inter1 hash code = " + intern1.hashCode());
        Log.i(TAG, "s2 hash code = " + s2.hashCode() + " inter2 hash code = " + intern2.hashCode());
    }

    public void click(View view) {
        //formatter();
        // formatter1();
        classTest();
//        AndroidViewModel model = ViewModelProvider.AndroidViewModelFactory
//                .getInstance(this.getApplication()).create(AndroidViewModel.class);
//        MutableLiveData mutableLiveData = new MutableLiveData();
//
//        mutableLiveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String o) {
//                System.out.println("o = [" + o + "]");
//            }
//        });
//
//        mutableLiveData.postValue("aaaaaaa");
        EventBus.getDefault().post("bbbbbbb");

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void method(String args) {

    }

    private void classTest() {
        Class intClass  = int.class;
        Class<Integer> integerClass = Integer.class;
        intClass = integerClass;
        intClass = double.class;

    }

    private void formatter1() {
        // %[argument_index&][flags][width][.precision]conversion
        Formatter formatter = new Formatter();
        char u = 'a';
        formatter.format("s : %s\n", u);
        formatter.format("c : %c\n", u);
        formatter.format("b : %b\n", u);
        formatter.format("Amount gained or lost since last statement: $ %(,.2f\n", 1234.5688888);
        Log.i(TAG, formatter.toString());
        Throwable throwable = new Throwable();
        PerCount perCount = new PerCount();
        LiteralPetCreator literalPetCreator = new LiteralPetCreator();
        Pet[] arrat = literalPetCreator.createArrat(20);
        for (Pet pet : arrat) {
            perCount.count(pet);
        }
        formatter.format("content = %s", perCount.toString());
        Log.i(TAG, formatter.toString());
    }
}
