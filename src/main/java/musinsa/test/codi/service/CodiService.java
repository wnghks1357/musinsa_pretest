package musinsa.test.codi.service;

import musinsa.test.codi.repository.CodiRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CodiService {

	private final CodiRepository codiRepository;

}