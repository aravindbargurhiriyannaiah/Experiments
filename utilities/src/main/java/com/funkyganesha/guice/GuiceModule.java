package com.funkyganesha.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

public class GuiceModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(Adder.class).to(SmartAdder.class);
    }
}
