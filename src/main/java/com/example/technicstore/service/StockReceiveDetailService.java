package com.example.technicstore.service;

import com.example.technicstore.DTO.Request.StockReceiveDetailRequest;
import com.example.technicstore.DTO.Response.ImeiResponse;
import com.example.technicstore.DTO.Response.StockReciveDetailResponse;
import com.example.technicstore.Mapper.ImeiMapper;
import com.example.technicstore.Mapper.StockReceiveDetailMapper;
import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.StockReceive;
import com.example.technicstore.entity.StockReceiveDetail;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.repository.StockReceiveDetailRepository;
import com.example.technicstore.repository.StockReceiveRepository;
import com.example.technicstore.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockReceiveDetailService {

    @Autowired
    private StockReceiveDetailRepository stockReceiveDetailRepository;
    @Autowired
    private StockReceiveRepository stockReceiveRepository;

    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private ImeiService imeiService;

    // lấy tất cả chi tiết phiếu nhập theo id phiếu nhập
    public List<StockReciveDetailResponse> getStockReceiveDetailsByStockReceiveId(Long stockReceiveId) {
          List<StockReceiveDetail>StockReceiveDetails = stockReceiveDetailRepository.findStockReceiveDetailsByStockReceive_Id(stockReceiveId);
          List<StockReciveDetailResponse> stockReciveDetailResponses = new ArrayList<>();
          for(StockReceiveDetail stockReceiveDetail : StockReceiveDetails){
              StockReciveDetailResponse stockReciveDetailResponse = StockReceiveDetailMapper.toDTO(stockReceiveDetail);
              List<Imei> imeis = imeiService.getImeisByStockReceiveDetailId(stockReceiveDetail.getId());
                List<ImeiResponse> imeiResponses = new ArrayList<>();
                for(Imei imei : imeis){
                   ImeiResponse imeiResponse = ImeiMapper.toDTO(imei);

                }


          }
          return stockReciveDetailResponses;
    }

    // Tạo chi tiết phiếu nhập
    public StockReceiveDetail createStockReceiveDetail(StockReceiveDetailRequest stockReceiveDetailRequest) {
        System.out.println("stockReceiveDetailRequest"+stockReceiveDetailRequest.getStockReceiveId());
        System.out.println("stockReceiveDetailRequest"+stockReceiveDetailRequest.getVariantId());
        StockReceiveDetail stockReceiveDetail = StockReceiveDetailMapper.toEntity(stockReceiveDetailRequest);
        StockReceive stockReceive = stockReceiveRepository.findById(stockReceiveDetailRequest.getStockReceiveId()).orElseThrow(() -> new RuntimeException("StockReceive not found"));
        Variant variant = variantRepository.findById(stockReceiveDetailRequest.getVariantId()).orElseThrow(() -> new RuntimeException("Variant not found"));
        stockReceiveDetail.setStockReceive(stockReceive);
        stockReceiveDetail.setVariant(variant);
        return stockReceiveDetailRepository.save(stockReceiveDetail);
    }
}
