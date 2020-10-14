package com.banco.banco.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.banco.persistence.entity.Rol;
import com.banco.banco.persistence.repository.RolDao;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDao rolDao;

	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		return rolDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Rol findById(Integer id) {
		return rolDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Rol save(Rol rol) {
		return rolDao.save(rol);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		rolDao.deleteById(id);
	}
}
