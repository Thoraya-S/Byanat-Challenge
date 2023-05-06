package byanattowersappws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import byanattowersappws.model.Tower;

@Repository
public interface TowerRepository extends JpaRepository<Tower, Integer> {

}
