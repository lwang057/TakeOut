package com.lwang.takeout.model.module;

import dagger.Module;

/**
 * ApiModule.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

@Module(includes = {AppModule.class, ClientModule.class})
public class ApiModule {


}
