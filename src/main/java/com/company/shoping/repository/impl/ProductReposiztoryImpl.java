package com.company.shoping.repository.impl;

import com.company.shoping.model.Product;
import com.company.shoping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductReposiztoryImpl implements ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Product insert(Product entity) {
        log.info("ActionLog.{}.insert.start - {}",getClass().getSimpleName());
        var sql="insert into products( name, price, stock) VALUES (:name,:price,:stock)";
        var param=new MapSqlParameterSource()
                .addValue("name",entity.getName())
                .addValue("price",entity.getPrice())
                .addValue("stock",entity.getStock());
        var keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(sql,param,keyHolder,new String[]{"id"});
        entity.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        log.info("ActionLog.{}.insert.end - {}",getClass().getSimpleName());
        return entity;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Product updateById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Product> findByName(String name) {
        try {
            log.info("ActionLog.{}.findByName.start - {}",getClass().getSimpleName());
            var sql="select id, name, price, stock from products where name=:name";
            var param=new MapSqlParameterSource()
                    .addValue("name",name);
            var product=jdbcTemplate.queryForObject(sql,param,(rs, rowNum) -> Product.builder()
                    .name(rs.getString("name"))
                    .price(rs.getLong("price"))
                    .stock(rs.getLong("stock"))
                    .build());
            log.info("ActionLog.{}.findByName.end - {}",getClass().getSimpleName());
            return Optional.of(product);
        }catch (DataAccessException e) {
            log.error("ActionLog.{}.findByName.error- {} ",getClass().getSimpleName(),e);
            return Optional.empty();
        }
    }
}
