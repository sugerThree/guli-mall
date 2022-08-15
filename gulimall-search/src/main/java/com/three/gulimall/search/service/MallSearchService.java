package com.three.gulimall.search.service;

import com.three.gulimall.search.vo.SearchParam;
import com.three.gulimall.search.vo.SearchResult;


/**
 * @author three
 * @date 2022-08-11 23:43
 */
public interface MallSearchService {

    /**
     * 根据param查询信息
     *
     * @param param 检索的所有参数
     * @return  返回检索的结果，里面包含页面需要的所有信息
     */
    SearchResult search(SearchParam param);
}
