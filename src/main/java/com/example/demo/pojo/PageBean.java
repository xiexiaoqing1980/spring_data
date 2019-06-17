package com.example.demo.pojo;

public class PageBean {
    private int currPage; //当前页数
    private int pageSize; //每页显示记录数
    private int totalCount; //总记录数
    private int totalPage; //总页数,需要计算
    private int previous;
    private int next;

    public PageBean(int currPage, int pageSize, int totalCount) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage=(totalCount % pageSize) == 0 ? totalCount / pageSize: totalCount / pageSize + 1;
        if (currPage <= 0)
        {
            currPage = 1;
        }
        if (currPage >= totalPage + 1)
        {
            currPage = totalPage;
        }
        this.currPage = currPage;
        this.previous=this.currPage-1;
        if (previous<=0){
            previous =1;
        }
        this.next=this.currPage+1;
        if (this.next>this.totalPage){
            this.next=totalPage;
        }
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }



   /*public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }*/
}
