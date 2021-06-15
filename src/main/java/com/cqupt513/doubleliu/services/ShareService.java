package com.cqupt513.doubleliu.services;

import com.cqupt513.doubleliu.pojo.Addr;
import com.cqupt513.doubleliu.pojo.Manager;

import java.util.List;

public interface ShareService {
    List<Addr> listAddr();
    Addr findAddr(Addr addr);
    String findFileName(Manager manager);
}
