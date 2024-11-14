package com.example.technicstore.controller;

import com.example.technicstore.service.VNPAYService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private VNPAYService vnPayService;


    @PostMapping("/submitOrder")
    public Map<String, String> submitOrder(@RequestParam("amount") long orderTotal,
                                           @RequestParam("orderInfo") String orderInfo,
                                           HttpServletRequest request) {
        String vnpayUrl = vnPayService.createOrder(request, orderTotal, orderInfo);

        Map<String, String> response = new HashMap<>();
        response.put("paymentUrl", vnpayUrl);
        return response;
    }

    @GetMapping("/vnpay-payment-return")
    public ResponseEntity<Map<String, Object>> paymentCompleted(HttpServletRequest request) {
        // Xử lý phản hồi từ VNPay
        int paymentStatus = vnPayService.orderReturn(request);

        // Tạo phản hồi JSON chứa thông tin giao dịch
        Map<String, Object> response = new HashMap<>();
        response.put("status", paymentStatus == 1 ? "success" : "fail");
        response.put("orderId", request.getParameter("vnp_OrderInfo"));
        response.put("totalPrice", request.getParameter("vnp_Amount"));
        response.put("paymentTime", request.getParameter("vnp_PayDate"));
        response.put("transactionId", request.getParameter("vnp_TransactionNo"));

        // Trả về phản hồi JSON cho frontend
        return ResponseEntity.ok(response);
    }
}
