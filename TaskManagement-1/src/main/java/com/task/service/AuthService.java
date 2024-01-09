package com.task.service;

import com.task.payload.LoginDto;
import com.task.payload.RegisterDto;

public interface AuthService {
	String login(LoginDto loginDto);
	String register(RegisterDto registerDto);

}
