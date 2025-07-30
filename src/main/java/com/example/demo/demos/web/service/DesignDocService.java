package com.example.demo.demos.web.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.demos.web.dto.SelectDesignDoc;
import com.example.demo.demos.web.entity.DesignDoc;
import com.example.demo.demos.web.entity.DesignDocPermission;
import com.example.demo.demos.web.repository.DesignDocRepository;
import com.example.demo.demos.web.repository.DesignDocPermissionRepository;

@Service
public class DesignDocService {

	@Resource
	DesignDocRepository designDocRepository;

	@Resource
	DesignDocPermissionRepository designDocPermissionRepository;

	@Transactional
	public SelectDesignDoc selectDesignDoc(String designDocId, String username) {

		SelectDesignDoc selectDesignDoc = new SelectDesignDoc();

		selectDesignDoc.setState("ERROR");

		DesignDoc designDoc = new DesignDoc();

		DesignDocPermission designDocPermission = new DesignDocPermission();

		Optional<DesignDocPermission> designDocPermissionOptional = designDocPermissionRepository.findById(username);

		Optional<DesignDoc> designDocOptional = designDocRepository.findById(designDocId);

		String permissionFlg1 = null;
		String permissionFlg2 = null;
		String constCompany = null;

		if (designDocPermissionOptional.isPresent() && designDocOptional.isPresent()) {
			designDocPermission = designDocPermissionOptional.get();
			designDoc = designDocOptional.get();
			permissionFlg1 = designDocPermission.getPermissionFlg1().toString();
			permissionFlg2 = designDocPermission.getPermissionFlg2().toString();

			constCompany = designDoc.getConstCompany().toString();

			if (("SHIBUSAWA".equals(constCompany) && "1".equals(permissionFlg1))
					|| ("MINAMIKOBIKI".equals(constCompany) && "1".equals(permissionFlg2))) {

				selectDesignDoc.setState("OK");
				selectDesignDoc.setDesignDocId(designDoc.getDesignDocId());
				selectDesignDoc.setConstCompany(designDoc.getConstCompany());
				selectDesignDoc.setDesignDocSts(designDoc.getDesignDocSts());
				selectDesignDoc.setAmountItem(designDoc.getAmountItem());

			}
		}

		return selectDesignDoc;

	}

}
