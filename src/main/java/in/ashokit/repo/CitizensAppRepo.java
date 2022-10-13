package in.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.CitizensApp;

public interface CitizensAppRepo extends JpaRepository<CitizensApp, Serializable> {

}
