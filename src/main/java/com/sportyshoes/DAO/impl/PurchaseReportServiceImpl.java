package com.sportyshoes.DAO.impl;

import com.sportyshoes.DAO.PurchaseReportService;
import com.sportyshoes.DTO.Products;
import com.sportyshoes.DTO.PurchaseReport;
import com.sportyshoes.DTO.User;
import com.sportyshoes.assembler.PurchaseAssembler;
import com.sportyshoes.assembler.UserAssembler;
import com.sportyshoes.model.PurchaseReportModel;
import com.sportyshoes.model.UserModel;
import com.sportyshoes.repository.PurchaseReportRepository;
import com.sportyshoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PurchaseReportServiceImpl implements PurchaseReportService{

	@Autowired
	private PurchaseReportRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PurchaseAssembler assembler;

	@Autowired
	private UserAssembler userAssembler;

	@Override
	public PurchaseReport createPurchaseReport(PurchaseReport purchaseReport) {

//		UserModel userModel = userRepository.findByEmail(purchaseReport.getUserId().getEmail());
//		if(userModel !=null){
//			User user = userAssembler.modelToDTO(userModel);
//			purchaseReport.setUserId(user);
//		}

		PurchaseReportModel purchaseReportModel = assembler.dtoToModel(purchaseReport);
		return assembler.modelToDTO(repository.save(purchaseReportModel));
	}

	@Override
	public PurchaseReport updatePurchaseReport(PurchaseReport purchaseReport) {
		PurchaseReportModel purchaseReportModel = assembler.dtoToModel(purchaseReport);
		return assembler.modelToDTO(repository.save(purchaseReportModel));
	}

	@Override
	public PurchaseReport getPurchaseReportById(int id) {
		Optional<PurchaseReportModel> reportModel = repository.findById(id);
		return assembler.modelToDTO(reportModel.get());
	}

	@Override
	public void deletePurchaseReportById(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReports() {
		List<PurchaseReportModel> repositoryAll = repository.findAll();
		List<PurchaseReport> purchaseReports = repositoryAll.stream()
				.map(s -> assembler.modelToDTO(s))
				.collect(Collectors.toList());
		return purchaseReports;
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportCategory(String purchaseReportCategory) {
//		List<PurchaseReport> allPurchaseReports = getAllPurchaseReports();
//		return allPurchaseReports.stream()
//				.filter(s->s.getPurchaseReportCategory().equals(purchaseReportCategory))
//				.collect(Collectors.toList());
		List<PurchaseReportModel> purchaseReportModels = repository.findByPurchaseReportCategoryEqualsIgnoreCase(purchaseReportCategory);

		return purchaseReportModels.stream()
				.map(s->assembler.modelToDTO(s))
				.collect(Collectors.toList());
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportDate(String purchaseReportDate) {
//		List<PurchaseReport> allPurchaseReports = getAllPurchaseReports();
//		return allPurchaseReports.stream()
//				.filter(s->s.getPurchaseReportCategory().equals(purchaseReportDate))
//				.collect(Collectors.toList());

		List<PurchaseReportModel> purchaseReportModels = repository.findByPurchaseReportDateEquals(purchaseReportDate);

		return purchaseReportModels.stream()
				.map(s->assembler.modelToDTO(s))
				.collect(Collectors.toList());
	}

	@Override
	public List<PurchaseReport> findByUserId(Integer id) {
		//return repository.findByUserId();
		List<PurchaseReportModel> reportModels = repository.findByUserId_IdEquals(id);
		return reportModels.stream()
				.map(s->assembler.modelToDTO(s))
				.collect(Collectors.toList());
	}

	@Override
	public List<PurchaseReport> findByProductId(Integer id) {
		//return repository.findByProductId();
		List<PurchaseReportModel> reportModels = repository.findByProductid_ProductidEquals(id);
		return reportModels.stream()
				.map(s->assembler.modelToDTO(s))
				.collect(Collectors.toList());
	}



}
