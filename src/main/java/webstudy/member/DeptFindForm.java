package webstudy.member;

import webstudy.util.MapUtil;

import java.util.Map;

/**
 * Created by tie304275 on 2018/03/02.
 */
public class DeptFindForm {

    private String deptId;

    DeptFindForm(){
    }

    DeptFindForm(Map<String,String[]> params){
        deptId = MapUtil.getFirst(params,"deptId");
    }

    Integer getDeptId(String deptId){
        return Integer.parseInt(deptId);
    }

    void setDeptId(String deptId){
        this.deptId = deptId;
    }
}
