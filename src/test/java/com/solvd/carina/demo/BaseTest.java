package com.solvd.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class BaseTest implements IAbstractTest, IMobileUtils {

    public void helloWorld() {
        System.out.println("helloWorld");
    }
}
