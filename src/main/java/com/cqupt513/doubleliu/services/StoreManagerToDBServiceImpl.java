package com.cqupt513.doubleliu.services;

import com.cqupt513.doubleliu.mapper.StoreManagerToDBMapper;
import com.cqupt513.doubleliu.pojo.Addr;
import com.cqupt513.doubleliu.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreManagerToDBServiceImpl implements StoreManagerToDBService {
    @Autowired(required = false)
    StoreManagerToDBMapper storeManagerToDBMapper;
    @Override
    @Transactional
    public Integer store(Manager manager) {
        return storeManagerToDBMapper.store(manager);
    }

    @Override
    public List<Manager> listManagers() {
        return storeManagerToDBMapper.listManagers();
    }

    @Override
    public Integer find(Manager manager) {
        return storeManagerToDBMapper.find(manager);
    }
    @Transactional
    @Override
    public Integer insert(Addr addr) {
        return storeManagerToDBMapper.insert(addr);
    }

    @Override
    public Manager selectCount(Manager manager) {
        return storeManagerToDBMapper.selectCount(manager);
    }
    @Transactional
    @Override
    public Integer updateCount(Manager manager) {
        return storeManagerToDBMapper.updateCount(manager);
    }

    @Override
    @Transactional
    public Integer delete(Integer id) {
        storeManagerToDBMapper.deleteaddr(id);
        storeManagerToDBMapper.delete(id);
        return 1;
    }
}
