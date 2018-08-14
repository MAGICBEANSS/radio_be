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

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.example.entity.userDetails;

public class StockCodeGenerator implements IdentifierGenerator {

	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		String prefix = "Mr";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();
            System.out.println("fsdf");
            ResultSet rs=statement.executeQuery("select count(userId) from USER_DETAILS");    
            if(rs.next())
            {
            
                Long id=rs.getLong(1)+new Long(10000001)*100;
                String generatedId = prefix + new Long(id).toString();
                System.out.println("Generated Id: " + id);
                return id.toString();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
	}

}
