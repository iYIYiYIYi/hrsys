package com.yihuang.hrsys.entities.enums;

/**
 * com.yihuang.hrsys.entities.enums
 *
 * @author yihuang728
 * @create 2020/5/12
 */
public enum PoliticState {

    /***
     * Politic State
     */
    Mass("群众"),
    LeagueMember("团员"),
    Comrade("党员"),
    ProbPartyMember("预备党员"),
    Activist("入党积极分子");
    ;

    public String name;
    PoliticState(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return name;
    }

}
