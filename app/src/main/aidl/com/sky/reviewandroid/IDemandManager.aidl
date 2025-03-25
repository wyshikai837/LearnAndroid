// IDemandManager.aidl
package com.sky.reviewandroid;

// Declare any non-default types here with import statements
import com.sky.reviewandroid.MessageBean;

interface IDemandManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    MessageBean getDemand();

    void setDemandIn(in MessageBean msg);//客户端->服务端

    //out和inout都需要重写MessageBean的readFromParcel方法
    void setDemandOut(out MessageBean msg);//服务端->客户端

    void setDemandInOut(inout MessageBean msg);//客户端<->服务端
}