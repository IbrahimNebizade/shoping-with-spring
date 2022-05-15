package com.company.shoping.repository.impl;

import com.company.shoping.model.Bill;
import com.company.shoping.model.Product;
import com.company.shoping.model.User;
import com.company.shoping.repository.BillRepository;
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
public class BillRepositoryImpl implements BillRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Bill insert(Bill entity) {
        log.info("ActionLog.{}.insert.start - {]",getClass().getSimpleName());
        var sql="insert into bills( user_id, total_price, admin_confirmed, product_id) VALUES (:userId,:totalPrice,:adminConfirmed,:productId)";
        var params=new MapSqlParameterSource()
                .addValue("userId",entity.getUser().getId())
                .addValue("totalPrice",entity.getTotalPrice())
                .addValue("adminConfirmed",entity.isAdminConfirmed())
                .addValue("productId",entity.getProduct().getId());
        var keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(sql,params,keyHolder,new String[]{"id"});
        entity.setId(Objects.requireNonNull(keyHolder.getKey().longValue()));
        log.info("ActionLog.{}.insert.end - {]",getClass().getSimpleName());
        return entity;
    }

    @Override
    public Optional<Bill> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Bill updateById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Bill> findByUserId(Long userId) {
        try {
            log.info("ActionLog.{}.findByUserId.start - {}",getClass().getSimpleName());
            var sql="select id, user_id, total_price, bill_date, admin_confirmed, product_id from bills where user_id=:userId";
            var param=new MapSqlParameterSource()
                    .addValue("userId",userId);
            var bill=jdbcTemplate.queryForObject(sql,param,(rs, rowNum) -> Bill.builder()
                    .id(rs.getLong("id"))
                    .user(User.builder().id(rs.getLong("user_id")).build())
                    .totalPrice(rs.getLong("total_price"))
                    .billDate(rs.getDate("bill_date"))
                    .adminConfirmed(rs.getBoolean("admin_confirmed"))
                    .product(Product.builder().id(rs.getLong("product_id")).build())
                    .build());
            log.info("ActionLog.{}.findByUserId.end - {}",getClass().getSimpleName());
            return Optional.of(bill);
        }catch (DataAccessException e) {
            log.error("ActionLog.{}.findByUserId.error- {} ",getClass().getSimpleName(),e);
            return Optional.empty();
        }
    }
}
