package com.nyb.demo.upload;

import java.util.UUID;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 16:53 2020/9/16
 * @Modified By:
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
