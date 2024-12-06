package com.example.technicstore.DTO.Response;

import java.util.List;

public class OrderStatisticsDTO {

    private Double revenue;
    private Long newOrders;
    private Long canceledOrders;
    private Long returnedOrders;

    private List<Object[]> revenueLast7Days;
    private List<Object[]> topSellingProductsToday;
    private List<Object[]> topSellingCategoriesToday;

    public OrderStatisticsDTO(Double revenue, Long newOrders, Long canceledOrders, Long returnedOrders, List<Object[]> revenueLast7Days,
                              List<Object[]> topSellingProductsToday,
                              List<Object[]> topSellingCategoriesToday) {
        this.revenue = revenue;
        this.newOrders = newOrders;
        this.canceledOrders = canceledOrders;
        this.returnedOrders = returnedOrders;
        this.revenueLast7Days = revenueLast7Days;
        this.topSellingProductsToday = topSellingProductsToday;
        this.topSellingCategoriesToday = topSellingCategoriesToday;
    }

    // Getters and setters
    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Long getNewOrders() {
        return newOrders;
    }

    public void setNewOrders(Long newOrders) {
        this.newOrders = newOrders;
    }

    public Long getCanceledOrders() {
        return canceledOrders;
    }

    public void setCanceledOrders(Long canceledOrders) {
        this.canceledOrders = canceledOrders;
    }

    public Long getReturnedOrders() {
        return returnedOrders;
    }

    public void setReturnedOrders(Long returnedOrders) {
        this.returnedOrders = returnedOrders;
    }

    public List<Object[]> getRevenueLast7Days() {
        return revenueLast7Days;
    }

    public void setRevenueLast7Days(List<Object[]> revenueLast7Days) {
        this.revenueLast7Days = revenueLast7Days;
    }

    public List<Object[]> getTopSellingProductsToday() {
        return topSellingProductsToday;
    }

    public void setTopSellingProductsToday(List<Object[]> topSellingProductsToday) {
        this.topSellingProductsToday = topSellingProductsToday;
    }

    public List<Object[]> getTopSellingCategoriesToday() {
        return topSellingCategoriesToday;
    }

    public void setTopSellingCategoriesToday(List<Object[]> topSellingCategoriesToday) {
        this.topSellingCategoriesToday = topSellingCategoriesToday;
    }

}
