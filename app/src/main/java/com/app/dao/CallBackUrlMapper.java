package com.app.dao;

import com.app.model.OrderTable;
import org.apache.ibatis.annotations.Param;

/***
 * @author 丿郑不乖
 */
public interface CallBackUrlMapper {

    void updateByOrderNo(OrderTable orderTable);

    OrderTable saveByOrderNo(String orderNo);

    void updateSch_state(OrderTable orderTable);
}
