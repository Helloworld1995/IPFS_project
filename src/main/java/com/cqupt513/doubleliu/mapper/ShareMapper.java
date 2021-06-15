package com.cqupt513.doubleliu.mapper;

import com.cqupt513.doubleliu.pojo.Addr;
import com.cqupt513.doubleliu.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShareMapper {
    @Select("select address from Addr")
    List<Addr> listAddr();
    @Select("select idx,encode from Addr where address=#{address}")
    Addr findAddr(Addr addr);
    @Select("select fname from manager where hash=#{hash}")
    String findFileName(Manager manager);
}
