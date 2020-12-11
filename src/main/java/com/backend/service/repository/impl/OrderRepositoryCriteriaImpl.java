package com.backend.service.repository.impl;

import com.backend.service.model.OrderCriteriaModel;
import com.backend.service.model.OrderModel;
import com.backend.service.repository.OrderRepositoryCriteria;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Log4j2
public class OrderRepositoryCriteriaImpl implements OrderRepositoryCriteria {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OrderModel> findByCriteria(OrderCriteriaModel orderCriteriaModel) throws ParseException {
        List<OrderModel> list = null;
        try {
            list = entityManager.createQuery(getCriteriaQuery(orderCriteriaModel)).getResultList();
        } catch (Exception exception) {
            throw exception;
        }
        return list;
    }

    private CriteriaQuery<OrderModel> getCriteriaQuery(OrderCriteriaModel orderCriteriaModel) throws ParseException {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderModel> criteriaQuery = builder.createQuery(OrderModel.class);
        Root<OrderModel> model = criteriaQuery.from(OrderModel.class);
        criteriaQuery.select(model);
        List<Predicate> predicates = getWhereClause(orderCriteriaModel, builder, model);
        criteriaQuery.select(model).where(predicates.toArray(new Predicate[] {}));
        return criteriaQuery;
    }

    private List<Predicate> getWhereClause(OrderCriteriaModel orderCriteriaModel, CriteriaBuilder builder, Root<OrderModel> model) {
        List<Predicate> query = new ArrayList<>();
        if (!StringUtils.isEmpty(orderCriteriaModel.getOrderId())) {
            query.add(builder.equal(model.get("orderId"), orderCriteriaModel.getOrderId()));
        }
        if (!StringUtils.isEmpty(orderCriteriaModel.getDate())) {
            query.add(builder.equal(model.get("date"), orderCriteriaModel.getDate()));
        }
        if (!StringUtils.isEmpty(orderCriteriaModel.getDescription())) {
            query.add(builder.equal(model.get("description"), orderCriteriaModel.getDescription()));
        }
        if (!StringUtils.isEmpty(orderCriteriaModel.getItems())) {
            query.add(builder.equal(model.get("items"), orderCriteriaModel.getItems()));
        }
        if (!StringUtils.isEmpty(orderCriteriaModel.getNumber())) {
            query.add(builder.equal(model.get("number"), orderCriteriaModel.getNumber()));
        }
        return query;
    }
}
