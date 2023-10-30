package com.deean.utils;

import java.util.List;

/**
 * Author: Deean
 * Date: 2023-10-30 22:47
 * FileName: src/main/java/com/deean/utils
 * Description:
 */

public class PageUtil<T> {
    public List<T> list;
    public int pageCurrent;
    public int pageCount;

    public PageUtil() {
    }

    public PageUtil(List<T> list, int pageCurrent, int pageCount) {
        this.list = list;
        this.pageCurrent = pageCurrent;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "list=" + list +
                ", pageCurrent=" + pageCurrent +
                ", pageCount=" + pageCount +
                '}';
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
