package com.cqupt513.doubleliu.services;

import com.cqupt513.doubleliu.pojo.Addr;
import com.cqupt513.doubleliu.pojo.Manager;

import java.util.List;

public interface StoreManagerToDBService {
    Integer store(Manager manager);

    List<Manager> listManagers();

    Integer find(Manager manager);

    Integer insert(Addr addr);

    Manager selectCount(Manager manager);

    Integer updateCount(Manager manager);

    Integer delete(Integer id);

}
