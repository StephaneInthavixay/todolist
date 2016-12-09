package fr.icdc.dei.todolist.persistence.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.icdc.dei.todolist.persistence.entity.Task;

public interface TaskDao extends JpaRepository<Task, Long>{

	Task findByLabel(String label);
	
	List<Task> findAllByUserId(long idUser);
	
	List<Task> findAllByEndingDate(Date endingDate);
	
	List<Task> findAllByEndingDateIsNotNull();

	List<Task> findAllByEndingDateBetween(Date firstPrevisionalDate, Date secondPrevisionalDate);
	
	List<Task> findAllByEndingDateIsNotNullAndEndingDateBetween(Date firstprevisionalDate, Date secondprevisionalDate);
	
	List<Task> findAllByUserIdAndEndingDateIsNotNullAndEndingDateBetween(long idUser, Date firstprevisionalDate, Date secondprevisionalDate);
}
