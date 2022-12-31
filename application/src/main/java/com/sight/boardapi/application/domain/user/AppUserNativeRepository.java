package com.sight.boardapi.application.domain.user;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AppUserNativeRepository {
  private final DSLContext dsl;

}
