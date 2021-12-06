package co.edu.unbosque.finalproject.repositories;

import co.edu.unbosque.finalproject.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, String> {
}
