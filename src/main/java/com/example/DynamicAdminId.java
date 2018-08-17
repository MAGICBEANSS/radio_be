package com.example;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DynamicAdminId implements IdentifierGenerator {


	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		String prefix = "admin_";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();
            System.out.println("admin details ");
            ResultSet rs=statement.executeQuery("select count(adminid) from admin_details");    
            if(rs.next())
            {
            
                Long id=rs.getLong(1)+new Long(10000001)*100;
                String generatedId = prefix + new Long(id).toString();
                System.out.println("Generated Admin Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
	}
	
}
