package com.example.technicstore.service;

import com.example.technicstore.DTO.Request.StockReceiveRequest;
import com.example.technicstore.DTO.Response.ImeiResponse;
import com.example.technicstore.DTO.Response.StockReceiveResponse;
import com.example.technicstore.DTO.Response.StockReciveDetailResponse;
import com.example.technicstore.Mapper.ImeiMapper;
import com.example.technicstore.Mapper.StockReceiveDetailMapper;
import com.example.technicstore.Mapper.StockReceiveMappter;
import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.StockReceive;
import com.example.technicstore.entity.StockReceiveDetail;
import com.example.technicstore.entity.Supplier;
import com.example.technicstore.repository.StockReceiveRepository;
import com.example.technicstore.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockReceiveService {
    @Autowired
    private StockReceiveRepository stockReceiveRepository;
    @Autowired
    private StockReceiveDetailService stockReceiveDetailService;
    @Autowired ImeiService imeiService;

    @Autowired
    SupplierRepository supplierRepository;

    // lấy tất cả phiếu nhập
    public List<StockReceiveResponse> getAllStockReceives() {
        List<StockReceive> stockReceives = stockReceiveRepository.findAll();
        List<StockReceiveResponse> stockReceiveResponses = new ArrayList<>();
        for (StockReceive stockReceive : stockReceives) {
            StockReceiveResponse stockReceiveResponse = StockReceiveMappter.toDTO(stockReceive);
            stockReceiveResponses.add(stockReceiveResponse);
        }
        return stockReceiveResponses;
    }

    // lấy tất cả phiếu nhập theo id nhà cung cấp
    public List<StockReceiveResponse> getStockReceivesBySupplierId(Long supplierId) {
        List<StockReceive> stockReceives = stockReceiveRepository.findStockReceivesBySupplier_Id(supplierId);
        List<StockReceiveResponse> stockReceiveResponses = new ArrayList<>();
        for (StockReceive stockReceive : stockReceives) {
            StockReceiveResponse stockReceiveResponse = StockReceiveMappter.toDTO(stockReceive);
            stockReceiveResponses.add(stockReceiveResponse);
        }
        return stockReceiveResponses;
    }

    // lấy phiếu nhập gần đúng theo id gần đúng

    public List<StockReceiveResponse> getStockReceivesByIdContaining(Long id) {
        List<StockReceive> stockReceives = stockReceiveRepository.findStockReceivesByIdContaining(id.toString());
        List<StockReceiveResponse> stockReceiveResponses = new ArrayList<>();
        for (StockReceive stockReceive : stockReceives) {
            StockReceiveResponse stockReceiveResponse = StockReceiveMappter.toDTO(stockReceive);
            stockReceiveResponses.add(stockReceiveResponse);
        }
        return stockReceiveResponses;
    }

    // lấy phiếu nhập và thông tin chi tiết phiếu nhập theo id phiếu nhập
    public StockReceiveResponse getStockReceiveAndStockReceiveDetailById(Long id) {
        StockReceive stockReceive = stockReceiveRepository.findStockReceiveById(id);
        StockReceiveResponse stockReceiveResponse = StockReceiveMappter.toDTO(stockReceive);
        List<StockReceiveDetail> stockReceiveDetails = stockReceiveDetailService.getStockReceiveDetailsByStockReceiveId(stockReceive.getId());
        List<StockReciveDetailResponse> stockReceiveResponses = new ArrayList<>();
        for (StockReceiveDetail stockReceiveDetail : stockReceiveDetails) {
            StockReciveDetailResponse stockReceiveDetailResponse = StockReceiveDetailMapper.toDTO(stockReceiveDetail);
            List<Imei> imeis = imeiService.getImeisByStockReceiveDetailId(stockReceiveDetail.getId());
            List<ImeiResponse> imeiResponses = new ArrayList<>();
            for (Imei imei : imeis) {
                ImeiResponse imeiResponse = ImeiMapper.toDTO(imei);
                imeiResponses.add(imeiResponse);
            }
            stockReceiveDetailResponse.setImeiResponses(imeiResponses);
            stockReceiveResponses.add(stockReceiveDetailResponse);
        }
        stockReceiveResponse.setStockReciveDetailResponseList(stockReceiveResponses);
        return stockReceiveResponse;
    }

    // tạo phiết nhập
    public StockReceive createStockReceive(StockReceiveRequest stockReceiveRequest) {
        StockReceive stockReceive = StockReceiveMappter.toEntity(stockReceiveRequest);
        Supplier supplier = supplierRepository.findById(stockReceiveRequest.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
        stockReceive.setSupplier(supplier);
        return stockReceiveRepository.save(stockReceive);
    }
}
