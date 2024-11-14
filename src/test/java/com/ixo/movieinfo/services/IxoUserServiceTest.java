package com.ixo.movieinfo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ixo.movieinfo.dto.IxoUserDto;
import com.ixo.movieinfo.repositories.IxoUserRepo;
import com.ixo.movieinfo.services.impl.IxoUserServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class IxoUserServiceTest {
	
//	private MockMvc mockMvc;
	
	@Mock
	IxoUserService ixoUserService;
	
	@InjectMocks
	IxoUserServiceImpl ixoUserServiceImpl;
	
}
