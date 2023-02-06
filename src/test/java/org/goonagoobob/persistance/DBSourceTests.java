package org.goonagoobob.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.goonagoobob.HdThirdProjectApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
public class DBSourceTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@edudb_high?TNS_ADMIN=C:////dev64//oracleWallet_3",
					"goonagoobob", "Ygcha09365283");
			System.out.println(con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
