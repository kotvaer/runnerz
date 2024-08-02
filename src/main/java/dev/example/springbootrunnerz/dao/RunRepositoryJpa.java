package dev.example.springbootrunnerz.dao;

import dev.example.springbootrunnerz.pojo.Location;
import dev.example.springbootrunnerz.pojo.Run;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RunRepositoryJpa extends JpaRepository<Run, Long> {
    //@Query("select r from Run r where r.location = :location")
    List<Run> findAllByLocation(Location location);
}
