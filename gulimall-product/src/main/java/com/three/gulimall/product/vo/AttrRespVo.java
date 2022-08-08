package com.three.gulimall.product.vo;

import lombok.Data;

/**
 * @author three
 * @date 2022-08-04 23:40
 */
@Data
public class AttrRespVo extends AttrVo{
    /**
     * 			"catelogName": "手机/数码/手机", //所属分类名字
     * 			"groupName": "主体", //所属分组名字
     */
    private String catelogName;
    private String groupName;

    private Long[] catelogPath;
}
