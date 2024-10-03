package com.dp.userservice.refresh_token;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

public class RefreshTokenService {



    @Scheduled(cron = "0 0 0 * * 1-7")
    @Transactional
    public int deleteExpiredTokens() {
        return refreshTokenRepository.deleteByExpiresAtBefore(Instant.now());
    }
}
