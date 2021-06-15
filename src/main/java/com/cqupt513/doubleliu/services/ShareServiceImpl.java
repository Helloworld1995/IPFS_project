package com.cqupt513.doubleliu.services;

import com.cqupt513.doubleliu.mapper.ShareMapper;
import com.cqupt513.doubleliu.pojo.Addr;
import com.cqupt513.doubleliu.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShareServiceImpl implements ShareService {
    @Autowired(required = false)
    ShareMapper shareMapper;
    @Override
    public List<Addr> listAddr() {
        return shareMapper.listAddr();
    }

    @Override
    public Addr findAddr(Addr addr) {
        return shareMapper.findAddr(addr);
    }

    @Override
    public String findFileName(Manager manager) {
        return shareMapper.findFileName(manager);
    }
}
