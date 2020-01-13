package com.dhanjyothi.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.FileDao;
import com.dhanjyothi.database.CustomHibernateDaoSupport;
import com.dhanjyothi.model.FileEntity;

@Repository
@Transactional
@SuppressWarnings({ "unchecked", "deprecation" })
public class FileDaoImpl extends CustomHibernateDaoSupport implements FileDao {

	@Override
	public void saveFileUpload(FileEntity fileEntity) {
		save(fileEntity);
	}

	@Override
	public List<FileEntity> viewAllFiles() {
		return getCurrentSession().createCriteria(FileEntity.class).list();
	}

	@Override
	public List<FileEntity> findByName(String fileName) {
		return getCurrentSession().createCriteria(FileEntity.class).add(Restrictions.eq("fileName", fileName)).list();
	}

}
