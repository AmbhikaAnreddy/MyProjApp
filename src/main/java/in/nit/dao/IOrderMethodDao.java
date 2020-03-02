package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodDao {
	public Integer saveOrderMethod(OrderMethod ob);
    public List<OrderMethod> getAllOrderMethodTypes();
    public void deleteOrderMethod(Integer id);
    public OrderMethod getOneOrderMethod(Integer id);
    public void updateOrderMethod(OrderMethod ob);
}
