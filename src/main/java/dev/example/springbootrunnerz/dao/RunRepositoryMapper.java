package dev.example.springbootrunnerz.dao;

import dev.example.springbootrunnerz.pojo.Location;
import dev.example.springbootrunnerz.pojo.Run;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface RunRepositoryMapper {

    @Select("SELECT * FROM run")
    List<Run> findAll();

    @Select("SELECT * FROM run WHERE id = #{id}")
    Run findById(long id);

    @Select("SELECT * FROM run WHERE location = #{location}")
    List<Run> findAllByLocation(String upperCase);

    @Insert("INSERT INTO run(location, miles, complete_on, start_on, title) values (#{location},#{miles},#{completeOn},#{startOn},#{title})")
    void save(Run run);

    @Delete("DELETE FROM run WHERE id = #{id}")
    void deleteById(long id);

    @Update("UPDATE run SET location=#{location}, miles=#{miles}, complete_on=#{completeOn},  start_on=#{startOn}, title=#{title} WHERE id = #{id}")
    void updateById(long id, String title, LocalDateTime startOn, LocalDateTime completeOn, Integer miles, Location location);
}
