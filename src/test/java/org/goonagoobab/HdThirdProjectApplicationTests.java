package org.goonagoobab;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HdThirdProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@edudb_high?TNS_ADMIN=/Users/choilwoo/Desktop/dev64/Wallet_edudb", "goonagoobob", "Ygcha09365283")) {

			if (connection != null) {
				System.out.println("DB Connection Success!");
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
