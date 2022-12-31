package com.sight.boardapi.application.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {
  private final AppUserNativeRepository nativeRepository;
  private final AppUserRepository appUserRepository;
}
