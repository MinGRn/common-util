package com.mingrn.common.base.enums;

/**
 * 终端类型
 */
public enum TerminalTypeEnum {
    /**
     * web端,一般是指网页端
     */
    WEB("web"),
    /**
     * 微信端
     */
    WE_CHAT("weChat"),
    /**
     * 移动端,包括IOS端、安卓端
     */
    MOBILE("mobile"),
    /**
     * 应用间的授权
     */
    APP("application"),
    /**
     * 钉钉
     */
    DING_DING("dingding"),
    /**
     * 其他
     */
    OTHERS("others");

    TerminalTypeEnum(String alias) {
        this.alias = alias;
    }

    /**
     * 别名
     */
    private String alias;

    public String getAlias() {
        return alias;
    }

    public static TerminalTypeEnum getTerminalTypeEnum(String terminalType) {
        if (terminalType == null) {
            return null;
        }
        for (TerminalTypeEnum terminmalTypeEnum : TerminalTypeEnum.values()) {
            //1.匹配名称 2.或者匹配别名 3.大小写不敏感
            if (terminmalTypeEnum.toString().equalsIgnoreCase(terminalType) || terminmalTypeEnum.getAlias().equalsIgnoreCase(terminalType)) {
                return terminmalTypeEnum;
            }
        }
        return null;
    }
}
