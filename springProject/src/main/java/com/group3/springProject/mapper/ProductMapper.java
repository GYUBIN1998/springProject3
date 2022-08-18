package com.group3.springProject.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.group3.springProject.dto.Product;
//com.group3.springProject.mapper.ProductMapper
@Mapper
public interface ProductMapper {
	public List<Product> selectAll(int startRow, int row);
	public int selectAllCount();
	public Product selectFindOne(String prodId);
}
