package org.example.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final Environment env;

    @GetMapping("/profile")
    public String profile() throws SQLException {

        // 현재 실행 중인 ActiveProfile을 모두 가져옴
        // real,oauth,real-db 등 활성화되어 있는 프로필을 가져옴
        List<String> profiles = Arrays.asList(env.getActiveProfiles());

        List<String> realProfiles = Arrays.asList("real", "real1", "real2");

        StringBuilder sb = new StringBuilder();
        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);
        String profile = profiles.stream().filter(realProfiles::contains).findAny().orElse(defaultProfile);
        profiles.stream().forEach(sb::append);

        return profile + " ======== " + sb.toString();
    }
}
