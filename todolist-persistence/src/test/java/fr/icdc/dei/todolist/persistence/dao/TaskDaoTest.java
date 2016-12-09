package fr.icdc.dei.todolist.persistence.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import fr.icdc.dei.todolist.persistence.entity.Task;

public class TaskDaoTest extends AbstractDaoTest {

	private static final String TEST_FINDABLE_LABEL_DB = "testFindableLabelDB";
	private static final long TEST_FINDABLE_TASK_USER_ID = 1;

	private static final Calendar TEST_FINDABLE_TASK_ENDING_DATE_DB = GregorianCalendar.getInstance();
	private static final int TEST_FINDABLE_ENDING_DATE_DAY = 12;
	private static final int TEST_FINDABLE_ENDING_DATE_MONTH = 12;
	private static final int TEST_FINDABLE_ENDING_DATE_YEAR = 2000;
	
	private static final Calendar TEST_FINDABLE_TASK_FIRST_PREVISIONAL_DATE_DB = GregorianCalendar.getInstance();
	private static final int TEST_FINDABLE_FIRST_PREVISIONAL_DATE_DAY = 10;
	private static final int TEST_FINDABLE_FIRST_PREVISIONAL_DATE_MONTH = 12;
	private static final int TEST_FINDABLE_FIRST_PREVISIONAL_DATE_YEAR = 2000;
	
	private static final Calendar TEST_FINDABLE_TASK_SECOND_PREVISIONAL_DATE_DB = GregorianCalendar.getInstance();
	private static final int TEST_FINDABLE_SECOND_PREVISIONAL_DATE_DAY = 12;
	private static final int TEST_FINDABLE_SECOND_PREVISIONAL_DATE_MONTH = 12;
	private static final int TEST_FINDABLE_SECOND_PREVISIONAL_DATE_YEAR = 2000;
	
	@Autowired
	private TaskDao taskDao;
	
	private final static Task task = new Task();

	@Test
	public void testCreateTask() {
		task.setLabel("");
		assertNotNull(taskDao.save(task));
	}
	
	@Test
	public void testTaskIsFindableByLabel() {
		assertNotNull(taskDao.findByLabel(TEST_FINDABLE_LABEL_DB));
	}
	
	@Test
	public void testTaskIsFindableByIdUser() {
		assertNotNull(taskDao.findAllByUserId(TEST_FINDABLE_TASK_USER_ID));
	}
	
	@Test
	public void testTaskIsFindableByEndingDate() {
		TEST_FINDABLE_TASK_ENDING_DATE_DB.set(TEST_FINDABLE_ENDING_DATE_YEAR, TEST_FINDABLE_ENDING_DATE_MONTH, TEST_FINDABLE_ENDING_DATE_DAY);
		assertNotNull(taskDao.findAllByEndingDate(TEST_FINDABLE_TASK_ENDING_DATE_DB.getTime()));
	}
	
	
	@Test
	public void testTaskIsFindableAndDone() {
		assertNotNull(taskDao.findAllByEndingDateIsNotNull());
	}
	
	@Test
	public void testTaskIsFindableByEndingDateBetweenFirstPrevisionalDateAndSecondPrevisionalDate() {
		TEST_FINDABLE_TASK_FIRST_PREVISIONAL_DATE_DB.set(TEST_FINDABLE_FIRST_PREVISIONAL_DATE_YEAR, TEST_FINDABLE_FIRST_PREVISIONAL_DATE_MONTH, TEST_FINDABLE_FIRST_PREVISIONAL_DATE_DAY);
		TEST_FINDABLE_TASK_SECOND_PREVISIONAL_DATE_DB.set(TEST_FINDABLE_SECOND_PREVISIONAL_DATE_YEAR, TEST_FINDABLE_SECOND_PREVISIONAL_DATE_MONTH, TEST_FINDABLE_SECOND_PREVISIONAL_DATE_DAY);
		assertNotNull(taskDao.findAllByEndingDateBetween(TEST_FINDABLE_TASK_FIRST_PREVISIONAL_DATE_DB.getTime(), TEST_FINDABLE_TASK_SECOND_PREVISIONAL_DATE_DB.getTime()));
	}
	
	
	@Test
	public void testTaskIsFindableAndDoneBetweenFirstPrevisionalDateAndSecondPrevisionalDate() {
		TEST_FINDABLE_TASK_FIRST_PREVISIONAL_DATE_DB.set(TEST_FINDABLE_FIRST_PREVISIONAL_DATE_YEAR, TEST_FINDABLE_FIRST_PREVISIONAL_DATE_MONTH, TEST_FINDABLE_FIRST_PREVISIONAL_DATE_DAY);
		TEST_FINDABLE_TASK_SECOND_PREVISIONAL_DATE_DB.set(TEST_FINDABLE_SECOND_PREVISIONAL_DATE_YEAR, TEST_FINDABLE_SECOND_PREVISIONAL_DATE_MONTH, TEST_FINDABLE_SECOND_PREVISIONAL_DATE_DAY);
		assertNotNull(taskDao.findAllByEndingDateIsNotNullAndEndingDateBetween(TEST_FINDABLE_TASK_FIRST_PREVISIONAL_DATE_DB.getTime(), TEST_FINDABLE_TASK_SECOND_PREVISIONAL_DATE_DB.getTime()));
	}
	
	@Test
	public void testTaskIsFindableByIdUserAndDoneBetweenFirstPrevisionalDateAndSecondPrevisionalDate() {
		TEST_FINDABLE_TASK_FIRST_PREVISIONAL_DATE_DB.set(TEST_FINDABLE_FIRST_PREVISIONAL_DATE_YEAR, TEST_FINDABLE_FIRST_PREVISIONAL_DATE_MONTH, TEST_FINDABLE_FIRST_PREVISIONAL_DATE_DAY);
		TEST_FINDABLE_TASK_SECOND_PREVISIONAL_DATE_DB.set(TEST_FINDABLE_SECOND_PREVISIONAL_DATE_YEAR, TEST_FINDABLE_SECOND_PREVISIONAL_DATE_MONTH, TEST_FINDABLE_SECOND_PREVISIONAL_DATE_DAY);
		assertNotNull(taskDao.findAllByUserIdAndEndingDateIsNotNullAndEndingDateBetween(TEST_FINDABLE_TASK_USER_ID, TEST_FINDABLE_TASK_FIRST_PREVISIONAL_DATE_DB.getTime(), TEST_FINDABLE_TASK_SECOND_PREVISIONAL_DATE_DB.getTime()));
	}
}
