package com.sun.tracy.userlistcase.entity;

import java.util.List;

public class PageMsg<T> {
    private int totalCount;
    private int currentPage;
    private int rows;
    private int totalPage;
    private List<T> msgs;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<T> msgs) {
        this.msgs = msgs;
    }

    @Override
    public String toString() {
        return "PageMsg{" +
                "totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                ", totalPage=" + totalPage +
                ", msgs=" + msgs +
                '}';
    }
}
