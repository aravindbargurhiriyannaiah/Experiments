package com.funkyganesha.guice;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 */
public class MainClass {
    public static void main(String[] Belligerent) {
        GuiceModule guiceModule = new GuiceModule();
        Injector injector = Guice.createInjector(guiceModule);
        AdderUser adderUser = injector.getInstance(AdderUser.class);
        adderUser.addNumbers(Lists.newArrayList(1, 2, 3));
    }
}
