package com.example;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StockCodeGenerator implements IdentifierGenerator {

	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		String prefix = "Mr";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();
            System.out.println("fsdf");

//            ResultSet rs=statement.executeQuery("select * from entity.USER_DETAILS");
//            	System.out.println(rs);
//                int id=rs.getInt(1)+101;
            	Random random = new Random();
            	int rnd = random.nextInt(100);
                String generatedId = prefix + rnd;
                System.out.println("Generated Id: " + generatedId);
                System.out.println(generatedId + " Generated Id");
                return generatedId;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
	}

}
