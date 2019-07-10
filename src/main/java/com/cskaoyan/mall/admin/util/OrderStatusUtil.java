package com.cskaoyan.mall.admin.util;

import com.cskaoyan.mall.admin.bean.HandleOption;

/**
 * author lixiaolong
 * date: 2019-07-09 18:15
 * description:
 */
public class OrderStatusUtil {
    public static String toOrderStatusText(int orderStatus) {
        String orderStatusText = "";
        switch (orderStatus) {
            case 101:
                orderStatusText = "代付款";
                break;
            case 102:
                orderStatusText = "已取消";
                break;
            case 103:
                orderStatusText = "已取消(系统)";
                break;
            case 201:
                orderStatusText = "代发货";
                break;
            case 202:
                orderStatusText = "订单生成，已付款未发货，但是退款取消";
                break;
            case 301:
                orderStatusText = "商家发货，用户未确认";
                break;
            case 401:
                orderStatusText = "用户确认收货";
                break;
            case 402:
                orderStatusText = "系统自动确认收货";
                break;
        }
        return orderStatusText;
    }

    public static HandleOption getHandleOption(int orderstatus, HandleOption handleOption) {
        if (orderstatus == 101) {
            handleOption.setCancel(true);
            handleOption.setPay(true);
        }
        if (orderstatus == 103) {
            handleOption.setDelete(true);
        }
        if (orderstatus == 401 || orderstatus == 402) {
            handleOption.setConfirm(true);

        }
        return handleOption;
    }
}
