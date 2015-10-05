package wyz.android.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wangyuzhe on 10/3/15.
 */
public class Cityid {
    private String cnt;
    @SerializedName("list")
    private List<Model> list;

    public Cityid(String cnt, List<Model> list)
    {
        this.cnt = cnt;
        this.list = list;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public List<Model> getList() {
        return list;
    }

    public void setList(List<Model> list) {
        this.list = list;
    }
}
