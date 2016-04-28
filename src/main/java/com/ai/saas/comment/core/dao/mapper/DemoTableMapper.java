package com.ai.saas.comment.core.dao.mapper;

import com.ai.saas.comment.core.model.dto.DemoTable;
import com.ai.saas.comment.core.model.dto.DemoTableCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoTableMapper {
    int countByExample(DemoTableCriteria example);

    int deleteByExample(DemoTableCriteria example);

    int deleteByPrimaryKey(Integer demoId);

    int insert(DemoTable record);

    int insertSelective(DemoTable record);

    List<DemoTable> selectByExample(DemoTableCriteria example);

    DemoTable selectByPrimaryKey(Integer demoId);

    int updateByExampleSelective(@Param("record") DemoTable record, @Param("example") DemoTableCriteria example);

    int updateByExample(@Param("record") DemoTable record, @Param("example") DemoTableCriteria example);

    int updateByPrimaryKeySelective(DemoTable record);

    int updateByPrimaryKey(DemoTable record);
}