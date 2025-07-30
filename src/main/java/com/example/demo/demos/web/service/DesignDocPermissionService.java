package com.example.demo.demos.web.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.demos.web.entity.DesignDocPermission;
import com.example.demo.demos.web.repository.DesignDocPermissionRepository;

@Service
public class DesignDocPermissionService {

	@Resource
	DesignDocPermissionRepository designDocPermissionRepository;

	@Transactional
	public void saveDesignDocPermission(String userId) {

		Optional<DesignDocPermission> designDocPermissionOptional = designDocPermissionRepository.findById(userId);

		if (designDocPermissionOptional.isPresent()) {
			designDocPermissionRepository.delete(designDocPermissionOptional.get());
		}

		DesignDocPermission designDocPermission = new DesignDocPermission();

		if ("X0071920".equals(userId)) {
			designDocPermission.setUsrId(userId);
			designDocPermission.setGymCd1("SHIBUSAWA");
			designDocPermission.setPermissionFlg1("1");
			designDocPermission.setGymCd2("MINAMIKOBIKI");
			designDocPermission.setPermissionFlg2("0");
		} else {
			designDocPermission.setUsrId(userId);
			designDocPermission.setGymCd1("SHIBUSAWA");
			designDocPermission.setPermissionFlg1("0");
			designDocPermission.setGymCd2("MINAMIKOBIKI");
			designDocPermission.setPermissionFlg2("1");
		}
		designDocPermissionRepository.save(designDocPermission);

		return;

	}

}
