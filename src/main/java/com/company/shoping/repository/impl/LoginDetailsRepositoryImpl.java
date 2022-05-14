package com.company.shoping.repository.impl;

import com.company.shoping.model.User;
import com.company.shoping.model.UserLoginDetails;
import com.company.shoping.repository.LoginDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
@Slf4j
public class LoginDetailsRepositoryImpl implements LoginDetailsRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public UserLoginDetails insert(UserLoginDetails entity) {
        log.info("ActionLog.{}.insert.start - {}",getClass().getSimpleName());
        var sql="insert into user_login_details(user_id, email, password, phone) VALUES (:userId,:email,:password,:phone)";
        var param=new MapSqlParameterSource()
                .addValue("userId",entity.getUser().getId())
                .addValue("email",entity.getEmail())
                .addValue("password",entity.getPassword() )
                .addValue("phone",entity.getPhone());
        jdbcTemplate.update(sql,param);
        log.info("ActionLog.{}.insert.end - {}",getClass().getSimpleName());
        return entity;
    }

    @Override
    public Optional<UserLoginDetails> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public UserLoginDetails updateById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<UserLoginDetails> findUnique(String email, String number) {
        try {
            log.info("ActionLog.{}.findUnique.start - {}",getClass().getSimpleName());
            var sql = "select email,phone from user_login_details where email=:email or phone=:phone";
            var param = new MapSqlParameterSource()
                    .addValue("email", email)
                    .addValue("phone", number);
            var user=jdbcTemplate.queryForObject(sql, param, (rs, rowNum) -> UserLoginDetails.builder()
                    .email(rs.getString("email"))
                    .password(rs.getString("password"))
                    .phone(rs.getString("phone"))
                    .build());
            log.info("ActionLog.{}.findUnique.end - {}",getClass().getSimpleName());
            return Optional.of(user);
        }catch (DataAccessException e) {
            log.error("ActionLog.{}.findUnique.error- {}",getClass().getSimpleName(),e);
            return Optional.empty();
        }
    }
}
