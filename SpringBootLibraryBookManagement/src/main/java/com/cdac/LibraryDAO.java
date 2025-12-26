package com.cdac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryDAO {
	private final JdbcTemplate jdbcTemplate;
	
	public LibraryDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void save(Book book) {
		String sql = "INSERT INTO books VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,book.getBookId(),
				book.getName(),
				book.getAuthor(),
				book.getPrice());
	}
	
	public List<Book> viewAll(){
		String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new RowMapper<Book>() {
        	public Book mapRow(ResultSet rs , int rowNum) throws SQLException {
        		return new Book(rs.getInt("bookId"),
        				rs.getString("name"),
        				rs.getString("author"),
        				rs.getDouble("price"));
        	}
        });
	}
}
