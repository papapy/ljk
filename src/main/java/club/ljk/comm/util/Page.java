package club.ljk.comm.util;

/**
 * Created by XKey on 2016/1/12.
 */
public class Page {
    private static  final Integer DEFAULT_PAGE_SIZE = 10;

    private Integer pageNo;
    private Integer pageSize;
    private Integer startIndex;
    private Integer totalRecord;
    private Integer totalPage;

    public Page() {
        this.pageNo = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public Page(Integer pageNo) {
        this.pageNo = pageNo;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
