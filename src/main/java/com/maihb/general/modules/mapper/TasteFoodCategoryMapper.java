package com.maihb.general.modules.mapper;

import com.maihb.general.modules.entity.TasteFoodCategory;
import com.maihb.general.modules.entity.TasteFoodCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TasteFoodCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taste_food_category
     *
     * @mbg.generated Wed Mar 28 17:27:40 CST 2018
     */
    long countByExample(TasteFoodCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taste_food_category
     *
     * @mbg.generated Wed Mar 28 17:27:40 CST 2018
     */
    int deleteByExample(TasteFoodCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taste_food_category
     *
     * @mbg.generated Wed Mar 28 17:27:40 CST 2018
     */
    int insert(TasteFoodCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taste_food_category
     *
     * @mbg.generated Wed Mar 28 17:27:40 CST 2018
     */
    int insertSelective(TasteFoodCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taste_food_category
     *
     * @mbg.generated Wed Mar 28 17:27:40 CST 2018
     */
    List<TasteFoodCategory> selectByExample(TasteFoodCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taste_food_category
     *
     * @mbg.generated Wed Mar 28 17:27:40 CST 2018
     */
    int updateByExampleSelective(@Param("record") TasteFoodCategory record, @Param("example") TasteFoodCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taste_food_category
     *
     * @mbg.generated Wed Mar 28 17:27:40 CST 2018
     */
    int updateByExample(@Param("record") TasteFoodCategory record, @Param("example") TasteFoodCategoryExample example);
}