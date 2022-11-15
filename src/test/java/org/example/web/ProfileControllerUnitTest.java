package org.example.web;

import org.example.web.ProfileController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.env.MockEnvironment;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 스프링 환경이 필요하지 않기 때문에 springbootTest 없이 사용
 */
public class ProfileControllerUnitTest {

    @Test
    public void real_profile() throws SQLException {
        //given
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        assertThat(profile).contains(expectedProfile);
    }

    @Test
    public void active_profile이_없으면_default_조회() throws SQLException {
        // given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        assertThat(profile).contains(expectedProfile);
    }

}
