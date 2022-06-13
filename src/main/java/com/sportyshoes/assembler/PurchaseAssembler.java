package com.sportyshoes.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportyshoes.DTO.PurchaseReport;
import com.sportyshoes.model.PurchaseReportModel;
import org.springframework.stereotype.Service;

@Service
public class PurchaseAssembler {

    public PurchaseReportModel dtoToModel(PurchaseReport purchaseReport){
        if(purchaseReport == null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(purchaseReport, PurchaseReportModel.class);
    }

    public PurchaseReport modelToDTO(PurchaseReportModel purchaseReportModel){
        if(purchaseReportModel == null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(purchaseReportModel, PurchaseReport.class);
    }
}
