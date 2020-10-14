package com.banco.banco.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.banco.persistence.entity.Banco;
import com.banco.banco.persistence.repository.BancoDao;

@Service
public class BancoServiceImpl implements BancoService {

	@Autowired
	private BancoDao bancoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Banco> findAll() {
		return bancoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Banco findById(Integer id) {
		return bancoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Banco save(Banco banco) {
		return bancoDao.save(banco);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		bancoDao.deleteById(id);
	}
}
