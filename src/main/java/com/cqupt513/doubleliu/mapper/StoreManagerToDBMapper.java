package com.cqupt513.doubleliu.mapper;

import com.cqupt513.doubleliu.pojo.Addr;
import com.cqupt513.doubleliu.pojo.Manager;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreManagerToDBMapper {
    @Insert("insert into manager(name,phoneNumber,hash,email,fname,date) values(#{name},#{phoneNumber},#{hash},#{email},#{fname},#{date})")
    Integer store(Manager manager);
    @Select("select * from manager")
    List<Manager> listManagers();
    @Select("select count(1) from manager Where name=#{name} and phoneNumber=#{phoneNumber} and hash=#{hash} and email=#{email} and fname=#{fname}")
    Integer find(Manager manager);
    @Insert("insert into addr(address,idx,encode,mid) values(#{address},#{idx},#{encode},#{mid})")
    Integer insert(Addr addr);
    @Select("select id,hash,count from manager where hash=#{hash}")
    Manager selectCount(Manager manager);
    @Update("update manager set count=#{count} where hash=#{hash}")
    Integer updateCount(Manager manager);
    @Delete("delete from manager where id=#{id}")
    Integer delete(Integer id);
    @Delete("delete from addr where mid=#{mid}")
    Integer deleteaddr(Integer mid);

}
