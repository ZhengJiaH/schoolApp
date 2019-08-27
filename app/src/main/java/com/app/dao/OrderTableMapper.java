package com.app.dao;

import com.app.model.OrderTable;

import java.util.List;

/***
 * @author 丿郑不乖
 * @date
 */
public interface OrderTableMapper {
    /**
     *
     * */
    void insertOrder(OrderTable orderTable);

    /**
     * 查询数据库中交过钱，但是状态为改变的数据
     * @return
     */
    List<OrderTable> queryState(Integer state);
}
