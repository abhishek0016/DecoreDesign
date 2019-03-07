package com.ecomm.dao;

import com.ecomm.model.OrderDetail;

public interface OrderDetailDAO {

	public boolean insertOrderDetail(OrderDetail orderDetail);
	public boolean updateOrderDetail(String userName);
}
