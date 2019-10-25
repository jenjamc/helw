package com.netc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoTable {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public HelTable getTable(){
        String sql="select * from HelWorld";
        return template.queryForObject(sql, new Object[]{},new BeanPropertyRowMapper<HelTable>(HelTable.class));
    }
    public List<HelTable> getString(){
        return template.query("select * from HelWorld",new RowMapper<HelTable>(){
            public HelTable mapRow(ResultSet rs, int row) throws SQLException {
                HelTable table=new HelTable();
                table.setId(rs.getInt(1));
                table.setName(rs.getString(2));
                return table;
            }
        });
    }
}