//package com.example.technicstore.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/payment")
//public class PaymentController {
//
//    @Value("${vnpay.tmnCode}")
//    private String vnpTmnCode;
//
//    @Value("${vnpay.hashSecret}")
//    private String vnpHashSecret;
//
//    @Value("${vnpay.paymentUrl}")
//    private String vnpPaymentUrl;
//
//    @Value("${vnpay.returnUrl}")
//    private String vnpReturnUrl;
//
//    @PostMapping("/create_payment_url")
//    public Map<String, String> createPaymentUrl(@RequestParam double amount, HttpServletRequest request) throws Exception {
//        String vnpVersion = "2.1.0";
//        String vnpCommand = "pay";
//        String orderInfo = "Thanh toan don hang";
//        String orderType = "other";
//        String locale = "vn";
//        String currCode = "VND";
//        String ipAddr = request.getRemoteAddr();
//
//        String createDate = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        String txnRef = String.valueOf(System.currentTimeMillis());
//
//        Map<String, String> vnpParams = new HashMap<>();
//        vnpParams.put("vnp_Version", vnpVersion);
//        vnpParams.put("vnp_Command", vnpCommand);
//        vnpParams.put("vnp_TmnCode", vnpTmnCode);
//        vnpParams.put("vnp_Amount", String.valueOf((long) (amount * 100))); // Nhân với 100 để chuyển đổi thành đơn vị đồng
//        vnpParams.put("vnp_CurrCode", currCode);
//        vnpParams.put("vnp_TxnRef", txnRef);
//        vnpParams.put("vnp_OrderInfo", orderInfo);
//        vnpParams.put("vnp_OrderType", orderType);
//        vnpParams.put("vnp_Locale", locale);
//        vnpParams.put("vnp_ReturnUrl", vnpReturnUrl);
//        vnpParams.put("vnp_IpAddr", ipAddr);
//        vnpParams.put("vnp_CreateDate", createDate);
//
//        // Sắp xếp các tham số theo thứ tự bảng chữ cái
//        List<String> fieldNames = new ArrayList<>(vnpParams.keySet());
//        Collections.sort(fieldNames);
//        StringBuilder hashData = new StringBuilder();
//        StringBuilder query = new StringBuilder();
//        for (String fieldName : fieldNames) {
//            String value = vnpParams.get(fieldName);
//            if ((value != null) && (value.length() > 0)) {
//                // Build hashData and query
//                hashData.append(fieldName).append('=').append(URLEncoder.encode(value, StandardCharsets.UTF_8)).append('&');
//                query.append(fieldName).append('=').append(URLEncoder.encode(value, StandardCharsets.UTF_8)).append('&');
//            }
//        }
//        // Xóa dấu & cuối cùng
//        hashData.setLength(hashData.length() - 1);
//        query.setLength(query.length() - 1);
//
//        // Tạo chữ ký
//        String secureHash = hmacSHA512(vnpHashSecret, hashData.toString());
//        String paymentUrl = vnpPaymentUrl + "?" + query + "&vnp_SecureHash=" + secureHash;
//
//        Map<String, String> response = new HashMap<>();
//        response.put("paymentUrl", paymentUrl);
//        return response;
//    }
//
//    private String hmacSHA512(String key, String data) throws Exception {
//        byte[] hmacKey = key.getBytes(StandardCharsets.UTF_8);
//        javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA512");
//        javax.crypto.spec.SecretKeySpec secretKey = new javax.crypto.spec.SecretKeySpec(hmacKey, "HmacSHA512");
//        mac.init(secretKey);
//        byte[] hmacBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
//        StringBuilder hash = new StringBuilder();
//        for (byte b : hmacBytes) {
//            hash.append(String.format("%02x", b));
//        }
//        return hash.toString();
//    }
//
//    @GetMapping("/payment_return")
//    public String paymentReturn(HttpServletRequest request) {
//        Map<String, String[]> params = request.getParameterMap();
//        String secureHash = params.get("vnp_SecureHash")[0];
//
//        // Xử lý các tham số và kiểm tra chữ ký hợp lệ
//        // ... (Thêm mã xử lý logic kiểm tra tại đây)
//
//        return "Giao dịch thành công!";
//    }
//}
//
