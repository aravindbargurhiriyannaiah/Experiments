package com.funkyganesha.domain.onetoone;

/**
 *
 */
public final class SQLStatements {
    public static final String test_tableCreation = "CREATE TABLE test_table (\n" + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + "name VARCHAR(100)\n" + ");";
    public static final String studentTableCreation =
            "create table student (\n" + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + "name VARCHAR(100),\n" + "date_of_birth timestamp ,\n" + "address_id int not null\n" +
                    ");";
    public static final String addressTableCreation =
            "create table address (\n" + "id int not null auto_increment primary key,\n" + "line1 varchar(100) not null,\n" + "line2 varchar(100),\n" +
                    "city varchar(50) not null,\n" + "state varchar(50) not null,\n" + "country varchar(50) not null,\n" + "postal_code varchar(20) not null\n" + ");";


}
