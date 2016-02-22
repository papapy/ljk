package club.ljk.comm.model.base;

import club.ljk.comm.util.Page;

import java.io.Serializable;

/**
 * 基础model
 * Created by XKey on 2015/11/19.
 */
public class BaseModel {

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
