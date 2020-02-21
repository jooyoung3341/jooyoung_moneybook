package kr.co.moneybook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.moneybook.mapper.BoardMapper;
import kr.co.moneybook.service.BoardService;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
}
