package com.example.technicstore.service;

import com.example.technicstore.DTO.Request.ImeiRequest;
import com.example.technicstore.Mapper.ImeiMapper;
import com.example.technicstore.entity.Brand;
import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.StockReceiveDetail;
import com.example.technicstore.repository.ImeiRepository;
import com.example.technicstore.repository.StockReceiveDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImeiService {

    @Autowired
    private ImeiRepository imeiRepository;

    @Autowired
    StockReceiveDetailRepository stockReceiveDetailRepository;

    // Lấy tất cả IMEI
    public List<Imei> getAllImeis() {
        return imeiRepository.findAll();
    }

    // Lấy IMEI theo ID
    public Optional<Imei> getImeiById(Long id) {
        return imeiRepository.findById(id);
    }

    // Lấy tất cả imei theo chi tiết phiếu nhập
    public List<Imei> getImeisByStockReceiveDetailId(Long stockReceiveDetailId) {
        return imeiRepository.findImeiByStockReceiveDetail_Id(stockReceiveDetailId);
    }

    public List<Imei> searchImeis(String query) {
        return imeiRepository.searchByImeiCodeOrVariantName(query);
    }

    // Lấy IMEI theo mã IMEI
    public Optional<Imei> getImeiByImeiCode(String imeiCode) {
        return imeiRepository.findImeiByImeiCode(imeiCode);
    }

    // Tạo mới IMEI
    public Imei createImei(ImeiRequest imeiRequest) {
        Imei newImei = ImeiMapper.toEntity(imeiRequest);
        StockReceiveDetail stockReceiveDetail = stockReceiveDetailRepository.findStockReceiveDetailById(imeiRequest.getReceiveDetailId()).orElseThrow(() -> new RuntimeException("StockReceiveDetail not found"));
        newImei.setStockReceiveDetail(stockReceiveDetail);
        return imeiRepository.save(newImei);
    }

    // Cập nhật IMEI
    public Imei updateImei(Long id, Imei updatedImei) {
        Optional<Imei> imeiOptional = imeiRepository.findById(id);
        if (imeiOptional.isPresent()) {
            Imei existingImei = imeiOptional.get();
            existingImei.setImeiCode(updatedImei.getImeiCode());
            existingImei.setStockReceiveDetail(updatedImei.getStockReceiveDetail());
            return imeiRepository.save(existingImei);
        }
        return null;
    }

    // Xóa IMEI
    public void deleteImei(Long id) {
        imeiRepository.deleteById(id);
    }
}
