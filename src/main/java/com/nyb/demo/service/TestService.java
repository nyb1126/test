package com.nyb.demo.service;

import com.nyb.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 15:39 2020/5/25
 * @Modified By:
 */
@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public List<Map> test(){
        return testMapper.getOne();
    }

}
