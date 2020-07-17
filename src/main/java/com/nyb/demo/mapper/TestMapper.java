package com.nyb.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 15:33 2020/5/25
 * @Modified By:
 */
@Mapper
public interface TestMapper {

    List<Map> getOne();

}
