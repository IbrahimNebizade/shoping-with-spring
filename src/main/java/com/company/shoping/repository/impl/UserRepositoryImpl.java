package com.company.shoping.repository.impl;

import com.company.shoping.model.Role;
import com.company.shoping.model.User;
import com.company.shoping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public User insert(User entity) {
        log.info("ActionLog.{}.insert.start",getClass().getSimpleName());
        var sql = "insert into users( name, surname, birth_date, role_id) VALUES (:name,:surname,:birthDate,:roleId)";
        var params = new MapSqlParameterSource()
                .addValue("name", entity.getName())
                .addValue("surname",entity.getSurname())
                .addValue("birthDate",entity.getBirthDate())
                .addValue("roleId",entity.getRole());
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params, keyHolder, new String[]{"id"});
        entity.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        log.info("ActionLog.{}.insert.end",getClass().getSimpleName());
        return entity;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        try {
            log.info("ActionLog.{}.findById.start",getClass().getSimpleName());
            var sql="select id,name,surname,birth_date,created_at,role_id from users where id=:id";
            var param=new MapSqlParameterSource()
                    .addValue("id",aLong);
            var user=jdbcTemplate.queryForObject(sql,param,(rs, rowNum) -> User.builder()
                     .id(rs.getLong("id"))
                     .name(rs.getString("name"))
                     .surname(rs.getString("surname"))
                     .birthDate(rs.getDate("birth_date"))
                     .createdAt(rs.getTimestamp("created_at"))
                     .role(Role.builder().id(rs.getLong("role_id")).build())
                     .build());
            log.info("ActionLog.{}.findById.end",getClass().getSimpleName());
            return Optional.of(user);
        }catch (DataAccessException e){
            log.error("ActionLog.{}.findById.error- {} ",getClass().getSimpleName(),e);
            return Optional.empty();
        }
    }
    @Override
    public User updateById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

}
