package com.qa.demo.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.qa.demo.persistence.domain.Person;
import com.qa.demo.persistence.repo.PersonRepo;

@DataJpaTest
@TestMethodOrder(Alphanumeric.class)
public class PersonRepoTest {

	@Autowired
	private PersonRepo repo;

	private final Person TEST_PERSON_1 = new Person(1L, 26, "Jordan Harrison");

	private final Person TEST_PERSON_2 = new Person(2L, 25, "Nick Johnson");

	private final Person TEST_PERSON_3 = new Person(3L, 25, "Chris Perrins");

	private final Person TEST_PERSON_4 = new Person(4L, 33, null);

	private List<Person> results;

	@BeforeEach
	public void init() {
		this.results = new ArrayList<>();
	}

	@Test
	public void testFindByNameSQL() throws Exception {
		this.results.add(TEST_PERSON_1);

		assertThat(this.repo.findPersonByNameSQL(TEST_PERSON_1.getName())).isEqualTo(results);
	}

	@Test
	public void testFindByNameJPQL() throws Exception {
		this.results.add(TEST_PERSON_1);

		assertThat(this.repo.findPersonByNameJPQL(TEST_PERSON_1.getName())).isEqualTo(results);
	}

	@Test
	public void testFindByNameAndAgeSQL() throws Exception {
		assertThat(this.repo.findPersonByNameAndAgeSQL(this.TEST_PERSON_2.getName(), this.TEST_PERSON_2.getAge()))
				.isEqualTo(this.TEST_PERSON_2);
	}

	@Test
	public void testFindByNameAndAgeJPQL() throws Exception {
		assertThat(this.repo.findPersonByNameAndAgeJPQL(this.TEST_PERSON_2.getName(), this.TEST_PERSON_2.getAge()))
				.isEqualTo(this.TEST_PERSON_2);
	}

	@Test
	public void testFindAll() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findAllSQL()).isEqualTo(results);
	}

	@Test
	public void testFindAllSQL() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findAllSQL()).isEqualTo(results);
	}

	@Test
	public void testFindAllJPQL() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findAllJPQL()).isEqualTo(results);
	}

	@Test
	public void testFindPersonByAgeGreaterThan() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findPersonByAgeGreaterThan(25)).isEqualTo(this.results);
	}

	@Test
	public void testFindPersonByAgeGreaterThanJPQL() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findPersonByAgeGreaterThanJPQL(25)).isEqualTo(this.results);
	}

	@Test
	public void testFindPersonByAgeGreaterThanSQL() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findPersonByAgeGreaterThanJPQL(25)).isEqualTo(this.results);
	}

	@Test
	public void testFindPersonByAgeLessThan() {
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);

		assertThat(this.repo.findPersonByAgeLessThan(26)).isEqualTo(this.results);
	}

	@Test
	public void testFindPersonByAgeLessThanJPQL() {
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);

		assertThat(this.repo.findPersonByAgeLessThanJPQL(26)).isEqualTo(this.results);
	}

	@Test
	public void testFindPersonByAgeLessThanSQL() {
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);

		assertThat(this.repo.findPersonByAgeLessThanSQL(26)).isEqualTo(this.results);
	}

	@Test
	public void testfindPersonByNameIsNotNull() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);

		assertThat(this.repo.findPersonByNameIsNotNull()).isEqualTo(results);
	}

	@Test
	public void testfindPersonByNameIsNotNullJPQL() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);

		assertThat(this.repo.findPersonByNameIsNotNullJPQL()).isEqualTo(results);
	}

	@Test
	public void testfindPersonByNameIsNotNullSQL() {
		this.results.add(TEST_PERSON_1);
		this.results.add(TEST_PERSON_2);
		this.results.add(TEST_PERSON_3);

		assertThat(this.repo.findPersonByNameIsNotNullSQL()).isEqualTo(results);
	}

	@Test
	public void testFindPersonByNameIsNull() {
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findPersonByNameIsNull()).isEqualTo(this.results);
	}

	@Test
	public void testFindPersonByNameIsNullJPQL() {
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findPersonByNameIsNullJPQL()).isEqualTo(this.results);
	}

	@Test
	public void testFindPersonByNameIsNullSQL() {
		this.results.add(TEST_PERSON_4);

		assertThat(this.repo.findPersonByNameIsNullSQL()).isEqualTo(this.results);
	}

}
